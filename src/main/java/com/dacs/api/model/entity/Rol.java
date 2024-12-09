package com.dacs.api.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

    @Enumerated(EnumType.STRING)
    private Roles tipoRol;

    public Integer getId() {
        return id;
    }

    @OneToOne(optional = true)
    @JoinColumn(name = "dependencia_id", referencedColumnName = "id")
    private Dependencia dependencia;

    public String getDescripcion() {
        return descripcion;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public Roles getTipoRol() {
        return tipoRol;
    }
}
