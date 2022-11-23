package ame.psb.db;

import fj.test.Bool;
import java.util.Date;

public class ZdWarningDevice {

    private String deviceName;

    private String operationName;

    private String sfc;

    private Boolean approved;

    private String reverseField1;

    private String reverseField2;

    private String updatedUser;

    private Date updatedTime;


    public ZdWarningDevice() {
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getSfc() {
        return sfc;
    }

    public void setSfc(String sfc) {
        this.sfc = sfc;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
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

    public ZdWarningDevice(ZdWarningDevice data) {
        this.deviceName = data.deviceName;
        this.operationName = data.operationName;
        this.sfc = data.sfc;
        this.approved = data.approved;
        this.reverseField1 = data.reverseField1;
        this.reverseField2 = data.reverseField2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public ZdWarningDevice clone() {
    	return new ZdWarningDevice(this);
    }

    @Override
    public String toString() {
        return this.deviceName + ", " + this.operationName;
    }
}
