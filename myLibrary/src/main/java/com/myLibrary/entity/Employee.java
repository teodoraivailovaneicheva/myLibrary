package com.myLibrary.entity;

import com.myLibrary.util.annotation.PhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.StringJoiner;

@NoArgsConstructor
@AllArgsConstructor
public class Employee {

     private int id;

    @Size(min=2, max=50)
     private String employeeFirstName;

    @Size(min=2, max=50)
     private String employeeLastName;

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

    public @Size(min = 2, max = 50) String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(@Size(min = 2, max = 50) String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public @Size(min = 2, max = 50) String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(@Size(min = 2, max = 50) String employeeLastName) {
        this.employeeLastName = employeeLastName;
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
                .add("employee's first name '" + employeeFirstName + "'")
                .add("employee's last name '" + employeeLastName + "'")
                .add("employee's email '" + email + "'")
                .add("employee's phone number '" + phoneNumber + "'")
                .toString();
        }
    }
