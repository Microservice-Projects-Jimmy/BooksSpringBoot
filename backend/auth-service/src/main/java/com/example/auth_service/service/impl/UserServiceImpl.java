package com.example.auth_service.service.impl;

import com.example.auth_service.config.JwtService;
import com.example.auth_service.data.dao.UserDAO;
import com.example.auth_service.dto.response.UserResponseDTO;
import com.example.auth_service.mapper.UserMapper;
import com.example.auth_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    @Override
    public UserResponseDTO authenticate(String username, String password) {
        var user = userDAO.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        var response = userMapper.toDto(user);
        response.setToken(jwtService.generateToken(user));
        return response;
    }
}
