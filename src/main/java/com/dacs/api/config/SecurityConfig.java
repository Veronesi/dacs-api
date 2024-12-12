package com.dacs.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthentificationConverter jwtAuthentificationConverter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOrigins(Arrays.asList(
                            "http://localhost:4200",
                            "http://localhost:8080",
                            "http://localhost:3306",
                            "http://dacs2024"));
                    configuration.addAllowedMethod("GET");
                    configuration.addAllowedMethod("POST");
                    configuration.addAllowedMethod("PUT");
                    configuration.addAllowedMethod("DELETE");
                    configuration.addAllowedHeader("*");
                    configuration.setAllowCredentials(true); // Permite el uso de credenciales
                    return configuration;
                }))
                .authorizeHttpRequests(http -> http
                        .requestMatchers("/keycloak/user/create").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth -> {
                    System.out.print("entro");
                    oauth.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthentificationConverter));
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
