package com.example.books.entity;

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
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private Integer copyCount;


    public void setCopyCount(int copyCount) {
        this.copyCount = copyCount;
    }

    public void incrementCopyCount() {
        this.copyCount++;
    }
}
