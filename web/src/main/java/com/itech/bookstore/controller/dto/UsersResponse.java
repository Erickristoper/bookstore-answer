package com.itech.bookstore.controller.dto;

import com.itech.bookstore.domain.User;

import java.util.List;

public class UsersResponse {

    private List<User> users;

    public UsersResponse(){}

    public UsersResponse(List<User> users){
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
