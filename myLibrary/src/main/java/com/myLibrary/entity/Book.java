package com.myLibrary.entity;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.StringJoiner;

@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private int id;

    @Size(min=2, max=50)
    private String bookAuthor;

    @Size(min=2, max=50)
    private String bookTitle;

    @Size(min=2, max=50)
    private String bookPublisher;

    @Size(min=2, max=4)
    private int pages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Size(min = 2, max = 50) String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(@Size(min = 2, max = 50) String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public @Size(min = 2, max = 50) String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(@Size(min = 2, max = 50) String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public @Size(min = 2, max = 50) String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(@Size(min = 2, max = 50) String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    @Size(min = 2, max = 4)
    public int getPages() {
        return pages;
    }

    public void setPages(@Size(min = 2, max = 4) int pages) {
        this.pages = pages;
    }

    @Override
    public String toString(){
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("id '" + id + "'")
                .add("book author '" + bookAuthor + "'")
                .add("book title '" + bookTitle + "'")
                .add("book publisher '" + bookPublisher + "'")
                .add("pages '" + pages + "'")
                .toString();
    }
}
