package com.itech.bookstore.controller.dto;

public class CreateUserRequest {
    private String name;
    private String permissions;

    public CreateUserRequest(){}

    public CreateUserRequest(String name, String permissions){
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public String getPermissions() {
        return permissions;
    }
}
