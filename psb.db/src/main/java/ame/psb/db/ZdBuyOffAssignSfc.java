package ame.psb.db;

import java.util.Date;

public class ZdBuyOffAssignSfc {

    private String sfcBo;

    private String sfcName;

    private String operationBo;

    private String operationName;

    private String reverseField1;

    private String reverseField2;

    private String createdUser;

    private Date createdTime;


    public ZdBuyOffAssignSfc() {
    }	

    public ZdBuyOffAssignSfc(ZdBuyOffAssignSfc data) {
        this.sfcBo = data.sfcBo;
        this.sfcName = data.sfcName;
        this.operationBo = data.operationBo;
        this.operationName = data.operationName;
        this.reverseField1 = data.reverseField1;
        this.reverseField2 = data.reverseField2;
        this.createdUser = data.createdUser;
        this.createdTime = data.createdTime;
    }

    public String getSfcBo() {
        return sfcBo;
    }

    public void setSfcBo(String sfcBo) {
        this.sfcBo = sfcBo;
    }

    public String getSfcName() {
        return sfcName;
    }

    public void setSfcName(String sfcName) {
        this.sfcName = sfcName;
    }

    public String getOperationBo() {
        return operationBo;
    }

    public void setOperationBo(String operationBo) {
        this.operationBo = operationBo;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
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

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public ZdBuyOffAssignSfc clone() {
    	return new ZdBuyOffAssignSfc(this);
    }

    @Override
    public String toString() {
        return this.sfcBo + ", " + this.operationBo;
    }
}
