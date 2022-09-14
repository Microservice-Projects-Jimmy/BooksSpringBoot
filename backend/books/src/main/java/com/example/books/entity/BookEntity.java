package com.example.books.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String description;
    private String image;
    private Date publishedDate;

}
