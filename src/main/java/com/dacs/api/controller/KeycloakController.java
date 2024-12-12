package com.dacs.api.controller;

import com.dacs.api.dto.UserDTO;
import com.dacs.api.model.entity.Rol;
import com.dacs.api.model.entity.Usuario;
import com.dacs.api.model.repository.RolRepository;
import com.dacs.api.model.repository.UsuarioRepository;
import com.dacs.api.service.IKeycloakService;

import jakarta.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/keycloak/user")
public class KeycloakController {
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private IKeycloakService keycloakService;

    @PostMapping("/create")
    @PermitAll
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) throws URISyntaxException, ParseException {
        UserDTO response = keycloakService.createUser(userDTO);

        Usuario usuario = new Usuario();
        usuario.setNombre(response.getFirstName());
        usuario.setApellido(response.getLastName());
        usuario.setEmail(response.getEmail());
        usuario.setNombre(response.getUsername());
        usuario.setUuid(response.getUuid());
        usuario.setDireccion(userDTO.getDireccion());
        usuario.setDni(userDTO.getDni());
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date date = formatter.parse(userDTO.getFechaNacimiento());
        usuario.setFechaNacimiento(date);
        Rol rol = rolRepository.findById(2).orElseThrow();
        usuario.setRol(rol);

        usuarioRepository.save(usuario);
        return ResponseEntity.created(new URI("/keycloak/user/create")).body(response);
    }

    @PreAuthorize("hasRole('admin_client')")
    @GetMapping("/search")
    public ResponseEntity<?> findAllUsers() {
        return ResponseEntity.ok(keycloakService.findAllUsers());
    }

    @PreAuthorize("hasRole('admin_client')")
    @GetMapping("/search/{username}")
    public ResponseEntity<?> searchUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(keycloakService.searchUserByUsername(username));
    }

    @PreAuthorize("hasRole('admin_client')")
    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody UserDTO userDTO) {
        keycloakService.updateUser(userId, userDTO);
        return ResponseEntity.ok("User updated successfully");
    }

    @PreAuthorize("hasRole('admin_client')")
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        keycloakService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}