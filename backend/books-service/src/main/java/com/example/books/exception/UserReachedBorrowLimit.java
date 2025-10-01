package com.example.books.exception;

public class UserReachedBorrowLimit extends RuntimeException {
    public UserReachedBorrowLimit() {
        super("User reached borrow limit!");
    }
}
