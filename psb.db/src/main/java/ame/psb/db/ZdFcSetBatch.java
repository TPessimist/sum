package ame.psb.db;

import java.util.Date;

public class ZdFcSetBatch {

    private String shopOrderBo;

    private String batchId;

    private String state;

    private String content;

    private String reversedField1;

    private String reversedField2;

    private String updatedUser;

    private Date updatedTime;

    public String getShopOrderBo() {
        return shopOrderBo;
    }

    public void setShopOrderBo(String shopOrderBo) {
        this.shopOrderBo = shopOrderBo;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReversedField1() {
        return reversedField1;
    }

    public void setReversedField1(String reversedField1) {
        this.reversedField1 = reversedField1;
    }

    public String getReversedField2() {
        return reversedField2;
    }

    public void setReversedField2(String reversedField2) {
        this.reversedField2 = reversedField2;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public ZdFcSetBatch() {
    }	

    public ZdFcSetBatch(ZdFcSetBatch data) {
        this.shopOrderBo = data.shopOrderBo;
        this.batchId = data.batchId;
        this.state = data.state;
        this.content = data.content;
        this.reversedField1 = data.reversedField1;
        this.reversedField2 = data.reversedField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public ZdFcSetBatch clone() {
    	return new ZdFcSetBatch(this);
    }

    @Override
    public String toString() {
        return this.shopOrderBo;
    }
}
