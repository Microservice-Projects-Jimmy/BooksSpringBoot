package com.example.book_service.controller;

import com.example.book_service.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
