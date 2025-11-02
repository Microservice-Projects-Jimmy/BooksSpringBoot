package com.example.auth_service.config;

import com.example.auth_service.data.dao.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class AuthConfig {
    private final UserDAO userDAO;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
