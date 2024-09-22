package com.vastidev.temperature_monitor.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WeatherResponseDto {

    private Main main;
    private List<Weather> weather;

    @JsonProperty("name")
    private String cityName;

    @Data
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int humidity;
    }

    @Data
    public static class Weather {
        private String main;
        private String description;
        private String icon;
    }
}
