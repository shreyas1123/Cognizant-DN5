package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * SpringLearnApplicationTests
 * Tests the endpoints using MockMVC as specified in pages 10-14 of the Spring REST document.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    // Test is the CountryController is loaded
    @Test
    public void contextLoads() {
        assertNotNull(countryController);
    }

    // Test service to get the country
    @Test
    public void testGetCountry() throws Exception {
        ResultActions actions = mvc.perform(get("/country"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.code").exists());
        actions.andExpect(jsonPath("$.code").value("IN"));
        actions.andExpect(jsonPath("$.name").exists());
        actions.andExpect(jsonPath("$.name").value("India"));
    }

    // Test get country service for exceptional scenario
    @Test
    public void testGetCountryException() throws Exception {
        ResultActions actions = mvc.perform(get("/country/az"));
        actions.andExpect(status().isBadRequest());
        actions.andExpect(status().reason("Country Not found"));
    }

    // Additional test for Hello World REST service
    @Test
    public void testSayHello() throws Exception {
        ResultActions actions = mvc.perform(get("/hello"));
        actions.andExpect(status().isOk())
               .andExpect(jsonPath("$").value("Hello World!!"));
    }

    // Additional test for get all countries service
    @Test
    public void testGetAllCountries() throws Exception {
        ResultActions actions = mvc.perform(get("/countries"));
        actions.andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray())
               .andExpect(jsonPath("$[0].code").value("IN"))
               .andExpect(jsonPath("$[1].code").value("US"));
    }

    // Hands-on 3: Test for GET /employees
    @Test
    public void testGetAllEmployees() throws Exception {
        ResultActions actions = mvc.perform(get("/employees"));
        actions.andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray())
               .andExpect(jsonPath("$[0].name").value("John Doe"))
               .andExpect(jsonPath("$[1].name").value("Jane Smith"))
               .andExpect(jsonPath("$[2].name").value("Alice Johnson"))
               .andExpect(jsonPath("$[3].name").value("Bob Lee"));
    }

    // Hands-on 3: Test for GET /departments
    @Test
    public void testGetAllDepartments() throws Exception {
        ResultActions actions = mvc.perform(get("/departments"));
        actions.andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray())
               .andExpect(jsonPath("$[0].name").value("Human Resources"))
               .andExpect(jsonPath("$[1].name").value("Technology"))
               .andExpect(jsonPath("$[2].name").value("Sales"));
    }
}
