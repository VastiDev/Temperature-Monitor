package com.vastidev.temperature_monitor.exceptions;

public class LocationSaveException extends RuntimeException{
    public LocationSaveException(String message){
        super(message);
    }

    public LocationSaveException(String message, Throwable cause){
        super(message, cause);
    }
}
