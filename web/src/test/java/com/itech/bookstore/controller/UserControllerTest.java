package com.itech.bookstore.controller;

import com.itech.bookstore.domain.User;
import com.itech.bookstore.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;
    private final List<User> serviceResponse = new ArrayList<>();

    @Test
    void UserShouldReturnMessageEmptyList() throws Exception {
        when(service.getAllUsers()).thenReturn(serviceResponse);
        this.mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.users", is(Collections.emptyList())));
    }

    @Test
    void UserShouldReturnMessageWithUser() throws Exception {
        serviceResponse.add(new User(1, "John", "read"));
        when(service.getAllUsers()).thenReturn(serviceResponse);
        this.mockMvc.perform(get("/users").contentType(
            MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.users[0].name", is("John")))
            .andExpect(jsonPath("$.users[0].permissions", is("read")));
    }
}