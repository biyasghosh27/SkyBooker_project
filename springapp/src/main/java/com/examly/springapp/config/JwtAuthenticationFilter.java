package com.examly.springapp.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private ProjectUserDetailsService projectUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException{
        
        String path = request.getServletPath();
        System.out.println("Request Path: " + path);

        //Bypassing only login and register endpoints

        if(path.contains("/api/login") || path.contains("/api/register")){
            System.out.println("Skipping token filter for path: " + path);
            filterChain.doFilter(request, response);
            return;
        }
        
        final String authHeader = request.getHeader("Authorization");

           String email = null;
           String jwt = null;

           if(authHeader != null && authHeader.startsWith("Bearer ")){
            jwt = authHeader.substring(7);
            System.out.println("Extracted JWT:" + jwt);
            email = jwtUtils.extractUsername(jwt);
            System.out.println("Extracted Email:" + email);
           }

           if(email!=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = projectUserDetailsService.loadUserByUsername(email);

            System.out.println("UserDetails found: " + userDetails.getUsername());

            if(jwtUtils.validateToken(jwt, userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }else{
                System.out.println("JWT validation failed");
            }
           }else{
            System.out.println("Email is null or user already authenticated");
           }
           filterChain.doFilter(request, response);
    }
    
}
