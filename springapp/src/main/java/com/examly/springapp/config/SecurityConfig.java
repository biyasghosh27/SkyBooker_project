package com.examly.springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;
    
    private final ProjectUserDetailsService userDetailsService;

    private final JwtAuthenticationEntryPoint authEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf->csrf.disable())
        .authorizeHttpRequests(auth->auth
        .requestMatchers(
            "/api/login",
            "/api/register",
            "/api/test/**",
            "/api/flights/**",
            "/swagger-ui/**",
            "/v3/api-docs/**"
        ).permitAll()
        .anyRequest().authenticated()
        )
        .exceptionHandling(ex -> ex.aut)
        .httpBasic();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
