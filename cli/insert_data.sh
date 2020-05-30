
aws dynamodb put-item \
--table-name Project_Qilin  \
--item \
    '{"projectName": {"S": "No One You Know"}, "projectType": {"S": "Call Me Today"}, "memberName": {"S": "Somewhat Famous"}, "startDate": {"S": "1"}}'

aws dynamodb put-item \
--table-name Project_Qilin  \
--item \
    '{"projectName": {"S": "Test Project"}, "projectType": {"S": "Type 1"}, "memberName": {"S": "Tim"}, "startDate": {"N": "13322"}}'

aws dynamodb put-item \
--table-name Project_Qilin  \
--item \
    '{"projectName": {"S": "Test Project2"}, "projectType": {"S": "Type 1"}, "memberName": {"S": "Leo"}, "startDate": {"N": "13322"}, "foo": {"SS": ["a", "b"]}}'

aws dynamodb put-item \
--table-name Project_Qilin  \
--item \
    '{"projectName": {"S": "Test Project2"}, "projectType": {"S": "Type 2"}, "memberName": {"S": "Nov"}, "startDate": {"N": "13322"}, "foo": {"M": {"abc": {"S": "VVVV"}}}}'

aws dynamodb put-item \
--table-name Project_Qilin  \
--item \
    '{"projectName": {"S": "Test Project2"}, "projectType": {"S": "Type 3"}, "memberName": {"S": "Ken"}, "startDate": {"N": "13322"}, "foo": {"L": [{"NULL": true},{"BOOL": false}]}}'

