package com.vastidev.temperature_monitor.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LocationDto(
        @NotBlank (message = "Field can not be empty!")
        String cityName,
        String stateName,
        @NotBlank(message = "Field can not be empty!")
        @Size(min = 2, max = 2, message = "The country code must be two characters")
        String countryCode) {
}
