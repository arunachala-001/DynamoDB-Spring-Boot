package com.aws.dynamodb_springboot.controller;

import com.aws.dynamodb_springboot.model.Department;
import com.aws.dynamodb_springboot.repository.DepartmentRepository;
import com.aws.dynamodb_springboot.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;


    @GetMapping("/get")
    public List<Department> fetchAllDepartment() {
       return departmentRepository.findAll();
    }

    @PostMapping("/store")
    public void storeDepartment(Department department) {
        departmentRepository.save(department);
    }

    @GetMapping("/{departmentId}")
    public Department getById(String departmentId) {
        return departmentRepository.findById(departmentId);
    }
}
