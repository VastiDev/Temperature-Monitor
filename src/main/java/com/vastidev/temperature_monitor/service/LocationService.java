package com.vastidev.temperature_monitor.service;

import com.vastidev.temperature_monitor.client.WeatherClient;
import com.vastidev.temperature_monitor.domain.Location;
import com.vastidev.temperature_monitor.dtos.WeatherResponseDto;
import com.vastidev.temperature_monitor.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class LocationService {
    
    private final LocationRepository locationRepository;
    private final WeatherClient weatherClient;


    public Location save(Location location) {
        location.setCreated(LocalDateTime.now());
        String cityQuery = location.getCityName() + "," + location.getCountryCode();

        WeatherResponseDto weatherData = getWeatherData(cityQuery);
        location.setTemperature(weatherData.getMain().getTemp());
        location.setWeatherDescription(weatherData.getWeather().get(0).getDescription());

        return locationRepository.save(location);
    }

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public WeatherResponseDto getWeatherData(String cityQuery) {
        String apiKey = "794dfde694ac100dffbd04d05ed2086f";
        return weatherClient.getWeatherData(cityQuery, apiKey, "metric", "pt");
    }
}
