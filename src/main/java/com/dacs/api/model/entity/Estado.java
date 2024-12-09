package com.dacs.api.model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Estados estado;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private Ticket ticket;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id")
    private Usuario autor;

    public Integer getId() {
        return id;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}