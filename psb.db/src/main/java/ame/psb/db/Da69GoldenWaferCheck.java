package ame.psb.db;

import java.util.Date;

public class Da69GoldenWaferCheck {

    private String id;

    private String sfcBo;

    private String sfcName;

    private String flag;

    private String updatedUser;

    private Date updatedTime;

    private String value1;

    private String value2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public Da69GoldenWaferCheck() {
    }	

    public Da69GoldenWaferCheck(Da69GoldenWaferCheck data) {
        this.id = data.id;
        this.sfcBo = data.sfcBo;
        this.sfcName = data.sfcName;
        this.flag = data.flag;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
        this.value1 = data.value1;
        this.value2 = data.value2;
    }	

    @Override
    public Da69GoldenWaferCheck clone() {
    	return new Da69GoldenWaferCheck(this);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
