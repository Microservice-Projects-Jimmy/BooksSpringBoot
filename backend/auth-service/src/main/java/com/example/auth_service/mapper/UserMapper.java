package com.example.auth_service.mapper;

import com.example.auth_service.data.enums.Role;
import com.example.auth_service.data.model.User;
import com.example.auth_service.dto.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "token", ignore = true)
    @Mapping(source = "authorities", target = "authorities", qualifiedByName = "mapAuthoritiesToRoles")
    UserResponseDTO toDto(User user);


    @Named("mapAuthoritiesToRoles")
    default List<Role> mapAuthoritiesToRoles(Collection<? extends GrantedAuthority> authorities) {
        if (authorities == null) {
            return null;
        }
        return authorities.stream()
                .map(authority -> Role.valueOf(authority.getAuthority()))
                .collect(Collectors.toList());
    }
}
