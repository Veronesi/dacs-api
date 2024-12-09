package com.dacs.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dacs.api.model.entity.Dependencia;

public interface DependenciaRepository extends JpaRepository<Dependencia, Integer> {

}