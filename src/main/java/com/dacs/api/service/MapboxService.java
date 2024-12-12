package com.dacs.api.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dacs.api.model.entity.mapbox.MapboxCoords;

@Service
public class MapboxService {
    private final String MAPBOX_URL = "https://api.mapbox.com/search/geocode/v6/forward";

    public MapboxCoords getCoordinates(String ACCESS_TOKEN, String address) {
        String url = String.format(
                "%s?access_token=%s&address_line1=%s&postcode=E3260&country=Argentina&region=Entre Ríos&locality=Concepción del Uruguay&proximity=-58.2820499,-32.4786807&bbox=-58.3273713,-32.5038822,-58.2099128,-32.4341409",
                MAPBOX_URL, ACCESS_TOKEN, address);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MapboxCoords> response = restTemplate.getForEntity(url, MapboxCoords.class);
        try {
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException("Error procesando la respuesta", e);
        }
    }
}