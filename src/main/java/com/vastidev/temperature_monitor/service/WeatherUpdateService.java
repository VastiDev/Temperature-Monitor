package com.vastidev.temperature_monitor.service;

import com.vastidev.temperature_monitor.client.WeatherClient;
import com.vastidev.temperature_monitor.domain.Location;
import com.vastidev.temperature_monitor.dtos.WeatherResponseDto;
import com.vastidev.temperature_monitor.repository.LocationRepository;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherUpdateService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherUpdateService.class);

    private final LocationRepository locationRepository;
    private final WeatherClient weatherClient;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Scheduled(fixedDelay = 300000) // Executa a cada 5 minutos
    public void updateWeatherData() {
        List<Location> locations = locationRepository.findAll();

        for (Location location : locations) {
            String cityQuery = location.getCityName() + "," + location.getCountryCode();

            try {
                WeatherResponseDto weatherData = weatherClient.getWeatherData(cityQuery, apiKey, "metric", "pt");
                location.setTemperature(weatherData.getMain().getTemp());
                location.setWeatherDescription(weatherData.getWeather().get(0).getDescription());
                location.setLastUpdate(LocalDateTime.now());
                locationRepository.save(location);

            } catch (Exception e) {
                logger.error("Erro ao atualizar dados meteorológicos para a cidade: {}", location.getCityName(), e);

            }
        }
    }
}
