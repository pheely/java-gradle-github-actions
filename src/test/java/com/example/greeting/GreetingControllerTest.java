// src/test/java/com/example/greeting/GreetingControllerTest.java
package com.example.greeting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService service;

    @Test
    void greetEndpointReturnsJson() throws Exception {
        when(service.greet("Philip")).thenReturn("Hello, Philip!");

        mockMvc.perform(get("/api/greet").param("name", "Philip"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Hello, Philip!"));
    }

    @Test
    void greetEndpointDefaultsToWorld() throws Exception {
        when(service.greet("World")).thenReturn("Hello, World!");

        mockMvc.perform(get("/api/greet"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello, World!"));
    }
}
