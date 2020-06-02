# hello_dynamodb

#### 什么是 NoSQL

SQL 是结构化查询语言的缩写，其操作的数据是结构化的
NoSQL 是另一种数据存储方式，主要存储对象是非结构化数据（Key-Value Pair, Documents, etc）

#### 什么是 DyanmoDB

DynamoDB 是AWS提供的一种全托管、高性能NoSQL数据库。

### Practice Tasks

#### Create Table
Create a table ```Project_Qilin```, 
the partition key is ```projectName``` and the sort key should be ```projectType```

```shell script
$ aws dynamodb create-table \
      --table-name Project_Qilin \
      --attribute-definitions \
        AttributeName=projectName,AttributeType=S \
        AttributeName=projectType,AttributeType=S \
      --key-schema AttributeName=projectName,KeyType=HASH AttributeName=projectType,KeyType=RANGE \
      --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1
```

#### Update Table
Add two Attributes: ```memberName```, ```startDate```

Do it by manual

#### Insert data
Parameter type must be one of: S, N, B, SS, NS, BS, M, L, NULL, BOOL
```shell script
$ sh insert_data.sh
```

#### Update data
```shell script
$ sh update_data.sh
```

#### Update data
```shell script
$ sh retrieve_data.sh
```

#### query data
```shell script
$ sh query_data.sh
```

#### Scan data
```shell script
$ sh scan.sh
```

#### GSI
Create GSI by manual, query GSI by using
```shell script
$ sh query_GSI.sh
```

### Q&A
1. 以下哪种是NoSql数据库?

- 图数据库
- 键-值存储库
- 列式数据库
- 文档数据库

2. 下面哪些场景SQL不能发挥作用? -- 数据不是结构化的

3. DynamoDB有哪两种类型的主键? -- 分区键，排序键
4. 主键不支持的数据类型? -- array

5. DynamoDB支持哪两种类型的索引,这两种索引的区别是什么?
- 全局二级索引，分区键可以自定义，排序键可选
- 本地二级索引，分区键必须使用基表分区键，排序键与基表不同

#### Starting local dynamoDB

```shell script
$ sh start-local-db.sh
```
