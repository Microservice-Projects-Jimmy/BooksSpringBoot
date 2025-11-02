package com.example.auth_service.data.model;

import com.example.auth_service.data.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity implements UserDetails {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    @Column(name = "authorities")
    @Enumerated(EnumType.STRING)
    private List<Role> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities
                .stream().map(r -> new SimpleGrantedAuthority(r.name()))
                .toList();
    }
}
