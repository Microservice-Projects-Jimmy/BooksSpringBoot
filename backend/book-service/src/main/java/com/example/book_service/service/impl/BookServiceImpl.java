package com.example.book_service.service.impl;

import com.example.book_service.dto.business.response.BookResponseDTO;
import com.example.book_service.mapper.BookMapper;
import com.example.book_service.repository.BookRepository;
import com.example.book_service.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDTO)
                .toList();
    }

}
