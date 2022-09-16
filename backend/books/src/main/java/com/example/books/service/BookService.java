package com.example.books.service;

import com.example.books.entity.BookEntity;
import com.example.books.entity.UserBookEntity;
import com.example.books.exception.UserReachedBorrowLimit;
import com.example.books.repository.BookRepository;
import com.example.books.repository.UserBookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;
    private UserBookRepository userBookRepository;

    public BookService(BookRepository bookRepository, UserBookRepository userBookRepository) {
        this.bookRepository = bookRepository;
        this.userBookRepository = userBookRepository;
    }

    public List<BookEntity> getAllBooks() {
        var list = new ArrayList<BookEntity>();
        var books = bookRepository.findAll();
        books.forEach(list::add);

        return list;
    }

    public void borrowBook(Long userId, BookEntity book){
        book.setBorrowed(true);
        bookRepository.save(book);
        var entity = new UserBookEntity();
        entity.setUserId(userId);
        entity.setBookId(book.getId());
        userBookRepository.save(entity);
    }

    public void validateUserForBorrow(Long userId) {
        var list = userBookRepository.findAllByUserId(userId);

        if(list.size() == 2){
            throw new UserReachedBorrowLimit();
        }
    }

    public BookEntity getOne(Long id){
        return bookRepository.findById(id).get();
    }
}
