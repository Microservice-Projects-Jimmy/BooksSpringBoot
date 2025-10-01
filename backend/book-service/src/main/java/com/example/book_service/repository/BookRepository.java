package com.example.book_service.repository;

import com.example.book_service.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<BookEntity, Long> {

}
