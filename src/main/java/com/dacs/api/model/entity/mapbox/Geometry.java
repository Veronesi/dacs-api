package com.dacs.api.model.entity.mapbox;

import java.util.List;

public class Geometry {
    private String type;
    private List<Double> coordinates;

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public String getType() {
        return type;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public void setType(String type) {
        this.type = type;
    }

}