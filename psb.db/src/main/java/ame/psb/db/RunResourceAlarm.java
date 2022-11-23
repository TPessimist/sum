package ame.psb.db;

import java.util.Date;

public class RunResourceAlarm {

  private String id;

  private String resourceBo;

  private String alarmId;

  private String alarmContent;

  private Date alarmTime;

  private String verifyFlag;

  private String remark;

  private Date verifyTime;

  private String verifyUser;


  public RunResourceAlarm() {
    this.verifyFlag = "N";
  }

  public RunResourceAlarm(RunResourceAlarm data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.alarmId = data.alarmId;
    this.alarmContent = data.alarmContent;
    this.alarmTime = data.alarmTime;
    this.verifyFlag = data.verifyFlag;
    this.remark = data.remark;
    this.verifyTime = data.verifyTime;
    this.verifyUser = data.verifyUser;
  }

  public void generateId() {
    if (this.resourceBo == null || this.alarmId == null) {
      throw new NullPointerException("resourceBo||alarmId||alarmTime is null");
    }
    this.id = resourceBo + "::" + alarmId + "::" + System.currentTimeMillis();
  }

  @Override
  public RunResourceAlarm clone() {
    return new RunResourceAlarm(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getAlarmId() {
    return alarmId;
  }

  public void setAlarmId(String alarmId) {
    this.alarmId = alarmId;
  }

  public String getAlarmContent() {
    return alarmContent;
  }

  public void setAlarmContent(String alarmContent) {
    this.alarmContent = alarmContent;
  }

  public Date getAlarmTime() {
    return alarmTime;
  }

  public void setAlarmTime(Date alarmTime) {
    this.alarmTime = alarmTime;
  }

  public String getVerifyFlag() {
    return verifyFlag;
  }

  public void setVerifyFlag(String verifyFlag) {
    this.verifyFlag = verifyFlag;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Date getVerifyTime() {
    return verifyTime;
  }

  public void setVerifyTime(Date verifyTime) {
    this.verifyTime = verifyTime;
  }

  public String getVerifyUser() {
    return verifyUser;
  }

  public void setVerifyUser(String verifyUser) {
    this.verifyUser = verifyUser;
  }

}
