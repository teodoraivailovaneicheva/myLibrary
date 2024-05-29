package com.myLibrary.controller;

import com.myLibrary.entity.Employee;
import com.myLibrary.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

        private final EmployeeService employeeService;

        @Autowired
        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }

        @PostMapping
        public ResponseEntity<Employee> create(@RequestBody @Valid Employee employee){

            Employee createdEmployee = employeeService.create(employee);
            return ResponseEntity.ok(createdEmployee);
        }

        @GetMapping
        public ResponseEntity<List<Employee>> readAllEmployees(){

            List<Employee> employees = employeeService.findAllEmployees();
            return ResponseEntity.ok(employees);
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<Employee> readById(@PathVariable(name = "id") @Valid int id){

            Optional<Employee> employeeOptional = employeeService.readById(id);
            return employeeOptional.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<Employee> update(@PathVariable(name = "id") int id, @RequestBody @Valid Employee employee){

            Optional<Employee> employeeOptional = employeeService.updateEmployeeById(employee, id);
            return employeeOptional.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<String> delete(@PathVariable(name = "id") @Valid int id){

            boolean deleted = employeeService.deleteEmployeeById(id);
            if(deleted){
                return ResponseEntity.ok("Employee with id " + id + "has been deleted successfully");
            }else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete employee with id" + id);
            }
        }
}
