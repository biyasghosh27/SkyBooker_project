package com.examly.springapp.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
    private final String jwtSecret = "SECRET_KEY";
    // private final int jwtExpirationMs = 86400000;

    public String generateToken(UserDetails userdetails ){
        Map<String,Object> claims = new HashMap<>();
        claims.put("authorities", userdetails.getAuthorities());
        return createToken(claims, userdetails.getUsername());
    }

    private String createToken(Map<String, Object>claims,String subject){
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(subject)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
            .signWith(SignatureAlgorithm.HS256, jwtSecret)
            .compact();
    }

    public String extractUsername(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token){
        Date expiration = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }
}
