package com.ems.controller;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody @Valid Employee emp)
    {
        return new ResponseEntity<>(service.saveEmployee(emp), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAll()
    {
        return service.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id)
    {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id,@RequestBody @Valid Employee emp)
    {
        return service.updateEmployee(id,emp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee Deleted Successfully");
    }
}
