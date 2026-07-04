package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hands-on 4: Country Model Class
 * Represents an airline booking country with properties for code and name.
 */
public class Country {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
    
    private String code;
    private String name;

    // Constructor with debug logging
    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("Inside getCode: {}", code);
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode: {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName: {}", name);
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName: {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
