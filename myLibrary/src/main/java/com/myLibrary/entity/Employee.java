package com.myLibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "EMPLOYEES")
public class Employee {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(nullable = false, name = "ID")
     private Long id;

     @Column(nullable = false, name = "EMPLOYEE_FIRST_NAME")
     @NonNull
     @NotBlank
     @Size(min = 2, max = 20, message = "Employee's first name must be from 2 to 20 letters length")
     private String employeeFirstName;

     @Column(nullable = false, name = "EMPLOYEE_LAST_NAME")
     @NonNull
     @NotBlank
     @Size(min = 2, max = 20, message = "Employee's last name must be from 2 to 20 letters length")
     private String employeeLastName;

    @Column(nullable = false, name = "EMPLOYEE_PHONE_NUMBER")
    @NonNull
    @NotBlank
    @PhoneNumber
    @JsonIgnore
//      @OneToMany(mappedBy = "Book title", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//      @JsonManagedReference
    private int phoneNumber;

    @Column(nullable = false, name = "EMPLOYEE_EMAIL")
    @NonNull
    @NotBlank
    @Size(min = 5, max = 40)
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
