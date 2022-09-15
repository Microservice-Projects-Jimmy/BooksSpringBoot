package com.example.books.model;

import com.example.books.entity.BookEntity;
import com.example.books.entity.UserEntity;

import java.util.Date;

public class Book {
    private Long id;
    private String name;
    private String author;
    private String description;
    private String image;
    private Date publishedDate;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
}
