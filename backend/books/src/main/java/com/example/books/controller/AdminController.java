package com.example.books.controller;

import com.example.books.exception.ForbiddenAccessException;
import com.example.books.model.Book;
import com.example.books.request.BookRequest;
import com.example.books.service.BookService;
import com.example.books.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final BookService bookService;
    private final RoleService roleService;

    @PostMapping("/books/add")
    public ResponseEntity<Book> addBook(@RequestBody BookRequest bookRequest, HttpServletRequest request) {
        var role = roleService.getUserRole((Long) request.getAttribute("userId"));
        if (!role.equals("admin")) {
            throw new ForbiddenAccessException();
        }
        var bookEntity = bookService.addBook(bookRequest);

        return ResponseEntity.ok(Book.toModel(bookEntity));
    }
}
