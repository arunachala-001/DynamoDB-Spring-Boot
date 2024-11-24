package com.aws.dynamodb_springboot.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.aws.dynamodb_springboot.model.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DepartmentRepository {

    @Autowired
    private final DynamoDBMapper dynamoDBMapper;

    public List<Department> findAll() {
        DynamoDBScanExpression dynamoDBScanExpression = new DynamoDBScanExpression();
        return dynamoDBMapper.scan(Department.class, dynamoDBScanExpression);
    }

    public void save(Department department) {
        dynamoDBMapper.save(department);
    }

    public Department findById(String departmentId) {
        return dynamoDBMapper.load(Department.class, departmentId);
    }
}
