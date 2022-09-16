package com.example.books.controller;

import com.example.books.model.Book;
import com.example.books.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> books() {
        var bookEntityList = bookService.getAllBooks();
        var books = bookEntityList.stream()
                .map(Book::toModel)
                .collect(Collectors.toList());

            return  ResponseEntity.ok(books);
    }
//    @PutMapping("/books/{book_id}/borrow")
//    public ResponseEntity<Book> borrowBook(@PathVariable("book_id") int bookId){
//        //1 check if current user already has  two books
//        //2 check if book is available
//        //3 set book borrrowed
//        //4 add book to users borrowed  list
//    }
}
