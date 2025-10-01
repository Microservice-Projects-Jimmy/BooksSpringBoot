package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @RequestMapping("/fallback")
    public ResponseEntity<?> fallback() {
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body("Service is taking too long to respond. Please try again later.");
    }
}
