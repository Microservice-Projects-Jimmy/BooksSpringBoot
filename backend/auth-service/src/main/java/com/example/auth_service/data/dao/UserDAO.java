package com.example.auth_service.data.dao;

import com.example.auth_service.data.model.User;

import java.util.Optional;

public interface UserDAO {
    Optional<User> findByUsername(String username);
}
