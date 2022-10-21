package com.example.books.model;

import com.example.books.entity.BookEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Book {
    private Long id;
    private String name;
    private String author;
    private String description;
    private String image;
    private LocalDate publishedDate;

    public static Book toModel(BookEntity entity) {
        var book = new Book();
        book.setId(entity.getId());
        book.setName(entity.getName());
        book.setAuthor(entity.getAuthor());
        book.setDescription(entity.getDescription());
        book.setImage(entity.getImage());
        book.setPublishedDate(entity.getPublishedDate());

        return book;
    }
}
