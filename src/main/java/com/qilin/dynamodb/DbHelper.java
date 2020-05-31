package com.qilin.dynamodb;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

public class DbHelper {
    AmazonDynamoDB client;

    public DbHelper(final String stage) {
        if ("Local".equals(stage)) {
            client = AmazonDynamoDBClientBuilder.standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "ap-southeast-1"))
                    .build();
        } else {
            client = AmazonDynamoDBClientBuilder.defaultClient();
        }
    }

    void insert(final BaseData data) {
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("Project_Qilin");
        String projectName = data.getProjectName();
        String projectType = data.getProjectType();
        String memberName = data.getMemberName();
        long startDate = data.getStartDate();

        System.out.println("Adding a new item...");
        PutItemOutcome outcome = table
                .putItem(new Item().withPrimaryKey("projectName", projectName, "projectType", projectType)
                        .withString("memberName", memberName).withNumber("startDate", startDate));

        System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());

    }

    public void update(BaseData baseData) {
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("Project_Qilin");

        UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("projectName", baseData.getProjectName(), "projectType", baseData.getProjectType())
                .withUpdateExpression("set memberName = :r").withValueMap(new ValueMap().withString(":r", baseData.getMemberName()))
                .withReturnValues(ReturnValue.UPDATED_NEW);

        System.out.println("Updating the item...");
        UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
        System.out.println("UpdateItem succeeded:\n" + outcome.getItem().toJSONPretty());
    }

    public void get(BaseData baseData) {
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("Project_Qilin");
        GetItemSpec spec = new GetItemSpec().withPrimaryKey("projectName", baseData.getProjectName(), "projectType", baseData.getProjectType());

        System.out.println("Attempting to read the item...");
        Item outcome = table.getItem(spec);
        System.out.println("GetItem succeeded: " + outcome);
    }

    public void delete(BaseData baseData) {
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("Project_Qilin");

        DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
                .withPrimaryKey(new PrimaryKey("projectName", baseData.getProjectName(), "projectType", baseData.getProjectType()))
                .withConditionExpression("startDate <= :val")
                .withValueMap(new ValueMap().withNumber(":val", 20200530));

        System.out.println("Attempting a conditional delete...");
        table.deleteItem(deleteItemSpec);
        System.out.println("DeleteItem succeeded");
    }
}
