package com.dacs.api.dto;

import java.util.Date;

import com.dacs.api.model.entity.Estados;

public class EstadoDTO {
    private Estados estado;
    private Integer autorId;
    private Date fecha;
    private Integer ticketId;

    public Integer getAutorId() {
        return autorId;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

}
