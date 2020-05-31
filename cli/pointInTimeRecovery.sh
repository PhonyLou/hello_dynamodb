aws dynamodb update-continuous-backups \
--table-name Project_Qilin \
--point-in-time-recovery-specification PointInTimeRecoveryEnabled=True

#aws dynamodb describe-continuous-backups \
#--table-name Project_Qilin

# restore to latest time
aws dynamodb restore-table-to-point-in-time \
--source-table-name Project_Qilin \
--target-table-name Project_Qilin_MinutesAgo \
--use-latest-restorable-time

# restore to a special time
#aws dynamodb restore-table-to-point-in-time \
#--source-table-name Project_Qilin \
#--target-table-name Project_Qilin_DateTime \
#--no-use-latest-restorable-time \
#--restore-date-time 1519257118.0
