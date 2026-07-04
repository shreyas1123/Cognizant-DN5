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

    @Autowired
    private com.cognizant.springlearn.dao.EmployeeDao employeeDao;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        employeeDao.reset();
    }

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

    // Hands-on 4: Test for POST /countries validation failure
    @Test
    public void testAddCountryValidationError() throws Exception {
        String invalidCountryJson = "{\"code\":\"I\",\"name\":\"India\"}";
        ResultActions actions = mvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post("/countries")
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .content(invalidCountryJson)
        );
        actions.andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.errors").isArray())
               .andExpect(jsonPath("$.errors[0]").value("Country code should be 2 characters"));
    }

    // Hands-on 4: Test for PUT /employees success
    @Test
    public void testUpdateEmployeeSuccess() throws Exception {
        String employeeJson = "{"
            + "\"id\":1,"
            + "\"name\":\"John Updated\","
            + "\"salary\":55000.0,"
            + "\"gender\":\"Male\","
            + "\"permanent\":true,"
            + "\"dateOfBirth\":\"31/12/1990\","
            + "\"department\":{\"id\":2,\"name\":\"Technology\"},"
            + "\"skills\":[{\"id\":1,\"name\":\"Java\"}]"
            + "}";
        ResultActions actions = mvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put("/employees")
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .content(employeeJson)
        );
        actions.andExpect(status().isOk());

        // Verify update happened
        ResultActions getActions = mvc.perform(get("/employees"));
        getActions.andExpect(status().isOk())
                  .andExpect(jsonPath("$[0].name").value("John Updated"))
                  .andExpect(jsonPath("$[0].salary").value(55000.0));
    }

    // Hands-on 4: Test for PUT /employees validation failure
    @Test
    public void testUpdateEmployeeValidationError() throws Exception {
        String invalidEmployeeJson = "{"
            + "\"id\":1,"
            + "\"name\":\"\"," // invalid blank name
            + "\"salary\":-500.0," // invalid negative salary
            + "\"gender\":\"Male\","
            + "\"permanent\":null," // invalid null permanent
            + "\"dateOfBirth\":\"31/12/1990\","
            + "\"department\":{\"id\":2,\"name\":\"Technology\"},"
            + "\"skills\":[{\"id\":1,\"name\":\"Java\"}]"
            + "}";
        ResultActions actions = mvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put("/employees")
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .content(invalidEmployeeJson)
        );
        actions.andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.errors").isArray());
    }

    // Hands-on 4: Test for PUT /employees format error (String sent to numeric field id)
    @Test
    public void testUpdateEmployeeFormatError() throws Exception {
        String badFormatJson = "{"
            + "\"id\":\"abc\"," // invalid string format for id
            + "\"name\":\"John Doe\","
            + "\"salary\":50000.0,"
            + "\"gender\":\"Male\","
            + "\"permanent\":true,"
            + "\"dateOfBirth\":\"31/12/1990\""
            + "}";
        ResultActions actions = mvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put("/employees")
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .content(badFormatJson)
        );
        actions.andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.error").value("Bad Request"))
               .andExpect(jsonPath("$.message").value("Incorrect format for field 'id'"));
    }

    // Hands-on 4: Test for DELETE /employees/{id} success and exception
    @Test
    public void testDeleteEmployee() throws Exception {
        // ID 4 exists
        ResultActions actions = mvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete("/employees/4")
        );
        actions.andExpect(status().isOk());

        // Verify ID 4 is deleted (only 3 employees left)
        ResultActions getActions = mvc.perform(get("/employees"));
        getActions.andExpect(status().isOk())
                  .andExpect(jsonPath("$").isArray())
                  .andExpect(jsonPath("$.length()").value(3));

        // DELETE non-existent ID (should throw exception -> 404 NOT_FOUND)
        ResultActions actionsNotFound = mvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete("/employees/99")
        );
        actionsNotFound.andExpect(status().isNotFound());
    }
}
