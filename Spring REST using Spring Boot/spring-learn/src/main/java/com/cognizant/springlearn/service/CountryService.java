package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * REST - Get country based on country code
 * Service class handling core lookup logic on XML configured countries list.
 */
@Service
public class CountryService {

    /**
     * Finds country matching the specified ISO code case-insensitively.
     * Throws CountryNotFoundException if no match is found.
     */
    @SuppressWarnings("unchecked")
    public Country getCountry(String code) throws CountryNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        ArrayList<Country> countryList = context.getBean("countryList", ArrayList.class);

        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country with code " + code + " not found"));
    }
}
