package ame.htks.db;

import java.math.BigDecimal;
import java.util.Date;

public class PlatingMantenance {

  private String resourceBo;

  private String desc;

  private String fatherResourceBo;

  private String tankType;

  private BigDecimal tankSize;

  private BigDecimal replacementCycleHours;

  private BigDecimal currentHours;

  private String emptyFlag;

  private Date lastReplaceTime;

  private BigDecimal limitTimes;

  private BigDecimal currentTimes;

  private String remarks;

  private BigDecimal limitAh;

  private BigDecimal currentAh;

  private Date updateTime;

  private String updateUser;


  public PlatingMantenance() {
  }

  public PlatingMantenance(PlatingMantenance data) {
    this.resourceBo = data.resourceBo;
    this.desc = data.desc;
    this.fatherResourceBo = data.fatherResourceBo;
    this.tankType = data.tankType;
    this.tankSize = data.tankSize;
    this.replacementCycleHours = data.replacementCycleHours;
    this.currentHours = data.currentHours;
    this.emptyFlag = data.emptyFlag;
    this.lastReplaceTime = data.lastReplaceTime;
    this.limitTimes = data.limitTimes;
    this.currentTimes = data.currentTimes;
    this.remarks = data.remarks;
    this.limitAh = data.limitAh;
    this.currentAh = data.currentAh;
    this.updateTime = data.updateTime;
    this.updateUser = data.updateUser;
  }

  @Override
  public PlatingMantenance clone() {
    return new PlatingMantenance(this);
  }

  @Override
  public String toString() {
    return this.resourceBo;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getFatherResourceBo() {
    return fatherResourceBo;
  }

  public void setFatherResourceBo(String fatherResourceBo) {
    this.fatherResourceBo = fatherResourceBo;
  }

  public String getTankType() {
    return tankType;
  }

  public void setTankType(String tankType) {
    this.tankType = tankType;
  }

  public BigDecimal getTankSize() {
    return tankSize;
  }

  public void setTankSize(BigDecimal tankSize) {
    this.tankSize = tankSize;
  }

  public BigDecimal getReplacementCycleHours() {
    return replacementCycleHours;
  }

  public void setReplacementCycleHours(BigDecimal replacementCycleHours) {
    this.replacementCycleHours = replacementCycleHours;
  }

  public BigDecimal getCurrentHours() {
    return currentHours;
  }

  public void setCurrentHours(BigDecimal currentHours) {
    this.currentHours = currentHours;
  }

  public String getEmptyFlag() {
    return emptyFlag;
  }

  public void setEmptyFlag(String emptyFlag) {
    this.emptyFlag = emptyFlag;
  }

  public Date getLastReplaceTime() {
    return lastReplaceTime;
  }

  public void setLastReplaceTime(Date lastReplaceTime) {
    this.lastReplaceTime = lastReplaceTime;
  }

  public BigDecimal getLimitTimes() {
    return limitTimes;
  }

  public void setLimitTimes(BigDecimal limitTimes) {
    this.limitTimes = limitTimes;
  }

  public BigDecimal getCurrentTimes() {
    return currentTimes;
  }

  public void setCurrentTimes(BigDecimal currentTimes) {
    this.currentTimes = currentTimes;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public BigDecimal getLimitAh() {
    return limitAh;
  }

  public void setLimitAh(BigDecimal limitAh) {
    this.limitAh = limitAh;
  }

  public BigDecimal getCurrentAh() {
    return currentAh;
  }

  public void setCurrentAh(BigDecimal currentAh) {
    this.currentAh = currentAh;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

}
