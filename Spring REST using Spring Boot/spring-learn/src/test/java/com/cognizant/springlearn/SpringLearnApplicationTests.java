package com.cognizant.springlearn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * SpringLearnApplicationTests
 * Integration tests utilizing MockMvc to assert GET endpoints behavior.
 */
@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    // Verify /hello endpoint returns "Hello World"
    @Test
    void testSayHello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    // Verify /country endpoint returns India Country properties
    @Test
    void testGetCountry() throws Exception {
        mockMvc.perform(get("/country"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("IN"))
                .andExpect(jsonPath("$.name").value("India"));
    }

    // Verify /countries endpoint returns all 4 configured countries
    @Test
    void testGetCountries() throws Exception {
        mockMvc.perform(get("/countries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].code").value("IN"))
                .andExpect(jsonPath("$[1].code").value("US"))
                .andExpect(jsonPath("$[2].code").value("DE"))
                .andExpect(jsonPath("$[3].code").value("JP"));
    }

    // Verify /countries/{code} endpoint successfully finds and returns a country
    @Test
    void testGetCountryByCodeSuccess() throws Exception {
        mockMvc.perform(get("/countries/US"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("US"))
                .andExpect(jsonPath("$.name").value("United States"));
    }

    // Verify /countries/{code} endpoint throws 404 response on incorrect country code
    @Test
    void testGetCountryByCodeNotFound() throws Exception {
        mockMvc.perform(get("/countries/XX"))
                .andExpect(status().isNotFound());
    }
}
