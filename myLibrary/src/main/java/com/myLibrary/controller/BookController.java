package com.myLibrary.controller;

import com.myLibrary.entity.Book;
import com.myLibrary.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookservice) {
        this.bookService = bookservice;
    }

    @PostMapping(value = "/books")
    public ResponseEntity<?> create(@RequestBody @Valid Book book){

        bookService.create(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> read(){

        final List<Book> books = bookService.findAllBooks();
        return books != null && !books.isEmpty() ? new ResponseEntity<>(books, HttpStatus.OK) : new ResponseEntity<>(books, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Book> read(@PathVariable(name = "id") @Valid int id){

        final Book book = bookService.findBookById(id);
        return book != null ? new ResponseEntity<>(book, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Book> update(@PathVariable(name = "id") int id, @RequestBody @Valid Book book){

        final boolean updated = bookService.updateBookById(book, id);
        return updated ? new ResponseEntity<>(book, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable(name = "id") @Valid int id){

        final boolean deleted = bookService.deleteBookById(id);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

