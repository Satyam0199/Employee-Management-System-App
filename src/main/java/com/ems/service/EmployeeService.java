package com.ems.service;

import com.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id,Employee employee);
    void deleteEmployee(Long id);
}
