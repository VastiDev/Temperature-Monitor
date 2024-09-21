package com.vastidev.temperature_monitor.repository;

import com.vastidev.temperature_monitor.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {
}
