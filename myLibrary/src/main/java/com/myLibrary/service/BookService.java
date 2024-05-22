package com.myLibrary.service;

import com.myLibrary.entity.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    Book findBookById(int id);

    List<Book> findAllBooks();

    boolean updateBookById(Book book, int id);

    boolean deleteBookById(int id);
}
