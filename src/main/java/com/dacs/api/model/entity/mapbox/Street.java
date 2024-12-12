package com.dacs.api.model.entity.mapbox;

public class Street {
    private String mapbox_id;
    private String name;

    public String getMapbox_id() {
        return mapbox_id;
    }

    public String getName() {
        return name;
    }

    public void setMapbox_id(String mapbox_id) {
        this.mapbox_id = mapbox_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}