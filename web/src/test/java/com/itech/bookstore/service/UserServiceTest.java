package com.itech.bookstore.service;

import com.itech.bookstore.domain.User;
import com.itech.bookstore.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

class UserServiceTest {

    private final List<User> dbResponse = new ArrayList<>();
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void userServiceShouldReturnEmptyListWhenNoUsers() {
        Mockito.when(userRepository.findAll()).thenReturn(dbResponse);
        List<User> users = userService.getAllUsers();
        Assertions.assertEquals(0, users.size());
    }

    @Test
    void userServiceShouldReturnResultFromRepository() {
        dbResponse.add(new User(1, "John", "read"));
        Mockito.when(userRepository.findAll()).thenReturn(dbResponse);
        List<User> users = userService.getAllUsers();
        Assertions.assertEquals(1, users.size());
    }
}