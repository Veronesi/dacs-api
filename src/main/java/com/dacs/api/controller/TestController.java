package com.dacs.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

@RestController
public class TestController {

    @GetMapping("/hello-1")
    @PreAuthorize("hasRole('admin_client')")
    public String helloAdmin() {
        return "keycloack works! - ADMIN";
    }

    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('user_client') or hasRole('admin_client')")
    public String helloUser() {
        return "keycloack works! - USER";
    }

    @GetMapping("/get-credentials")
    @PreAuthorize("hasRole('user_client') or hasRole('admin_client')")
    public String getCredentials(Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String userId = jwt.getClaim("sub"); // Obtener el ID del usuario (sub)
        String email = jwt.getClaim("email"); // Obtener el email
        String username = jwt.getClaim("family_name");
        System.out.println(jwt.getClaims().toString());
        return "Usuario ID: " + userId + ", Email: " + email + ", Username: " + username;
    }
}