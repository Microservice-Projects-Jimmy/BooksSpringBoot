package com.example.books.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity {
    public static final Long ADMIN_ROLE_ID = 1L;
    public static final Long USER_ROLE_ID = 2L;

    @Id
    private Long id;
    private String name;
}
