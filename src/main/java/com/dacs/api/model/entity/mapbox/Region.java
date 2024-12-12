package com.dacs.api.model.entity.mapbox;

public class Region {
    private String mapbox_id;
    private String name;
    private String wikidata_id;
    private String region_code;
    private String region_code_full;

    public String getMapbox_id() {
        return mapbox_id;
    }

    public String getName() {
        return name;
    }

    public String getRegion_code() {
        return region_code;
    }

    public String getRegion_code_full() {
        return region_code_full;
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

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public void setRegion_code_full(String region_code_full) {
        this.region_code_full = region_code_full;
    }

    public void setWikidata_id(String wikidata_id) {
        this.wikidata_id = wikidata_id;
    }

}