package com.example.books.repository;

import com.example.books.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

    @Query(value = "SELECT * FROM books WHERE books.id IN (SELECT book_id FROM users_books WHERE user_id=:userId)", nativeQuery = true)
    List<BookEntity> findAllBooksOfUser(@Param("userId") Long userId);




}
