package com.example.auth_service.service;

import com.example.auth_service.dto.response.UserResponseDTO;

public interface UserService {
    UserResponseDTO authenticate(String username, String password);
}
