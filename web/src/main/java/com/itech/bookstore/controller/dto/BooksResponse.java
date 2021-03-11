package com.itech.bookstore.controller.dto;

import com.itech.bookstore.domain.Book;

import java.util.List;

public class BooksResponse {

    private List<Book> books;

    public BooksResponse(){}

    public BooksResponse(List<Book> books) { this.books = books; }

    public List<Book> getBooks() { return books; }
}
