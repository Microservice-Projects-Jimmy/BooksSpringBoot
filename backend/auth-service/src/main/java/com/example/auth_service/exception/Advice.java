package com.example.auth_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advice {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> handleUserException(UserException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
