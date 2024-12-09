package com.dacs.api.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class Dependencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private MunicipalDependencias nombre;

    // @OneToOne(mappedBy = "dependencia", optional = true)
    // private Rol rol;

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public MunicipalDependencias getNombre() {
        return nombre;
    }

    // public Rol getRol() {
    // return rol;
    // }
}
