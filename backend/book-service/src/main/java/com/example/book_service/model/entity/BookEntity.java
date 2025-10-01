package com.example.book_service.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Getter
@Setter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String description;
    private String image;
    private LocalDate publishedDate;
    private Integer copyCount;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;


    public void setCopyCount(int copyCount) {
        this.copyCount = copyCount;
    }

    public void incrementCopyCount() {
        this.copyCount++;
    }
}
