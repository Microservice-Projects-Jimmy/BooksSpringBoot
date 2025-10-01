package com.example.books.service;

import com.example.books.entity.BookEntity;
import com.example.books.entity.UserBookEntity;
import com.example.books.repository.BookRepository;
import com.example.books.repository.UserBookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

@WebMvcTest(BookService.class)
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private UserBookRepository userBookRepository;

    @Test
    void repsondDueToDateDataToUserTest() {
        var mockBook = generateBook();
        var saveBorrowedBook= bookService.borrowBook(5555L, mockBook);

        var expectedDate = OffsetDateTime.now().plusDays(3);

        assertEquals(expectedDate, saveBorrowedBook.getDueToDate());
        assertEquals(OffsetDateTime.now(), saveBorrowedBook.getCreatedAt());
        assertEquals(null, saveBorrowedBook.getDeletedAt());
    }
    private BookEntity generateBook() {
        var book = new BookEntity();
        book.setAuthor("Adams");
        book.setId(555555L);
        book.setName("Books name");
        book.setCopyCount(10);

        return book;
    }
}