package com.itech.bookstore.controller.dto;

import com.itech.bookstore.domain.Book;

public class BookResponse {
    private Book book;

    public BookResponse(){}

    public BookResponse(Book book) { this.book = book; }

    public Book getBook() { return book; }
}
