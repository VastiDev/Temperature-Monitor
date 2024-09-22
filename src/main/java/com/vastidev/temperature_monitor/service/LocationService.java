package com.vastidev.temperature_monitor.service;

import com.vastidev.temperature_monitor.client.WeatherClient;
import com.vastidev.temperature_monitor.domain.Location;
import com.vastidev.temperature_monitor.dtos.WeatherResponseDto;
import com.vastidev.temperature_monitor.exceptions.CityNotFoundException;
import com.vastidev.temperature_monitor.exceptions.LocationSaveException;
import com.vastidev.temperature_monitor.exceptions.WeatherServiceException;
import com.vastidev.temperature_monitor.repository.LocationRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final WeatherClient weatherClient;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    public Location save(Location location) {
        try {
            location.setCreated(LocalDateTime.now());
            String cityQuery = location.getCityName() + "," + location.getCountryCode();

            WeatherResponseDto weatherData = getWeatherData(cityQuery);
            location.setTemperature(weatherData.getMain().getTemp());
            location.setWeatherDescription(weatherData.getWeather().get(0).getDescription());

            return locationRepository.save(location);
        } catch (CityNotFoundException e){
            throw e;

        } catch (Exception e) {
            throw new LocationSaveException("Error saving location for city: " + location.getCityName() + ". Please check the data and try again.", e);
        }
    }

    public List<Location> getAll() {
        try {
            return locationRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error getting all locations.", e);
        }
    }

    public WeatherResponseDto getWeatherData(String cityQuery) {
        try {
            WeatherResponseDto response = weatherClient.getWeatherData(cityQuery, apiKey, "metric", "pt");
            if (response == null || response.getWeather().isEmpty()) {
                throw new CityNotFoundException("City '" + cityQuery + "' not found in the weather service.");
            }
            return response;

        } catch (FeignException.NotFound e) {
            throw new CityNotFoundException("City '" + cityQuery + "' not found in the weather service.", e);
        } catch (Exception e) {
            throw new WeatherServiceException("Error getting weather data for city: " + cityQuery + ". Check the city name and try again.", e);
        }
    }
}
