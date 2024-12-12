package com.dacs.api.service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import com.dacs.api.model.entity.keycloak.OpenIdConnect;
import com.dacs.api.model.entity.mapbox.MapboxCoords;

import net.minidev.json.JSONObject;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class MapboxService {
    private String getAuthentification() {

        String url = "http://localhost:8080/realms/dacs/protocol/openid-connect/token";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("client_id", "dacs-client-api");
        map.add("client_secret", "eKiB2A1sJUjUPf8Mf3WER2gG0OgpTFyZ");
        map.add("username", "dacs-api");
        map.add("password", "admin");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<OpenIdConnect> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                OpenIdConnect.class);
        return response.getBody().getAccess_token();

    }

    public MapboxCoords getCoordinates(String ACCESS_TOKEN, String address) {
        String url = "http://localhost:8082/mapbox/address-to-coords";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + getAuthentification());
        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("address", address);

        HttpEntity<String> entity = new HttpEntity<>(personJsonObject.toString(), headers);

        ResponseEntity<MapboxCoords> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                MapboxCoords.class);
        return response.getBody();
    }
}