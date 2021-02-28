package com.itech.bookstore.service;

import com.itech.bookstore.domain.Book;
import com.itech.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

class BookServiceTest {

    private final List<Book> dbResponse = new ArrayList<>();
    @Mock
    BookRepository bookRepository;
    @InjectMocks
    BookServiceImpl bookService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void bookServiceShouldReturnEmptyListWhenNoBooks() {
        Mockito.when(bookRepository.findAll()).thenReturn(dbResponse);
        List<Book> books = bookService.getAllBooks();
        Assertions.assertEquals(0, books.size());
    }

    @Test
    void bookServiceShouldReturnResultFromRepository() {
        dbResponse.add(new Book("Test", "Test", -1, 23));
        Mockito.when(bookRepository.findAll()).thenReturn(dbResponse);
        List<Book> books = bookService.getAllBooks();
        Assertions.assertEquals(1, books.size());
    }
}