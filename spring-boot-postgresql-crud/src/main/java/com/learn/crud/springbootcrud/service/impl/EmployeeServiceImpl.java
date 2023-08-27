package com.learn.crud.springbootcrud.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.crud.springbootcrud.dao.EmployeeRepository;
import com.learn.crud.springbootcrud.entity.EmployeeEntity;
import com.learn.crud.springbootcrud.exception.ResourceNotFoundException;
import com.learn.crud.springbootcrud.model.Employee;
import com.learn.crud.springbootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Employee getEmployeeById(Long empId) {
        EmployeeEntity mployeeEntity = employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + empId));
        Employee employeeDetails = objectMapper.convertValue(mployeeEntity, Employee.class);
        return employeeDetails;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = objectMapper.convertValue(employee, EmployeeEntity.class);
        employeeEntity = employeeRepository.save(employeeEntity);
        Employee emmployeeDetail = objectMapper.convertValue(employeeEntity, Employee.class);
        return emmployeeDetail;
    }

    @Override
    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + empId));

        employeeEntity.setEmpName(employeeDetails.getEmpName());
        employeeEntity.setEmpRole(employeeDetails.getEmpRole());
        employeeEntity = employeeRepository.save(employeeEntity);

        return objectMapper.convertValue(employeeEntity, Employee.class);
    }

    @Override
    public String removeEmployee(Long empId) {

        EmployeeEntity employeeEntity = employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + empId));
        employeeRepository.delete(employeeEntity);
        return "Success";
    }
}
