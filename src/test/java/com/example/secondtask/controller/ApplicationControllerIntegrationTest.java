package com.example.secondtask.controller;

import com.example.secondtask.controllers.ApplicationController;
import com.example.secondtask.models.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ApplicationControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    ApplicationController applicationController;

    /**
     * Проверка функции получения всех заявок
     * @throws Exception
     */
    @Test
    public void getAllApplicationsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/applications")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Проверка функции создания заявки
     * @throws Exception
     */
    @Test
    public void createApplicationTest() throws Exception {
        Application application = new Application();

        application.setNumber(1200);
        application.setAmount(1_000_000);
        application.setCurrency("rub");
        application.setApplicant(null);
        application.setGuarantor(null);

        mockMvc.perform( MockMvcRequestBuilders
                .post("/api")
                .content(asJsonString(application))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
