package com.example.books.controller;

import com.example.books.auth.TokenFilter;
import com.example.books.model.User;
import com.example.books.request.LoginRequest;
import com.example.books.request.RegisterRequest;
import com.example.books.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        var user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        var authCookie = userService.createAuthCookie(user);
        response.addCookie(new Cookie(TokenFilter.AUTH_COOKIE, authCookie));

        return ResponseEntity.ok(User.toModel(user));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest, HttpServletResponse response) {
        var user = userService.register(registerRequest.getName(), registerRequest.getUsername(), registerRequest.getPassword());

        var authCookie = userService.createAuthCookie(user);
        log.info(authCookie);
        response.addCookie(new Cookie(TokenFilter.AUTH_COOKIE, authCookie));

        return ResponseEntity.ok(User.toModel(user));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response){
        var userId = (Long) request.getAttribute("userId");
        userService.logout(userId);
        var cookie = new Cookie( TokenFilter.AUTH_COOKIE, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.noContent().build();
    }
}
