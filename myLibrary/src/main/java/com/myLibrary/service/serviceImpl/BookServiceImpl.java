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
            return book;
    }

    @Override
    public Optional<Book> readById(int id) {
        return Optional.ofNullable(BOOK_REPOSITORY_MAP.get(id));
    }

    @Override
    public Book findById(int id) {

        return BOOK_REPOSITORY_MAP.get(id);
    }

    @Override
    public List<Book> findAllBooks() {

        return new ArrayList<>(BOOK_REPOSITORY_MAP.values());
    }

    @Override
    public Optional<Book> updateBookById(Book book, int id) {

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
        }

    @Override
    public Optional<Book> updateBookField(int id, String publisher){

        Optional<Book> existingBookOptional = Optional.ofNullable(BOOK_REPOSITORY_MAP.get(id));
        if (existingBookOptional.isPresent()){
            Book existingBook = existingBookOptional.get();
            existingBook.setBookPublisher(publisher);
            Book savedBook = BOOK_REPOSITORY_MAP.put(id, existingBook);
            return Optional.of(savedBook);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Book> deleteBookById(int id) {

          return Optional.ofNullable(BOOK_REPOSITORY_MAP.remove(id));
    }
}
