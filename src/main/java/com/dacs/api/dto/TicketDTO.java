package com.dacs.api.dto;

public class TicketDTO {
    private String descripcion;
    private Float latitud;
    private Float longitud;
    private Float costoFinal;
    private Integer creadoPorId;
    private Integer cambiadoPorId;
    private Integer dependenciaId;
    private Integer prioridadId;

    public Integer getCambiadoPorId() {
        return cambiadoPorId;
    }

    public Float getCostoFinal() {
        return costoFinal;
    }

    public Integer getCreadoPorId() {
        return creadoPorId;
    }

    public Integer getDependenciaId() {
        return dependenciaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Float getLatitud() {
        return latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public Integer getPrioridadId() {
        return prioridadId;
    }

    public void setCambiadoPorId(Integer cambiadoPorId) {
        this.cambiadoPorId = cambiadoPorId;
    }

    public void setCostoFinal(Float costoFinal) {
        this.costoFinal = costoFinal;
    }

    public void setCreadoPorId(Integer creadoPorId) {
        this.creadoPorId = creadoPorId;
    }

    public void setDependenciaId(Integer dependenciaId) {
        this.dependenciaId = dependenciaId;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public void setPrioridadId(Integer prioridadId) {
        this.prioridadId = prioridadId;
    }

}
