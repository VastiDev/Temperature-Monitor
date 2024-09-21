package com.vastidev.temperature_monitor.service;

import com.vastidev.temperature_monitor.domain.Location;
import com.vastidev.temperature_monitor.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class LocationService {
    
    private final LocationRepository locationRepository;


    public Location save(Location location) {
        location.setCreated(LocalDateTime.now());
        return locationRepository.save(location);
    }

    public List<Location> getAll() {
        return locationRepository.findAll();
    }
}
