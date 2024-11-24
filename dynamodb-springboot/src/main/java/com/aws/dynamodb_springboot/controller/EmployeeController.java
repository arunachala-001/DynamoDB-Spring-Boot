package com.aws.dynamodb_springboot.controller;

import com.aws.dynamodb_springboot.model.Employee;
import com.aws.dynamodb_springboot.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/custom/{departmentId}")
    public List<Employee> fetchByDepartmentId(String departmentId) {
        return employeeRepository.findByDepartment(departmentId);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void DeleteEmployee(String employeeId) {
        employeeRepository.delete(employeeId);
    }
}
