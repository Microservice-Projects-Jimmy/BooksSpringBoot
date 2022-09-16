package com.example.books.controller;

import com.example.books.exception.BookMissingException;
import com.example.books.model.Book;
import com.example.books.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @PutMapping("/{book_id}/borrow")
    public ResponseEntity<Book> borrowBook(@PathVariable("book_id") Long bookId, HttpServletRequest request){
        //1 check if current user already has  two books V
        //2 check if book is available V
        //3 set book borrrowed
        //4 add book to users borrowed  list

        var userId = (Long) request.getAttribute("userId");

        bookService.validateUserForBorrow(userId);
        var book = bookService.getOne(bookId);
        if(book == null || book.isBorrowed()){
            throw new BookMissingException();
        }
        bookService.borrowBook(userId, book);

        return ResponseEntity.ok(Book.toModel(book));


    }
}
