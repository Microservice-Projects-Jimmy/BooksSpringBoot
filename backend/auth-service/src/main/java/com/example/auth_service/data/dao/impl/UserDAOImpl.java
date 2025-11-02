package com.example.auth_service.data.dao.impl;

import com.example.auth_service.data.dao.UserDAO;
import com.example.auth_service.data.model.User;
import com.example.auth_service.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {
    private final UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        log.info("Finding user by username: {}", username);
        return userRepository.findByUsername(username);
    }

}
