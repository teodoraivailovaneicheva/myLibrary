package com.myLibrary.service;

import com.myLibrary.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book create(Book book);

    Optional<Book> readById(int id);

    Book findById(int id);

    List<Book> findAllBooks();

    Optional<Book> updateBookById(Book book, int id);

    boolean deleteBookById(int id);
}
