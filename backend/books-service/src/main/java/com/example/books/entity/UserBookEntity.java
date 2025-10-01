package com.example.books.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name="users_books")
public class UserBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long bookId;

    private OffsetDateTime dueToDate;

    private OffsetDateTime createdAt;

    private OffsetDateTime deletedAt;
}
