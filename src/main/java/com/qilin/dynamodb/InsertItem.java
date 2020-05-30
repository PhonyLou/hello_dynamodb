package com.qilin.dynamodb;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

public class InsertItem {
    AmazonDynamoDB client;

    public InsertItem(final String stage) {
        if ("Local".equals(stage)) {
            client = AmazonDynamoDBClientBuilder.standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "ap-southeast-1"))
                    .build();
        } else {
            client = AmazonDynamoDBClientBuilder.defaultClient();
        }
    }

    PutItemOutcome insert() {
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("Project_Qilin");
        String projectName = "Project-DynamoDB-1";
        String projectType = "Offshore";
        String memberName = "Dr. Zen";
        long startDate = 20200530L;

        System.out.println("Adding a new item...");
        PutItemOutcome outcome = table
                .putItem(new Item().withPrimaryKey("projectName", projectName, "projectType", projectType)
                        .withString("memberName", memberName).withNumber("startDate", startDate));

        System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());

        return outcome;

    }
}
