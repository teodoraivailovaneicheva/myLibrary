package com.myLibrary.service.serviceImpl;

import com.myLibrary.entity.Book;
import com.myLibrary.service.BookService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookServiceImpl implements BookService {

    private static final Map<Integer, Book> BOOK_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger BOOK_ID = new AtomicInteger();

    @Override
    public Book create(Book book) {
        final int bookId = BOOK_ID.incrementAndGet();
        book.setId(bookId);
        BOOK_REPOSITORY_MAP.put(bookId, book);
        try{
            return book;
        }catch(Exception e){
            throw new RuntimeException("Failed to create book " + e.getMessage());
        }
    }

    @Override
    public Optional<Book> readById(int id) {
        return Optional.empty();
    }

    @Override
    public Book findById(int id) {

        return BOOK_REPOSITORY_MAP.get(id);
    }

    @Override
    public List<Book> findAllBooks() {

        try{
            return new ArrayList<>(BOOK_REPOSITORY_MAP.values());
        }catch(Exception e){
            throw new RuntimeException("Failed to read all books " + e.getMessage());
        }
    }

    @Override
    public Optional<Book> updateBookById(Book book, int id) {

        try{
            Optional<Book> existingBookOptional = Optional.ofNullable(BOOK_REPOSITORY_MAP.get(id));
            if (existingBookOptional.isPresent()){
                Book existingBook = existingBookOptional.get();
                existingBook.setBookTitle(book.getBookTitle());
                existingBook.setBookAuthor(book.getBookAuthor());
                existingBook.setBookPublisher(book.getBookPublisher());
                existingBook.setPages(book.getPages());
                Book savedBook = BOOK_REPOSITORY_MAP.put(id, existingBook);
                return Optional.of(savedBook);
            }else{
                return Optional.empty();
            }
        }catch(Exception e){
            throw new RuntimeException("Failed to update book " + e.getMessage());
        }
    }

    @Override
    public boolean deleteBookById(int id) {

        try{
            BOOK_REPOSITORY_MAP.remove(id);
            return true;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete book " + e.getMessage());
        }
    }
}
