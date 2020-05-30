package com.qilin.dynamodb;

import org.junit.jupiter.api.Test;

public class InsertItemTest {

    @Test
    void test_insert_item_on_local() {
        InsertItem insertItem = new InsertItem("Local");

        insertItem.insert();
    }
}
