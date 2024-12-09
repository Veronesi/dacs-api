package com.dacs.api.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Prioridad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;

    @OneToMany(mappedBy = "prioridad")
    private List<Ticket> tickets;

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
