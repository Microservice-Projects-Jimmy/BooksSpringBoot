package com.example.books.exception;

public class UserAlreadyHasThisBookException extends RuntimeException{
    public UserAlreadyHasThisBookException() {
        super("This user already has this book");
    }
}
