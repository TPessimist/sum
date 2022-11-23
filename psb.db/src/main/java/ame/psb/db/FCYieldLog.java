package ame.psb.db;

import java.util.Date;


public class FCYieldLog {

    private String id;

    private String shopOrderName;

    private String batchId;

    private String reverseField1;

    private String reverseField2;

    private String reverseField3;

    private String reverseField4;

    private String updateUser;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopOrderName() {
        return shopOrderName;
    }

    public void setShopOrderName(String shopOrderName) {
        this.shopOrderName = shopOrderName;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getReverseField1() {
        return reverseField1;
    }

    public void setReverseField1(String reverseField1) {
        this.reverseField1 = reverseField1;
    }

    public String getReverseField2() {
        return reverseField2;
    }

    public void setReverseField2(String reverseField2) {
        this.reverseField2 = reverseField2;
    }

    public String getReverseField3() {
        return reverseField3;
    }

    public void setReverseField3(String reverseField3) {
        this.reverseField3 = reverseField3;
    }

    public String getReverseField4() {
        return reverseField4;
    }

    public void setReverseField4(String reverseField4) {
        this.reverseField4 = reverseField4;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public FCYieldLog() {
    }

    public FCYieldLog(String id, String shopOrderName, String batchId, String reverseField1,
        String reverseField2, String reverseField3, String reverseField4, String updateUser,
        Date updateTime) {
        this.id = id;
        this.shopOrderName = shopOrderName;
        this.batchId = batchId;
        this.reverseField1 = reverseField1;
        this.reverseField2 = reverseField2;
        this.reverseField3 = reverseField3;
        this.reverseField4 = reverseField4;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public FCYieldLog(FCYieldLog data) {
        this.id = data.id;
        this.shopOrderName = data.shopOrderName;
        this.batchId = data.batchId;
        this.reverseField1 = data.reverseField1;
        this.reverseField2 = data.reverseField2;
        this.reverseField3 = data.reverseField3;
        this.reverseField4 = data.reverseField4;
        this.updateUser = data.updateUser;
        this.updateTime = data.updateTime;
    }	

    @Override
    public FCYieldLog clone() {
    	return new FCYieldLog(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
