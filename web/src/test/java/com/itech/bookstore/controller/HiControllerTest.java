package com.itech.bookstore.controller;

import com.itech.bookstore.interceptor.CheckAdminPermissionsInterceptor;
import com.itech.bookstore.service.HiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HiController.class)
class HiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CheckAdminPermissionsInterceptor interceptor;
    @MockBean
    private HiService service;

    @Test
    void hiShouldReturnMessageFromService() throws Exception {
        when(service.sayHi()).thenReturn("Hi, Candidate!");

        this.mockMvc.perform(get("/hi")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("Hi, Candidate!")));
    }
}