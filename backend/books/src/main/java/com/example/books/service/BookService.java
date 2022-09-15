package com.example.books.service;

import com.example.books.entity.BookEntity;
import com.example.books.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getAllBooks() {
        var list = new ArrayList<BookEntity>();
        var books = bookRepository.findAll();
        books.forEach(list::add);

        return list;
    }
}
