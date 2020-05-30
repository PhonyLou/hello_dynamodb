
aws dynamodb put-item \
--table-name Project_Qilin  \
--item \
    '{"projectName": {"S": "No One You Know"}, "projectType": {"S": "Call Me Today"}, "memberName": {"S": "666 Somewhat Famous"}, "startDate": {"S": "1"}}'
