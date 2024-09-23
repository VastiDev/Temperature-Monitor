package com.vastidev.temperature_monitor.controller;

import com.vastidev.temperature_monitor.domain.Location;
import com.vastidev.temperature_monitor.dtos.LocationDto;
import com.vastidev.temperature_monitor.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
@Tag(name = "Location", description = "Management of Locations")
public class LocationController {
    private final LocationService locationService;

    @Operation(summary = "Create a new location", description = "Adds a new location and retrieves its current weather data")
    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody @Valid LocationDto locationDto) {
        Location location = new Location();
        BeanUtils.copyProperties(locationDto, location);
        locationService.save(location);
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all locations", description = "Retrieves all saved locations with their weather data")
    @GetMapping
    public  ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAll();
        return ResponseEntity.ok(locations);
    }

}
