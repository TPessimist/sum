package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class PkgPackingNewPlan {

    private String newPlan;

    private String mainPlan;

    private BigDecimal qty;

    private String unit;

    private String value;

    private String content;

    private String updatedUser;

    private Date updatedTime;

    public String getNewPlan() {
        return newPlan;
    }

    public void setNewPlan(String newPlan) {
        this.newPlan = newPlan;
    }

    public String getMainPlan() {
        return mainPlan;
    }

    public void setMainPlan(String mainPlan) {
        this.mainPlan = mainPlan;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public PkgPackingNewPlan() {
    }	

    public PkgPackingNewPlan(PkgPackingNewPlan data) {
        this.newPlan = data.newPlan;
        this.mainPlan = data.mainPlan;
        this.qty = data.qty;
        this.unit = data.unit;
        this.value = data.value;
        this.content = data.content;
        this.updatedUser = data.updatedUser;
        this.updatedTime = data.updatedTime;
    }	

    @Override
    public PkgPackingNewPlan clone() {
    	return new PkgPackingNewPlan(this);
    }

    @Override
    public String toString() {
        return this.newPlan;
    }
}
