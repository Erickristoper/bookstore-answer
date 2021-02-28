package com.itech.bookstore;

import com.itech.bookstore.controller.dto.UsersResponse;
import com.itech.bookstore.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(value = "classpath:application-test.properties")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void hiShouldReturnGreetingsMessage() {
        assertThat(this.restTemplate.getForObject(
            "http://localhost:" + port + "/hi",
            String.class
        )).contains("Hi, Candidate!");
    }

    @Test
    void usersShouldReturnAllUsers() {
        ResponseEntity<UsersResponse> response = this.restTemplate.getForEntity(
            "http://localhost:" + port + "/users",
            UsersResponse.class
        );
        assertThat(Objects.requireNonNull(response.getBody()).getUsers().size()).isGreaterThan(3);
        assertThat(response.getBody().getUsers()).contains(new User(3, "Dennis", "read;write;admin"));
    }
}