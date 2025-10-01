package com.example.books.exception;

public class BookMissingException extends RuntimeException {
    public BookMissingException() {
        super("The book is absent or there is no book like this!");
    }
}
