package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * REST - Country Web Service Controller
 * Refined to align with PDF exercises 5, 6, and 7.
 */
@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    // Constructor log verification check
    public CountryController() {
        LOGGER.info("Inside CountryController Constructor.");
    }

    // Endpoint 1: REST - Country Web Service (India details)
    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("START getCountryIndia");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.info("END getCountryIndia");
        return country;
    }

    // Endpoint 2: REST - Get all countries
    @GetMapping("/countries")
    @SuppressWarnings("unchecked")
    public ArrayList<Country> getAllCountries() {
        LOGGER.info("START getAllCountries");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
        LOGGER.info("END getAllCountries");
        return countries;
    }

    // Endpoint 3: REST - Get country based on country code (robust path mapping support)
    @GetMapping({"/countries/{code}", "/country/{code}"})
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START getCountry with code: {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END getCountry");
        return country;
    }

    // Hands-on 4: POST country mapping with validation
    @PostMapping("/countries")
    public Country addCountry(@RequestBody @jakarta.validation.Valid Country country) {
        LOGGER.info("START addCountry");
        LOGGER.info("Country details: {}", country);
        LOGGER.info("END addCountry");
        return country;
    }
}
