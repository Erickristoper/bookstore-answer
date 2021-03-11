package com.itech.bookstore.service;

import com.itech.bookstore.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    List<Book> findByName(String name);

    List<Book> findById(int id);

    Book addBook(String name, String description, String uploadedBy);

}
