package com.qilin.dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

public class InsertItem {
    public static void main(String[] args) {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Project_Qilin");

        String projectName = "Project-DynamoDB-1";
        String projectType = "Offshore";
        String memberName = "Dr. Zen";
        long startDate = 20200530L;

        try {
            System.out.println("Adding a new item...");
            PutItemOutcome outcome = table
                    .putItem(new Item().withPrimaryKey("projectName", projectName, "projectType", projectType)
                            .withString("memberName", memberName).withNumber("startDate", startDate));

            System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());

        }
        catch (Exception e) {
            System.err.println("Unable to add item: " + projectName + " " + projectType);
            System.err.println(e.getMessage());
        }

    }
}
