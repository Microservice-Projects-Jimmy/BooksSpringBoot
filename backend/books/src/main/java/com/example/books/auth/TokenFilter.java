package com.example.books.auth;

import com.example.books.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Component
@Slf4j
public class TokenFilter extends OncePerRequestFilter {
    public static final String AUTH_COOKIE = "token";
    public static final String LOGIN_PATH = "/login";
    public static final String REGISTER_PATH = "/register";

    private UserService userService;

    public TokenFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                if (request.getRequestURI().equals(LOGIN_PATH) || request.getRequestURI().equals(REGISTER_PATH)) {
                    filterChain.doFilter(request, response);
                    return;
                }

                var token = request.getHeader("Authorization");

                if (token == null || token.isBlank()) {
                    response.setStatus(401);
                    return;
                }
                // token=id_tokenValue
                String[] parts = token.split("_");
                if (parts.length != 2) {
                    response.setStatus(401);
                }

                var id = parts[0];
                var tokenValue = parts[1];
                userService.validateToken(Long.parseLong(id), tokenValue);
                request.setAttribute("userId", Long.parseLong(id));
                filterChain.doFilter(request, response);
    }

}
