package com.example.auth_service.dto.response;

import com.example.auth_service.data.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO{
    private String username;
    private String email;
    private List<Role> authorities;
    private String token;

}
