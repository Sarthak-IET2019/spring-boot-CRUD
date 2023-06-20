package com.codingsarthak.springBootApi.controller;

import com.codingsarthak.springBootApi.model.Employee;
import com.codingsarthak.springBootApi.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    private List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    // find employee by id
    @GetMapping(value = "/employees/{id}")
    private Employee getEmployeebyId(@PathVariable Long id){
        return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
    }

    // request body is used for json formating
    @PostMapping(value = "/employees")
    private Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @PutMapping(value = "/employees/{id}")
    private ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){

        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setEmail(employee.getEmail());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);

    }

    @DeleteMapping(value = "/employees/{id}")
    private void deleteEmployee(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }


}
