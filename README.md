# hello_dynamodb

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
