package com.itech.bookstore.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class HiServiceTest {

    @InjectMocks
    HiServiceImpl hiService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void hiServiceShouldReturnGreetingMessage() {
        String result = hiService.sayHi();
        Assertions.assertEquals("Hi, Candidate!", result);
    }
}