package ame.psb.db;

import java.util.Date;

public class Aluminum {

    private String customer;

    private String bindCondition;

    private String updateUser;

    private Date updateTime;


    public Aluminum() {
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getBindCondition() {
        return bindCondition;
    }

    public void setBindCondition(String bindCondition) {
        this.bindCondition = bindCondition;
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

    public Aluminum(Aluminum data) {
        this.customer = data.customer;
        this.bindCondition = data.bindCondition;
        this.updateUser = data.updateUser;
        this.updateTime = data.updateTime;
    }	

    @Override
    public Aluminum clone() {
    	return new Aluminum(this);
    }

    @Override
    public String toString() {
        return this.customer;
    }
}
