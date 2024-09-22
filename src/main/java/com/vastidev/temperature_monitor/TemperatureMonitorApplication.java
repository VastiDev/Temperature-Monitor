package com.vastidev.temperature_monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TemperatureMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemperatureMonitorApplication.class, args);
    }

}
