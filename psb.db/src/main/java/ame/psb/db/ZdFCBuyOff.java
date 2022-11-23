package ame.psb.db;

import java.util.Date;

public class ZdFCBuyOff {

    private String shopOrderBo;

    private String shopOrderName;

    private String operationBo;

    private String operation;

    private String statusName;

    private String tooling1;

    private String tooling2;

    private String updatedUser;

    private Date updatedTime;

    public String getShopOrderBo() {
        return shopOrderBo;
    }

    public void setShopOrderBo(String shopOrderBo) {
        this.shopOrderBo = shopOrderBo;
    }

    public String getShopOrderName() {
        return shopOrderName;
    }

    public void setShopOrderName(String shopOrderName) {
        this.shopOrderName = shopOrderName;
    }

    public String getOperationBo() {
        return operationBo;
    }

    public void setOperationBo(String operationBo) {
        this.operationBo = operationBo;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getTooling1() {
        return tooling1;
    }

    public void setTooling1(String tooling1) {
        this.tooling1 = tooling1;
    }

    public String getTooling2() {
        return tooling2;
    }

    public void setTooling2(String tooling2) {
        this.tooling2 = tooling2;
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

    public ZdFCBuyOff() {
    }	

    public ZdFCBuyOff(ZdFCBuyOff data) {
        this.shopOrderBo = data.shopOrderBo;
        this.shopOrderName = data.shopOrderName;
        this.operationBo = data.operationBo;
        this.operation = data.operation;
        this.statusName = data.statusName;
        this.tooling1 = data.tooling1;
        this.tooling2 = data.tooling2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public ZdFCBuyOff clone() {
    	return new ZdFCBuyOff(this);
    }

    @Override
    public String toString() {
        return this.shopOrderBo + ", " + this.operationBo;
    }
}
