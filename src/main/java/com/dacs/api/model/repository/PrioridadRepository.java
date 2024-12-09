package com.dacs.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dacs.api.model.entity.Prioridad;

public interface PrioridadRepository extends JpaRepository<Prioridad, Integer> {
    // Métodos personalizados opcionales
}
