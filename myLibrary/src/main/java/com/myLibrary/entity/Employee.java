package com.myLibrary.entity;

import com.myLibrary.util.annotation.PhoneNumber;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.StringJoiner;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

     private int id;

     private String employeeFirstName;

     private String employeeLastName;

    @PhoneNumber
    private int phoneNumber;

    @Email
    private String email;


    @Override
    public String toString(){
        return new StringJoiner(", ", com.myLibrary.entity.Book.class.getSimpleName() + "[", "]")
                .add("id '" + id + "'")
                .add("employee's first name '" + employeeFirstName + "'")
                .add("employee's last name '" + employeeLastName + "'")
                .add("employee's email '" + email + "'")
                .add("employee's phone number '" + phoneNumber + "'")
                .toString();
        }
    }
