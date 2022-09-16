package com.example.books.service;

import com.example.books.entity.UserEntity;
import com.example.books.exception.InvalidCredentialsException;
import com.example.books.exception.UserAlreadyExistException;
import com.example.books.exception.UserNotFoundException;
import com.example.books.model.User;
import com.example.books.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Service
@Slf4j
public class UserService {
    private static final String AUTH_SALT = "sdgb43bbwvdv3/&^24g23gwherh34g;as:23524m6";

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity register(String name, String username, String password) throws UserAlreadyExistException {
        if(!userRepository.findByUsername(username).isEmpty()) {
            throw new UserAlreadyExistException("Username is taken");
        }

        var user = new UserEntity();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(hashPassword(password));
        user.setToken(generateToken());

        return userRepository.save(user);
    }

    public UserEntity authenticate(String username, String password) {
        var passwordHash = hashPassword(password);
        var userOptional = userRepository.findByUsernameAndPassword(username, passwordHash);
        if (userOptional.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        var user = userOptional.get();
        user.setToken(generateToken());
        userRepository.save(user);

        return user;
    }
    public void logout(Long id)  {
        var user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("User is not found");
        }
        var userEntity = user.get();
        userEntity.setToken("");
        userRepository.save(userEntity);
    }

    public String createAuthCookie(UserEntity user) {
        return user.getId() + "_" + user.getToken();
    }

    public User getOne(Long id) throws UserNotFoundException {
        var user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User is not found");
        }

        return User.toModel(user.get());
    }

    public void validateToken(Long id, String tokenValue) {
        log.info(tokenValue);
        var user = userRepository.findByIdAndToken(id, tokenValue);
        if (user.isEmpty()) {
            throw new InvalidCredentialsException();
        }

    }

    private String hashPassword(String rawPassword) {
        var spec = new PBEKeySpec(rawPassword.toCharArray(), AUTH_SALT.getBytes(), 65536, 128);
        SecretKeyFactory factory;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        try {
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return new String(hash);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateToken() {
        SecureRandom random = new SecureRandom();
        byte[] token = new byte[16];
        random.nextBytes(token);

        return Base64.getEncoder().encodeToString(token);
    }
}
