package com.myLibrary.entity;

import com.myLibrary.util.annotation.PhoneNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "READERS")
public class Reader {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false, name = "ID")
        private Long id;

        @Column(nullable = false, name = "READER_FIRST_NAME")
        @NonNull
        @NotBlank
        @Size(min = 2, max = 20, message = "Reader's first name must be from 2 to 20 letters length")
//      @OneToOne(mappedBy = "Book title", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//      @JsonManagedReference
        private String readerFirstName;

        @Column(nullable = false, name = "READER_LAST_NAME")
        @NonNull
        @NotBlank
        @Size(min = 2, max = 20, message = "Reader's last name must be from 2 to 20 letters length")
//      @OneToOne(mappedBy = "Book title", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//      @JsonManagedReference
        private String readerLastName;

        @Column(nullable = false, name = "READER_PHONE_NUMBER")
        @NonNull
        @NotBlank
        @PhoneNumber
//      @OneToMany(mappedBy = "Book title", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//      @JsonManagedReference
        private int phoneNumber;

        @Column(nullable = false, name = "READER_EMAIL")
        @NonNull
        @NotBlank
        @Size(min = 5, max = 40)
        @Email
        private String email;

        @Override
        public String toString(){
            return new StringJoiner(", ", com.myLibrary.entity.Book.class.getSimpleName() + "[", "]")
                    .add("id '" + id + "'")
                    .add("reader's first name '" + readerFirstName + "'")
                    .add("reader's last name '" + readerLastName + "'")
                    .add("reader's email '" + email + "'")
                    .add("reader's phone number '" + phoneNumber + "'")
                    .toString();
        }
    }
