package com.example.books.service;

import com.example.books.entity.RoleEntity;
import com.example.books.repository.RoleRepository;
import com.example.books.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public String getUserRole(Long userId) {
        var user = userRepository.findById(userId).orElseThrow();
        return roleRepository.findById(user.getRoleId()).map(RoleEntity::getName).orElseThrow();
    }
}
