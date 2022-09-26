package com.example.books.webtest;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.books.controller.BookController;
import com.example.books.entity.BookEntity;
import com.example.books.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(BookController.class)
public class BooksWebTest {
    private static final Long USER_ID = 443312L;
    private static final Long BOOK_ID = 55412L;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void getEmptyLibraryBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(List.of());

        mockMvc
                .perform(get("/books"))
                .andExpect(content().json("[]"))
                .andExpect(status().isOk());
    }

    @Test
    public void userCanBorrowBookFromLibrary() throws Exception {
        var mockBook = generateBook();
        doNothing().when(bookService).validateUserForBorrow(USER_ID, BOOK_ID);
        when(bookService.getOne(BOOK_ID)).thenReturn(mockBook);
        doNothing().when(bookService).borrowBook(USER_ID, mockBook);

        mockMvc
                .perform(put("/books/" + BOOK_ID + "/borrow"))
                .andExpect(content().json("{\"id\":55412,\"name\":\"Books name\",\"author\":\"Adams\",\"description\":null,\"image\":null,\"publishedDate\":null}"))
                .andExpect(status().isOk());
    }

    private BookEntity generateBook() {
        var book = new BookEntity();
        book.setAuthor("Adams");
        book.setId(BOOK_ID);
        book.setName("Books name");

        return book;
    }
}
