package com.dacs.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.dacs.api.dto.Coords;
import com.dacs.api.model.entity.mapbox.MapboxCoords;
import com.dacs.api.service.MapboxService;

@RestController
@RequestMapping("/mapbox")
@PreAuthorize("hasRole('user_client') or hasRole('admin_client')")
public class MapboxController {
    @PostMapping("/address-to-coords")
    public MapboxCoords addressToCoords(@RequestBody Coords request,
            @Value("${mapbox.access_token}") String ACCESS_TOKEN) {
        MapboxService mapboxService = new MapboxService();
        MapboxCoords coords = mapboxService.getCoordinates(ACCESS_TOKEN, request.getAddress());
        return coords;
    }
}