package com.itech.bookstore.controller;

import com.itech.bookstore.controller.dto.CreateUserRequest;
import com.itech.bookstore.controller.dto.UserResponse;
import com.itech.bookstore.controller.dto.UsersResponse;
import com.itech.bookstore.interceptor.CheckAdminPermissions;
import com.itech.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public HttpEntity<UsersResponse> getUsers() {
        return ResponseEntity.ok().body(new UsersResponse(userService.getAllUsers()));
    }

    @CheckAdminPermissions
    @PostMapping(value = "/users")
    public HttpEntity<UserResponse> addUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok().body(new UserResponse(userService.addUser(request.getName(), request.getPermissions())));
    }
}
