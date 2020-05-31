package com.qilin.dynamodb;

import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import org.junit.jupiter.api.Test;

public class DbHelperTest {

    @Test
    void test_insert_item_on_local() {
        DbHelper dbHelper = new DbHelper("Local");
        BaseData baseData = new BaseData("Project-DynamoDB-1",
                "Offshore", "Dr. Zen", 20200530L);
        PutItemOutcome outcome = dbHelper.insert(baseData);
    }
}
