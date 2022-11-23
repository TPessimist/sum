package ame.psb.db;

import java.util.Date;

public class ZdCpLocationDatalog {

    private String uuid;

    private String customerItemBo;

    private String custom1;

    private String custom2;

    private String updatedUser;

    private Date updatedTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCustomerItemBo() {
        return customerItemBo;
    }

    public void setCustomerItemBo(String customerItemBo) {
        this.customerItemBo = customerItemBo;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
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

    public ZdCpLocationDatalog() {
    }	

    public ZdCpLocationDatalog(ZdCpLocationDatalog data) {
        this.uuid = data.uuid;
        this.customerItemBo = data.customerItemBo;
        this.custom1 = data.custom1;
        this.custom2 = data.custom2;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public ZdCpLocationDatalog clone() {
    	return new ZdCpLocationDatalog(this);
    }

    @Override
    public String toString() {
        return this.uuid + ", " + this.customerItemBo;
    }
}
