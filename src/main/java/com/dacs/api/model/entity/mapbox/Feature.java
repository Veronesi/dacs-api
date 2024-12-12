package com.dacs.api.model.entity.mapbox;

public class Feature {
    private String type;
    private String id;
    private Geometry geometry;
    private Properties properties;

    public Geometry getGeometry() {
        return geometry;
    }

    public String getId() {
        return id;
    }

    public Properties getProperties() {
        return properties;
    }

    public String getType() {
        return type;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setType(String type) {
        this.type = type;
    }
}