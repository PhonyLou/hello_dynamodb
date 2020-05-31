package com.qilin.dynamodb;

import org.junit.jupiter.api.Test;

public class DbHelperTest {

    @Test
    void test_insert_item_on_local() {
        DbHelper dbHelper = new DbHelper("Local");
        BaseData baseData = new BaseData("Project-DynamoDB-1",
                "Offshore", "Dr. Zen", 20200530L);
        dbHelper.insert(baseData);
    }

    @Test
    void test_get_item_on_local() {
        DbHelper dbHelper = new DbHelper("Local");
        BaseData baseData = new BaseData("Project-DynamoDB-1",
                "Offshore", "Dr. Zen", 20200530L);
        dbHelper.get(baseData);
    }

    @Test
    void test_update_item_on_local() {
        DbHelper dbHelper = new DbHelper("Local");
        BaseData baseData = new BaseData("Project-DynamoDB-1",
                "Offshore", "Dr. Abby Smith", 20200530L);
        dbHelper.update(baseData);
    }

    @Test
    void test_delete_item_on_local() {
        DbHelper dbHelper = new DbHelper("Local");
        BaseData baseData = new BaseData("Project-DynamoDB-1",
                "Offshore", "Dr. Abby Smith", 20200530L);
        dbHelper.delete(baseData);
    }
}
