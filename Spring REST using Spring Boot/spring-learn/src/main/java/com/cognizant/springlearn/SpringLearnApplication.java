package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Hands-on 1: Spring Web Project Entrypoint
 * Orchestrates loading SimpleDateFormat, Country configurations, and scope verifications.
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START Main Application Bootstrapping");
        SpringApplication.run(SpringLearnApplication.class, args);
        
        // Execute Core Spring XML configuration hands-ons
        displayDate();
        displayCountry();
        displayCountries();
        
        LOGGER.info("END Main Application Bootstrapping");
    }

    // Hands-on 2 & 3: Load SimpleDateFormat and parse Date
    public static void displayDate() {
        LOGGER.info("START displayDate");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date);
        } catch (Exception e) {
            LOGGER.error("Error parsing date: ", e);
        }
        LOGGER.info("END displayDate");
    }

    // Hands-on 4 & 5: Load Country bean and check singleton vs prototype scopes
    public static void displayCountry() {
        LOGGER.info("START displayCountry");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Retrieve country bean twice to verify instantiation count matching scope definitions
        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);
        
        LOGGER.debug("Country : {}", country.toString());
        LOGGER.debug("Another Country (Scope verification) : {}", anotherCountry.toString());
        LOGGER.info("END displayCountry");
    }

    // Hands-on 6: Load list of countries
    @SuppressWarnings("unchecked")
    public static void displayCountries() {
        LOGGER.info("START displayCountries");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
        LOGGER.debug("Country List: {}", countries);
        LOGGER.info("END displayCountries");
    }
}
