package com.example.books.repository;

import com.example.books.entity.UserBookEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserBookRepository extends CrudRepository<UserBookEntity, Long> {
    List<UserBookEntity> findAllByUserId(Long userId);

    Optional<UserBookEntity> findByUserIdAndBookId(Long userId, Long bookId);

    void deleteByUserId(Long userId);

}
