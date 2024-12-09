package com.dacs.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dacs.api.model.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    // Métodos personalizados opcionales
}
