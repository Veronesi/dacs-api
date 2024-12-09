package com.dacs.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dacs.api.model.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}