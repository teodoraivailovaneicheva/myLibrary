package com.myLibrary.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.StringJoiner;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ID")
    private Long id;

    @Column(nullable = false, name = "BOOK_AUTHOR")
    @NonNull
    @NotBlank
    @Size(min = 2, max =40, message = "Book author's name must be from 2 to 30 letters length")
    @OneToOne(mappedBy = "Book title", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private String bookAuthor;

    @Column(nullable = false, name = "BOOK_TITLE")
    @NonNull
    @NotBlank
    @Size(min = 2, max = 40, message = "Book title's name must be from 2 to 40 letters length")
    //@OneToOne(mappedBy = "Book author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JsonManagedReference
    private String bookTitle;

    @Column(nullable = false, name = "BOOK_PUBLISHER")
    @NonNull
    @NotBlank
    @Size(min = 2, max =40, message = "Book publisher's name must be from 2 to 30 letters length")
    //@OneToMany(mappedBy = "Book title", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JsonManagedReference
    private String bookPublisher;

    @Column(nullable = false, name = "BOOK_PAGES")
    @NonNull
    @NotBlank
    @Size(min = 2, max = 5)
    @Digits(integer=2, fraction=0, message="Pages must be at least 2 digits")
    private int pages;

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
