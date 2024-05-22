package com.myLibrary.entity;

import com.myLibrary.util.annotation.PhoneNumber;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.StringJoiner;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reader {

        private int id;

        private String readerFirstName;

        private String readerLastName;

        @PhoneNumber
        private int phoneNumber;

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
