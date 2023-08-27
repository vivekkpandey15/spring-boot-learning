package com.learn.crud.springbootcrud.service;

import com.learn.crud.springbootcrud.model.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    Employee getEmployeeById(Long empId);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(Long empId, Employee employeeDetails);

    String removeEmployee(Long empId);
}
