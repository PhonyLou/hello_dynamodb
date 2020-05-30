

aws dynamodb query \
    --table-name Project_Qilin \
    --key-condition-expression "projectName = :name" \
    --filter-expression "memberName = :memberName" \
    --expression-attribute-values  '{":name":{"S":"Test Project2"}, ":memberName": {"S": "Leo"}}'

