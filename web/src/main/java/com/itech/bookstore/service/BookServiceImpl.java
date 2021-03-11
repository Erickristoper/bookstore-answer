package com.itech.bookstore.service;

import com.itech.bookstore.domain.Book;
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
       return checkAvailability(bookRepository.findAll());
    }

    public List<Book> findByName(String name) {
        return checkAvailability(bookRepository.findByName(name.toLowerCase()));
    }

    public List<Book> findById(int id) {
        return checkAvailability(bookRepository.findById(id));
    }

    private List<Book> checkAvailability(List<Book> books) {
        List<Book> modifiedBooks = books;
        modifiedBooks
                .stream()
                .forEach(b -> { if(b.getUserId() == null) b.setAvailability(true); });
        return modifiedBooks ;
    }

    public Book addBook(String name, String description, String uploadedBy) {
        int uploadedById = userRepository.findByName(uploadedBy).getId();
        Book b = new Book(name, description, uploadedById, uploadedById);
        logger.debug("Adding Book {}", b);
        return bookRepository.save(b);
    }

}
