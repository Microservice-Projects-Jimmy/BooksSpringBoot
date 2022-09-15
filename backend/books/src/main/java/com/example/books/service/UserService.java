package com.example.books.service;

import com.example.books.entity.UserEntity;
import com.example.books.exception.UserAlreadyExistException;
import com.example.books.exception.UserNotFoundException;
import com.example.books.model.User;
import com.example.books.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Username is taken");
        }

        return userRepository.save(user);
    }

    private User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("user is not found");
        }
        return User.toModel(user);

    }
}
