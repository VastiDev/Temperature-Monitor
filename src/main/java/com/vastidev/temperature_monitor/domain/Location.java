package com.vastidev.temperature_monitor.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID idLocation;
    private String cityName;
    private String stateName;
    private String countryCode;

    private Double temperature;
    private String weatherDescription;

    private LocalDateTime lastUpdate;

    private LocalDateTime created;

}
