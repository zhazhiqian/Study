package com.example.summerpublicapi.bigclassify.dao.result;

public class BigClassifyQueryResponse {

    private String bigClassifyId;

    private String bigClassifyName;

    private String createUserName;

    private String createTime;

    private String updateUserName;

    private String updateTime;

    private String operatorStatus;

    private String remark;

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBigClassifyId() {
        return bigClassifyId;
    }

    public void setBigClassifyId(String bigClassifyId) {
        this.bigClassifyId = bigClassifyId;
    }

    public String getBigClassifyName() {
        return bigClassifyName;
    }

    public void setBigClassifyName(String bigClassifyName) {
        this.bigClassifyName = bigClassifyName;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOperatorStatus() {
        return operatorStatus;
    }

    public void setOperatorStatus(String operatorStatus) {
        this.operatorStatus = operatorStatus;
    }
}
