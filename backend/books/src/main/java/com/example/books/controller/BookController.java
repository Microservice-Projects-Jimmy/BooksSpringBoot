package com.example.books.controller;

import com.example.books.model.Book;
import com.example.books.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> books() {
        var bookEntityList = bookService.getAllBooks();
        var books = bookEntityList.stream()
                .map(Book::toModel)
                .collect(Collectors.toList());

            return  ResponseEntity.ok(books);
    }
}
