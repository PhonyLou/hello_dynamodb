
aws dynamodb get-item --consistent-read \
    --table-name Project_Qilin \
    --key '{ "projectName": {"S": "Test Project2"}, "projectType": {"S": "Type 1"}}'
