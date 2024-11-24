package com.aws.dynamodb_springboot.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.aws.dynamodb_springboot.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {

    @Autowired
    private final DynamoDBMapper dynamoDBMapper;

    //Custom Query
    public List<Employee> findByDepartment(String departmentId) {
        Employee employee = new Employee();
        employee.setDepartmentId(departmentId);

        DynamoDBQueryExpression<Employee> queryExpression = new DynamoDBQueryExpression<Employee>()
                .withHashKeyValues(employee);

        return dynamoDBMapper.query(Employee.class, queryExpression);
    }

    public Employee findById(String employeeId) {
        return dynamoDBMapper.load(Employee.class, employeeId);
    }

    public void delete(String employeeId) {
        Employee employee = findById(employeeId);

        if(employee != null) {
            dynamoDBMapper.delete(employee);
        }
    }
}
