package com.example.books.controller;

import com.example.books.exception.BookMissingException;
import com.example.books.model.Book;
import com.example.books.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {
    private final BookService bookService;

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
    @PutMapping("/{book_id}/borrow")
    public ResponseEntity<Book> borrowBook(@PathVariable("book_id") Long bookId, HttpServletRequest request){

        var userId = (Long) request.getAttribute("userId");

        bookService.validateUserForBorrow(userId, bookId);
        var book = bookService.getOne(bookId);
        if(book == null){
            throw new BookMissingException();
        }
        bookService.borrowBook(userId, book);

        return ResponseEntity.ok(Book.toModel(book));


    }

    @PutMapping("/{book_id}/return")
    public  ResponseEntity returnBook(@PathVariable("book_id") Long bookId, HttpServletRequest request){
        var userId = (Long) request.getAttribute("userId");
        var book = bookService.getOne(bookId);

        bookService.returnOne(userId, book);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/return-all")
    public ResponseEntity returnAllBooks (HttpServletRequest request){
        var userId = (Long) request.getAttribute("userId");
        var books = bookService.getAllBooksOfUser(userId);
        bookService.returnAll(userId, books);

        return ResponseEntity.ok().build();
    }
}
