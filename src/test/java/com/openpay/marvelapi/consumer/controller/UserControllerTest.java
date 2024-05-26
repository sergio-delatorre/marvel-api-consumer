package com.openpay.marvelapi.consumer.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.openpay.marvelapi.consumer.model.dto.UserRequest;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    private static final String USER_PATH = "/users";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testSignUp_Success() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("email@example.com");
        userRequest.setPassword("qCYgPz#@cwG7");


        mockMvc.perform(post(USER_PATH+"/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", Is.is(userRequest.getEmail())))
                .andExpect(jsonPath("$.token", Matchers.notNullValue()));
    }

    @Test
    public void testSignUp_InvalidInput() throws Exception {
        UserRequest invalidUserRequest = new UserRequest();

        mockMvc.perform(post(USER_PATH+"/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidUserRequest)))
                .andExpect(status().isBadRequest());
    }
}
