package com.example.books.model;

import com.example.books.entity.UserEntity;

public class User {
    private Long id;
    private String username;


    public static User toModel(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());

        return user;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
