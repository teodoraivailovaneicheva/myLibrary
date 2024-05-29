package com.myLibrary.service;

import com.myLibrary.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {


    Employee create(Employee employee);

    Optional<Employee> readById(int id);

    Employee findById(int id);

    List<Employee> findAllEmployees();

    Optional<Employee> updateEmployeeById(Employee employee, int id);

    boolean deleteEmployeeById(int id);
}
