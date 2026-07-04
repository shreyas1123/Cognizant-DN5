package com.cognizant.springlearn;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * REST - Get country based on country code
 * Exception thrown when the requested country code does not exist.
 * Maps automatically to 404 Not Found HTTP status.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Country not found")
public class CountryNotFoundException extends RuntimeException {
    
    public CountryNotFoundException(String message) {
        super(message);
    }
}
