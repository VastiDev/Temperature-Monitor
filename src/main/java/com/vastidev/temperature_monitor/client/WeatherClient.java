package com.vastidev.temperature_monitor.client;

import com.vastidev.temperature_monitor.dtos.WeatherResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient", url = "${openweathermap.api.url}")
public interface WeatherClient {

    @GetMapping("/weather")
    public WeatherResponseDto getWeatherData(
            @RequestParam("q") String city,
            @RequestParam("appid") String apiKey,
            @RequestParam("units") String units,
            @RequestParam("lang") String lang
    );
}

