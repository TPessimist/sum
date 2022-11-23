package ame.psb.db;

import java.util.Date;

public class QueueTimeHoldRecord {

  private String id;

  private String tableName;

  private String content;

  private String sfcBo;

  private String deviceBo;

  private String operationBo;

  private String dptNo;

  private String state;

  private String result;

  private String updateUser;

  private Date createdTime;

  private Date updateTime;

  private String reserve1;

  private String reserve2;


  public QueueTimeHoldRecord() {
  }

  public QueueTimeHoldRecord(QueueTimeHoldRecord data) {
    this.id = data.id;
    this.tableName = data.tableName;
    this.content = data.content;
    this.sfcBo = data.sfcBo;
    this.deviceBo = data.deviceBo;
    this.operationBo = data.operationBo;
    this.dptNo = data.dptNo;
    this.state = data.state;
    this.result = data.result;
    this.updateUser = data.updateUser;
    this.createdTime = data.createdTime;
    this.updateTime = data.updateTime;
    this.reserve1 = data.reserve1;
    this.reserve2 = data.reserve2;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getDeviceBo() {
    return deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getDptNo() {
    return dptNo;
  }

  public void setDptNo(String dptNo) {
    this.dptNo = dptNo;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getReserve1() {
    return reserve1;
  }

  public void setReserve1(String reserve1) {
    this.reserve1 = reserve1;
  }

  public String getReserve2() {
    return reserve2;
  }

  public void setReserve2(String reserve2) {
    this.reserve2 = reserve2;
  }

  @Override
  public QueueTimeHoldRecord clone() {
    return new QueueTimeHoldRecord(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
