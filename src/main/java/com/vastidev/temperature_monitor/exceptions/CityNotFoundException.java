package com.vastidev.temperature_monitor.exceptions;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(String message){
        super(message);
    }

    public CityNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
