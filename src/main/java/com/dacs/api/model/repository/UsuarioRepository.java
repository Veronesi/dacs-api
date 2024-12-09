package com.dacs.api.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dacs.api.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Métodos personalizados opcionales
    Optional<Usuario> findByUuid(String uuid);
}
