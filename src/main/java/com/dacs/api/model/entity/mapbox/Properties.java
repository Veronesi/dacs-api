package com.dacs.api.model.entity.mapbox;

import java.util.List;
import java.util.Optional;

public class Properties {
    private String mapbox_id;
    private String feature_type;
    private String full_address;
    private String name;
    private String name_preferred;
    private Coordinates coordinates;
    private String place_formatted;
    private Context context;
    private Optional<List<Integer>> bbox;

    public Optional<List<Integer>> getBbox() {
        return bbox;
    }

    public Context getContext() {
        return context;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getFeature_type() {
        return feature_type;
    }

    public String getFull_address() {
        return full_address;
    }

    public String getMapbox_id() {
        return mapbox_id;
    }

    public String getName() {
        return name;
    }

    public String getName_preferred() {
        return name_preferred;
    }

    public String getPlace_formatted() {
        return place_formatted;
    }

    public void setBbox(Optional<List<Integer>> bbox) {
        this.bbox = bbox;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setFeature_type(String feature_type) {
        this.feature_type = feature_type;
    }

    public void setFull_address(String full_address) {
        this.full_address = full_address;
    }

    public void setMapbox_id(String mapbox_id) {
        this.mapbox_id = mapbox_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName_preferred(String name_preferred) {
        this.name_preferred = name_preferred;
    }

    public void setPlace_formatted(String place_formatted) {
        this.place_formatted = place_formatted;
    }
}