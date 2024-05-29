package com.myLibrary.controller;

import com.myLibrary.entity.Book;
import com.myLibrary.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookservice) {
        this.bookService = bookservice;
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody @Valid Book book){

        Book createdBook = bookService.create(book);
        return ResponseEntity.ok(createdBook);
    }

    @GetMapping
    public ResponseEntity<List<Book>> readAllBooks(){

        List<Book> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> readById(@PathVariable(name = "id") @Valid int id){

        Optional<Book> bookOptional = bookService.readById(id);
        return bookOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@PathVariable(name = "id") int id, @RequestBody @Valid Book book){

        Optional<Book> bookOptional = bookService.updateBookById(book, id);
        return bookOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") @Valid int id){

        boolean deleted = bookService.deleteBookById(id);
        if(deleted){
            return ResponseEntity.ok("Book with id " + id + "has been deleted successfully");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete book with id" + id);
        }
    }
}

