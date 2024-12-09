package com.dacs.api.model.types;

public record Direccion(String cp, String calle, String direccion) {
    public String cp() {
        return this.cp;
    }

    public String calle() {
        return this.calle;
    }

    public String direccion() {
        return this.direccion;
    }
}