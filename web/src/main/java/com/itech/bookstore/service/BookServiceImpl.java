package com.itech.bookstore.service;

import com.itech.bookstore.domain.Book;
import com.itech.bookstore.domain.User;
import com.itech.bookstore.repository.BookRepository;
import com.itech.bookstore.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(String name, String description, String uploadedBy) {
        int uploadedById = userRepository.findByName(uploadedBy).getId();
        Book b = new Book(name, description, uploadedById, uploadedById);
        logger.debug("Adding Book {}", b);
        return bookRepository.save(b);
    }

    public List<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }
}
