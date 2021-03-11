package com.itech.bookstore.controller;

import com.itech.bookstore.controller.dto.*;
import com.itech.bookstore.interceptor.CheckAdminPermissions;
import com.itech.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public HttpEntity<BooksResponse> getBooks() {
        return ResponseEntity.ok().body(new BooksResponse(bookService.getAllBooks()));
    }

    @GetMapping(value = "/books/search")
    public HttpEntity<BooksResponse> findByName(@RequestParam(value = "name", required = false) String name) {
        return ResponseEntity.ok().body(new BooksResponse(bookService.findByName(name)));
    }

    @CheckAdminPermissions
    @PostMapping(value = "/books")
    public HttpEntity<BookResponse> addBook(@RequestBody CreateBookRequest request, HttpServletRequest httpRequest) {
        return ResponseEntity.ok().body(
                new BookResponse(bookService.addBook(
                        request.getName(),
                        request.getDescription(),
                        httpRequest.getHeader("X-User"))));
    }

}
