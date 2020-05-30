 aws dynamodb query \
    --table-name Project_Qilin \
    --index-name memberName-index \
    --key-condition-expression "memberName = :name" \
    --expression-attribute-values  '{":name":{"S":"Leo"}}'
