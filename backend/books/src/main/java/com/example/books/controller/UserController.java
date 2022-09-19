package com.example.books.controller;

import com.example.books.auth.TokenFilter;
import com.example.books.model.Book;
import com.example.books.model.User;
import com.example.books.request.LoginRequest;
import com.example.books.request.RegisterRequest;
import com.example.books.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@RestController
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
        var userEntity = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        var token = userService.createAuthToken(userEntity);
        var user = User.toModel(userEntity);
        user.setToken(token);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest, HttpServletResponse response) {
        var user = userService.register(registerRequest.getName(), registerRequest.getUsername(), registerRequest.getPassword());

        var authCookie = userService.createAuthToken(user);
        log.info(authCookie);
        response.addCookie(new Cookie(TokenFilter.AUTH_COOKIE, authCookie));

        return ResponseEntity.ok(User.toModel(user));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request){
        var userId = (Long) request.getAttribute("userId");
        userService.logout(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/books")
    public ResponseEntity<List<Book>> userBooks(HttpServletRequest request) {
        var userId = (Long) request.getAttribute("userId");
        log.info(userId.toString());
        var books = userService.getUsersBooks(userId);

        return ResponseEntity.ok(books);
    }
}
