package ame.psb.db;

import java.util.Date;

public class DeviceAlarmDef { //机台报警代码维护表

  private String deviceCode; //机台类型代码

  private String alarmCode; //报警代码

  private String description; //报警信息描述

  private String englishDescription; //报警英文描述

  private String alarmLevel; //报警等级

  private String deviceType; //机台类型描述

  private String handleMethod; //处理方式指南

  private String remarks; //备用数据列1

  private String note; //备用数据列2

  private String updatedUser; //维护人员

  private Date updatedTime; //维护时间


  public DeviceAlarmDef() {
  }

  public DeviceAlarmDef(DeviceAlarmDef data) {
    this.deviceCode = data.deviceCode;
    this.alarmCode = data.alarmCode;
    this.description = data.description;
    this.englishDescription = data.englishDescription;
    this.alarmLevel = data.alarmLevel;
    this.deviceType = data.deviceType;
    this.handleMethod = data.handleMethod;
    this.remarks = data.remarks;
    this.note = data.note;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public DeviceAlarmDef clone() {
    return new DeviceAlarmDef(this);
  }

  @Override
  public String toString() {
    return this.deviceCode + ", " + this.alarmCode;
  }

  public String getDeviceCode() {
    return deviceCode;
  }

  public void setDeviceCode(String deviceCode) {
    this.deviceCode = deviceCode;
  }

  public String getAlarmCode() {
    return alarmCode;
  }

  public void setAlarmCode(String alarmCode) {
    this.alarmCode = alarmCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getEnglishDescription() {
    return englishDescription;
  }

  public void setEnglishDescription(String englishDescription) {
    this.englishDescription = englishDescription;
  }

  public String getAlarmLevel() {
    return alarmLevel;
  }

  public void setAlarmLevel(String alarmLevel) {
    this.alarmLevel = alarmLevel;
  }

  public String getDeviceType() {
    return deviceType;
  }

  public void setDeviceType(String deviceType) {
    this.deviceType = deviceType;
  }

  public String getHandleMethod() {
    return handleMethod;
  }

  public void setHandleMethod(String handleMethod) {
    this.handleMethod = handleMethod;
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
