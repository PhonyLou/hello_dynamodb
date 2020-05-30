aws dynamodb scan \
     --table-name Project_Qilin \
     --filter-expression "memberName = :name" \
     --expression-attribute-values '{":name":{"S":"Leo"}}'
