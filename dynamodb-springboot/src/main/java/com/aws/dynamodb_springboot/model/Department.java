package com.aws.dynamodb_springboot.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName = "department")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String departmentId;
    @DynamoDBAttribute
    private String departmentName;
}
