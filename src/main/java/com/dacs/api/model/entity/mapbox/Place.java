package com.dacs.api.model.entity.mapbox;

public class Place {
    private String mapbox_id;
    private String name;
    private String wikidata_id;

    public String getMapbox_id() {
        return mapbox_id;
    }

    public String getName() {
        return name;
    }

    public String getWikidata_id() {
        return wikidata_id;
    }

    public void setMapbox_id(String mapbox_id) {
        this.mapbox_id = mapbox_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWikidata_id(String wikidata_id) {
        this.wikidata_id = wikidata_id;
    }
}