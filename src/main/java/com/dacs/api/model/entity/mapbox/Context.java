package com.dacs.api.model.entity.mapbox;

import java.util.Optional;

public class Context {
    private Optional<Street> street;
    private Street postcode;
    private Place place;
    private Region region;
    private Country country;

    public Country getCountry() {
        return country;
    }

    public Place getPlace() {
        return place;
    }

    public Street getPostcode() {
        return postcode;
    }

    public Region getRegion() {
        return region;
    }

    public Optional<Street> getStreet() {
        return street;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public void setPostcode(Street postcode) {
        this.postcode = postcode;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void setStreet(Optional<Street> street) {
        this.street = street;
    }

}