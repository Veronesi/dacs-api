package com.dacs.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dacs.api.model.entity.Rol;
import com.dacs.api.model.repository.RolRepository;

import java.util.List;

@RestController
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/rol")
    public List<Rol> obtenerRols() {
        return rolRepository.findAll();
    }
}