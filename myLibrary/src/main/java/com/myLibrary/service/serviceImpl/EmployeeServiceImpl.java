package com.myLibrary.service.serviceImpl;

import com.myLibrary.entity.Employee;
import com.myLibrary.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Map<Integer, Employee> EMPLOYEE_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger EMPLOYEE_ID = new AtomicInteger();

    @Override
    public Employee create(Employee employee) {
        final int employeeId = EMPLOYEE_ID.incrementAndGet();
        employee.setId(employeeId);
        EMPLOYEE_REPOSITORY_MAP.put(employeeId, employee);
        try{
            return employee;
        }catch(Exception e){
            throw new RuntimeException("Failed to create employee " + e.getMessage());
        }
    }

    @Override
    public Optional<Employee> readById(int id) {
        return Optional.empty();
    }

    @Override
    public Employee findById(int id) {

        return EMPLOYEE_REPOSITORY_MAP.get(id);
    }

    @Override
    public List<Employee> findAllEmployees() {

        try{
            return new ArrayList<>(EMPLOYEE_REPOSITORY_MAP.values());
        }catch(Exception e){
            throw new RuntimeException("Failed to read all employees " + e.getMessage());
        }
    }

    @Override
    public Optional<Employee> updateEmployeeById(Employee employee, int id) {

        try{
            Optional<Employee> existingEmployeeOptional = Optional.ofNullable(EMPLOYEE_REPOSITORY_MAP.get(id));
            if (existingEmployeeOptional.isPresent()){
                Employee existingEmployee = existingEmployeeOptional.get();
                existingEmployee.setEmployeeFirstName(employee.getEmployeeFirstName());
                existingEmployee.setEmployeeLastName(employee.getEmployeeLastName());
                existingEmployee.setPhoneNumber(employee.getPhoneNumber());
                existingEmployee.setEmail(employee.getEmail());
                Employee savedEmployee = EMPLOYEE_REPOSITORY_MAP.put(id, existingEmployee);
                return Optional.of(savedEmployee);
            }else{
                return Optional.empty();
            }
        }catch(Exception e){
            throw new RuntimeException("Failed to update employee " + e.getMessage());
        }
    }

    @Override
    public boolean deleteEmployeeById(int id) {

        try{
            EMPLOYEE_REPOSITORY_MAP.remove(id);
            return true;
        }catch(Exception e){
            throw new RuntimeException("Failed to delete employee " + e.getMessage());
        }
    }
}
