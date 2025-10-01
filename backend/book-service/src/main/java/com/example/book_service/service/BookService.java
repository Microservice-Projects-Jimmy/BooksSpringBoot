package com.example.book_service.service;

import com.example.book_service.dto.business.response.BookResponseDTO;

import java.util.List;

public interface BookService {
    List<BookResponseDTO> getAllBooks();
}
