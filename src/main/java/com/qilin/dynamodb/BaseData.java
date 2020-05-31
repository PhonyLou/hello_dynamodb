package com.qilin.dynamodb;

public class BaseData {
    String projectName;
    String projectType;
    String memberName;
    long startDate;

    public BaseData(String projectName, String projectType, String memberName, long startDate) {
        this.projectName = projectName;
        this.projectType = projectType;
        this.memberName = memberName;
        this.startDate = startDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public String getMemberName() {
        return memberName;
    }

    public long getStartDate() {
        return startDate;
    }
}
