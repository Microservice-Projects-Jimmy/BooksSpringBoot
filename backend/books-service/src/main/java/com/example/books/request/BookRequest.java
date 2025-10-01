package com.example.books.request;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class BookRequest {
    //    name, author, description, image, copy_count, published_date,
    private String name;
    private String author;
    private String description;
    private String image;
    private Integer copyCount;
    private LocalDate publishedDate;

}
