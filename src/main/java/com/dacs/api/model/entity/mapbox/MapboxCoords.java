package com.dacs.api.model.entity.mapbox;

import java.util.List;

public class MapboxCoords {
    private String type;
    private List<Feature> features;
    private String attribution;

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttribution() {
        return attribution;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public String getType() {
        return type;
    }
}
