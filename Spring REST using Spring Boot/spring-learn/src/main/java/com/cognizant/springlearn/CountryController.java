package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * REST - Country Web Service Controller
 * Provides services to retrieve single configured country or filtered country lists.
 */
@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private final ArrayList<Country> countryList;

    @SuppressWarnings("unchecked")
    public CountryController() {
        LOGGER.info("START CountryController Initialization");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        this.countryList = context.getBean("countryList", ArrayList.class);
        LOGGER.info("END CountryController Initialization - Loaded {} countries", countryList.size());
    }

    // REST - Country Web Service (returns default/configured country India)
    @GetMapping("/country")
    public Country getCountry() {
        LOGGER.info("START getCountry");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Returned Country: {}", country);
        LOGGER.info("END getCountry");
        return country;
    }

    // REST - Country Web Service (returns all countries)
    @GetMapping("/countries")
    public ArrayList<Country> getCountries() {
        LOGGER.info("START getCountries");
        LOGGER.debug("Returned Country List: {}", countryList);
        LOGGER.info("END getCountries");
        return countryList;
    }

    // REST - Get country based on country code
    @GetMapping("/countries/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        LOGGER.info("START getCountryByCode - code: {}", code);
        for (Country country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                LOGGER.debug("Matched Country: {}", country);
                LOGGER.info("END getCountryByCode");
                return country;
            }
        }
        LOGGER.warn("Country Code '{}' NOT FOUND - throwing Exception", code);
        LOGGER.info("END getCountryByCode");
        throw new CountryNotFoundException("Country not found for code: " + code);
    }
}
