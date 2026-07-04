package com.cognizant.springlearn.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class for country search exceptions.
 * Annotated to return a BAD_REQUEST (400) status and reason description to match tests.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Country Not found")
public class CountryNotFoundException extends RuntimeException {
    
    public CountryNotFoundException(String message) {
        super(message);
    }
}
