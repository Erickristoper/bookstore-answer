package com.itech.bookstore.service;

import com.itech.bookstore.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book addBook(String name, String description, String uploadedBy);

    List<Book> findByName(String name);
}
