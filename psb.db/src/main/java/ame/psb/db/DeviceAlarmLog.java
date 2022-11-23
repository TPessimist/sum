package ame.psb.db;

import java.util.Date;

public class DeviceAlarmLog extends DeviceAlarmDef { //记录报警信息

  private String id; //主键

  private String alarmReport; //是否确认标识

  private Date receiveTime; //接口信息接收时间

  public DeviceAlarmLog() {
  }

  public DeviceAlarmLog(DeviceAlarmLog data) {
    this.id = data.id;
    this.alarmReport = data.alarmReport;
    this.receiveTime = data.receiveTime;
  }

  @Override
  public DeviceAlarmLog clone() {
    return new DeviceAlarmLog(this);
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

  public String getAlarmReport() {
    return alarmReport;
  }

  public void setAlarmReport(String alarmReport) {
    this.alarmReport = alarmReport;
  }

  public Date getReceiveTime() {
    return receiveTime;
  }

  public void setReceiveTime(Date receiveTime) {
    this.receiveTime = receiveTime;
  }

}
