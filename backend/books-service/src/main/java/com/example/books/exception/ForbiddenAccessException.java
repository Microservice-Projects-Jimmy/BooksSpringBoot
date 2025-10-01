package com.example.books.exception;

public class ForbiddenAccessException extends RuntimeException {
    public ForbiddenAccessException() {
        super("Forbidden access"); // 403
    }
}
