

aws dynamodb query \
    --table-name Project_Qilin \
    --key-condition-expression "projectName = :name" \
    --filter-expression "memberName = :memberName" \
    --expression-attribute-values  '{":name":{"S":"Test Project2"}, ":memberName": {"S": "Leo"}}'

#aws dynamodb scan \
#    --table-name Project_Qilin \
#    --filter-expression "memberName = :name" \
#    --expression-attribute-values '{":name":{"S":"Dr. Abby Smith"}}'  --endpoint-url http://localhost:8000
