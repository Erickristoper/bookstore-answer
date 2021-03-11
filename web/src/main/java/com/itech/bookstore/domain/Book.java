package com.itech.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Integer userId;
    private int uploadedById;

    @Transient
    private boolean available;

    public Book(){}

    public Book(int id, String name, String description, Integer userId, int uploadedById){
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.uploadedById = uploadedById;
    }

    public Book(String name, String description, Integer userId, int uploadedById){
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.uploadedById = uploadedById;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getUploadedById() {
        return uploadedById;
    }

    public Integer getUserId() {
        return userId;
    }

    public boolean isAvailable() { return available; }

    public void setAvailability(boolean available) { this.available = available; }
}
