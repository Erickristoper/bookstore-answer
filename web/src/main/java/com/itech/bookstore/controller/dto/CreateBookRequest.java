package com.itech.bookstore.controller.dto;

public class CreateBookRequest {
    private String name;
    private String description;
    private Integer userId;
    private int uploadedById;

    public CreateBookRequest() {}

    public CreateBookRequest(String name, String description, Integer userId, int uploadedById) {
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.uploadedById = uploadedById;
    }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public Integer getUserId() { return userId; }

    public int getUploadedById() { return uploadedById; }
}
