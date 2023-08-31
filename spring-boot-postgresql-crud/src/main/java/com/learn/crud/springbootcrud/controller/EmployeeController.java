package com.learn.crud.springbootcrud.controller;

import com.learn.crud.springbootcrud.dao.EmployeeRepository;
import com.learn.crud.springbootcrud.model.Employee;
import com.learn.crud.springbootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    // Rest APi to add/create employee
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    // Get employee by id passing employee id
    @GetMapping("/getEmployeeById/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(empId));
    }

    // API to update employee details
    @PutMapping("/updateEmployee/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long empId, @RequestBody Employee employeeDetails) {
        return ResponseEntity.ok(employeeService.updateEmployee(empId, employeeDetails));
    }

    // Rest API to delete employee details
    @DeleteMapping("/deleteEmployee/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long empId) {

        try {
            String response = employeeService.removeEmployee(empId);
            if ("Success".equalsIgnoreCase(response)) {
                return ResponseEntity.ok("Employee record removed successfully!");
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok("Employee record not removed!");
    }

    /**
     * Get all the employees
     */
    @GetMapping("/getEmployeeDetails")
    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            return new ResponseEntity<>(employeeService.getEmployeeList(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
