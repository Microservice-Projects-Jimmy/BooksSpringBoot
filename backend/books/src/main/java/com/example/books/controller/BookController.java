package com.example.books.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @GetMapping("/")
    public String greeting(){
        return "hello Jimi";
    }
}
