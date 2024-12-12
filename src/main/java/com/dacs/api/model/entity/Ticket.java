package com.dacs.api.model.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;
    private Double latitud;
    private Double longitud;
    private Float costoFinal;
    private Date fechaHora;

    @Enumerated(EnumType.STRING)
    private Estados estado;

    @ManyToOne
    @JoinColumn(name = "creado_por_id", referencedColumnName = "id")
    private Usuario creadoPor;

    @ManyToOne
    @JoinColumn(name = "cambiado_por_id", referencedColumnName = "id")
    private Usuario cambiadoPor;

    @ManyToOne
    @JoinColumn(name = "dependencia_id", referencedColumnName = "id")
    private Dependencia dependencia;

    @ManyToOne
    @JoinColumn(name = "prioridad_id", referencedColumnName = "id")
    private Prioridad prioridad;

    @OneToMany(mappedBy = "ticket")
    private List<Estado> estados;

    public Integer getId() {
        return id;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Usuario getCambiadoPor() {
        return cambiadoPor;
    }

    public Float getCostoFinal() {
        return costoFinal;
    }

    public Usuario getCreadoPor() {
        return creadoPor;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setCreadoPor(Usuario creadoPor) {
        this.creadoPor = creadoPor;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public void setCambiadoPor(Usuario cambiadoPor) {
        this.cambiadoPor = cambiadoPor;
    }

    public void setCostoFinal(Float costoFinal) {
        this.costoFinal = costoFinal;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

}
