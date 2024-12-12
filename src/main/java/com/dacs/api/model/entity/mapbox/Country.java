package com.dacs.api.model.entity.mapbox;

public class Country {
    private String mapbox_id;
    private String name;
    private String wikidata_id;
    private String country_code;
    private String country_code_alpha_3;

    public String getCountry_code() {
        return country_code;
    }

    public String getCountry_code_alpha_3() {
        return country_code_alpha_3;
    }

    public String getMapbox_id() {
        return mapbox_id;
    }

    public String getName() {
        return name;
    }

    public String getWikidata_id() {
        return wikidata_id;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setCountry_code_alpha_3(String country_code_alpha_3) {
        this.country_code_alpha_3 = country_code_alpha_3;
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