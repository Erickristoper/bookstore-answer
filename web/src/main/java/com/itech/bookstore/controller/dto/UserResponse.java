package com.itech.bookstore.controller.dto;

import com.itech.bookstore.domain.User;

public class UserResponse {
    private User user;

    public UserResponse(){}

    public UserResponse(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
