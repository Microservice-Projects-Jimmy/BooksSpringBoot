package com.example.books.service;

import com.example.books.entity.BookEntity;
import com.example.books.entity.UserBookEntity;
import com.example.books.exception.BookMissingException;
import com.example.books.exception.UserAlreadyHasThisBookException;
import com.example.books.exception.UserReachedBorrowLimit;
import com.example.books.repository.BookRepository;
import com.example.books.repository.UserBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final UserBookRepository userBookRepository;

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

    public void borrowBook(Long userId, BookEntity book) {
        var bookCount = book.getCopyCount();
        if(bookCount < 2){
            throw new BookMissingException();
        }
        book.setCopyCount(--bookCount);
        bookRepository.save(book);
        var entity = new UserBookEntity();
        entity.setUserId(userId);
        entity.setBookId(book.getId());
        userBookRepository.save(entity);
    }

    public void validateUserForBorrow(Long userId, Long bookId) {
        var list = userBookRepository.findAllByUserId(userId);
        var hasBook = list.stream().filter(el->el.getBookId().equals(bookId)).collect(Collectors.toList());
        if (hasBook.size() == 1) {
            throw new UserAlreadyHasThisBookException();
        }
        if (list.size() == 2) {
            throw new UserReachedBorrowLimit();
        }
    }
    public List<BookEntity> getAllBooksOfUser(Long userId){
        return bookRepository.findAllBooksOfUser(userId);
    }

    public BookEntity getOne(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public void returnOne(Long userId, BookEntity book) {
        var entity = userBookRepository.findByUserIdAndBookId(userId, book.getId());
        if(entity.isEmpty()){
            throw new BookMissingException();
        }
        userBookRepository.delete(entity.get());
        book.incrementCopyCount();
        bookRepository.save(book);

    }

    public void returnAll(Long userId, List<BookEntity> bookEntities) {
        bookEntities.forEach(BookEntity::incrementCopyCount);
        bookRepository.saveAll(bookEntities);
        userBookRepository.deleteByUserId(userId);
    }

}
