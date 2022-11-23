package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class DeviceAlarmLevelMaintain {

  private String alarmLevel; //报警等级

  private String description; //报警描述

  private BigDecimal checkCycle; //报警检测周期

  private BigDecimal checkTimes; //周期内触发报警的次数

  private String handleUser; //处理人员

  private String handleMode; //处理方式

  private String upgradeCondition; //升级条件

  private String remarks; //备注

  private String note; //备用列1

  private String updatedUser; //更新人员

  private Date updatedTime; //更新时间


  public DeviceAlarmLevelMaintain() {
  }

  public DeviceAlarmLevelMaintain(DeviceAlarmLevelMaintain data) {
    this.alarmLevel = data.alarmLevel;
    this.description = data.description;
    this.checkCycle = data.checkCycle;
    this.checkTimes = data.checkTimes;
    this.handleUser = data.handleUser;
    this.handleMode = data.handleMode;
    this.upgradeCondition = data.upgradeCondition;
    this.remarks = data.remarks;
    this.note = data.note;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public DeviceAlarmLevelMaintain clone() {
    return new DeviceAlarmLevelMaintain(this);
  }

  @Override
  public String toString() {
    return this.alarmLevel;
  }

  public String getAlarmLevel() {
    return alarmLevel;
  }

  public void setAlarmLevel(String alarmLevel) {
    this.alarmLevel = alarmLevel;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getCheckCycle() {
    return checkCycle;
  }

  public void setCheckCycle(BigDecimal checkCycle) {
    this.checkCycle = checkCycle;
  }

  public BigDecimal getCheckTimes() {
    return checkTimes;
  }

  public void setCheckTimes(BigDecimal checkTimes) {
    this.checkTimes = checkTimes;
  }

  public String getHandleUser() {
    return handleUser;
  }

  public void setHandleUser(String handleUser) {
    this.handleUser = handleUser;
  }

  public String getHandleMode() {
    return handleMode;
  }

  public void setHandleMode(String handleMode) {
    this.handleMode = handleMode;
  }

  public String getUpgradeCondition() {
    return upgradeCondition;
  }

  public void setUpgradeCondition(String upgradeCondition) {
    this.upgradeCondition = upgradeCondition;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
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
}
