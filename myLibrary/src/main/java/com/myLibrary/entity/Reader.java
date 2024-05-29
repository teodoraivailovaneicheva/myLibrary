package com.myLibrary.entity;

import com.myLibrary.util.annotation.PhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.StringJoiner;

@NoArgsConstructor
@AllArgsConstructor
public class Reader {

        private int id;

        @Size(min=2, max=50)
        private String readerFirstName;

        @Size(min=2, max=50)
        private String readerLastName;

        @PhoneNumber
        private int phoneNumber;

        @Email
        private String email;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public @Size(min = 2, max = 50) String getReaderFirstName() {
                return readerFirstName;
        }

        public void setReaderFirstName(@Size(min = 2, max = 50) String readerFirstName) {
                this.readerFirstName = readerFirstName;
        }

        public @Size(min = 2, max = 50) String getReaderLastName() {
                return readerLastName;
        }

        public void setReaderLastName(@Size(min = 2, max = 50) String readerLastName) {
                this.readerLastName = readerLastName;
        }

        @PhoneNumber
        public int getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(@PhoneNumber int phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public @Email String getEmail() {
                return email;
        }

        public void setEmail(@Email String email) {
                this.email = email;
        }

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
