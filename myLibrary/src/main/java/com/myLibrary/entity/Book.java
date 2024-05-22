package com.myLibrary.entity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.StringJoiner;

@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private int id;

    private String bookAuthor;

    private String bookTitle;

    private String bookPublisher;

    private int pages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @NotBlank @Size(min = 2, max = 40, message = "Book author's name must be from 2 to 30 letters length")
            String getBookAuthor() {
                 return bookAuthor;
    }

    public void setBookAuthor(@NotNull @NotBlank @Size(min = 2, max = 40, message = "Book author's name must be from 2 to 30 letters length")
           String bookAuthor) {
                 this.bookAuthor = bookAuthor;
    }

    public @NotNull @NotBlank @Size(min = 2, max = 40, message = "Book title's name must be from 2 to 40 letters length")
           String getBookTitle() {
                 return bookTitle;
    }

    public void setBookTitle(@NotNull @NotBlank @Size(min = 2, max = 40, message = "Book title's name must be from 2 to 40 letters length")
           String bookTitle) {
                 this.bookTitle = bookTitle;
    }

    public @NotNull @NotBlank @Size(min = 2, max = 40, message = "Book publisher's name must be from 2 to 30 letters length")
           String getBookPublisher() {
                return bookPublisher;
    }

    public void setBookPublisher(@NotNull @NotBlank @Size(min = 2, max = 40, message = "Book publisher's name must be from 2 to 30 letters length")
           String bookPublisher) {
                this.bookPublisher = bookPublisher;
    }

    @NotNull @NotBlank @Size(min = 2, max = 5) @Digits(integer = 2, fraction = 0, message = "Pages must be at least 2 digits")
    public int getPages() {
           return pages;
    }

    public void setPages(@NotNull @NotBlank @Size(min = 2, max = 5) @Digits(integer = 2, fraction = 0, message = "Pages must be at least 2 digits") int pages) {
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
