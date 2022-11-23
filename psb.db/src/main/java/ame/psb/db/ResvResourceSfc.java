package ame.psb.db;

import java.util.Date;

public class ResvResourceSfc {

  private String id;

  private String resvResourceId;

  private String stateName;

  private String actionName;

  private String actionDesc;

  private String reserveCurrent;

  private String reserveSfcBo;

  private Date reserveTime;

  private String buyOff;

  private String buyOffSfcBo;

  private Date buyOffStartTime;

  private Date buyOffEndTime;

  private String lockSfcBo;

  private String operationBo;

  private String deviceBo;

  private String currSfcBo;

  private String currOperationBo;

  private String currDeviceBo;

  private String inspResourceBo;

  private String inspResult;

  private String inspStateName;


  public ResvResourceSfc() {
  }

  public ResvResourceSfc(ResvResourceSfc data) {
    this.id = data.id;
    this.resvResourceId = data.resvResourceId;
    this.stateName = data.stateName;
    this.actionName = data.actionName;
    this.actionDesc = data.actionDesc;
    this.reserveCurrent = data.reserveCurrent;
    this.reserveSfcBo = data.reserveSfcBo;
    this.reserveTime = data.reserveTime;
    this.buyOff = data.buyOff;
    this.buyOffSfcBo = data.buyOffSfcBo;
    this.buyOffStartTime = data.buyOffStartTime;
    this.buyOffEndTime = data.buyOffEndTime;
    this.lockSfcBo = data.lockSfcBo;
    this.operationBo = data.operationBo;
    this.deviceBo = data.deviceBo;
    this.currSfcBo = data.currSfcBo;
    this.currOperationBo = data.currOperationBo;
    this.currDeviceBo = data.currDeviceBo;
    this.inspResourceBo = data.inspResourceBo;
    this.inspResult = data.inspResult;
    this.inspStateName = data.inspStateName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResvResourceId() {
    return resvResourceId;
  }

  public void setResvResourceId(String resvResourceId) {
    this.resvResourceId = resvResourceId;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getActionDesc() {
    return actionDesc;
  }

  public void setActionDesc(String actionDesc) {
    this.actionDesc = actionDesc;
  }

  public String getReserveCurrent() {
    return reserveCurrent;
  }

  public void setReserveCurrent(String reserveCurrent) {
    this.reserveCurrent = reserveCurrent;
  }

  public String getReserveSfcBo() {
    return reserveSfcBo;
  }

  public void setReserveSfcBo(String reserveSfcBo) {
    this.reserveSfcBo = reserveSfcBo;
  }

  public Date getReserveTime() {
    return reserveTime;
  }

  public void setReserveTime(Date reserveTime) {
    this.reserveTime = reserveTime;
  }

  public String getBuyOff() {
    return buyOff;
  }

  public void setBuyOff(String buyOff) {
    this.buyOff = buyOff;
  }

  public String getBuyOffSfcBo() {
    return buyOffSfcBo;
  }

  public void setBuyOffSfcBo(String buyOffSfcBo) {
    this.buyOffSfcBo = buyOffSfcBo;
  }

  public Date getBuyOffStartTime() {
    return buyOffStartTime;
  }

  public void setBuyOffStartTime(Date buyOffStartTime) {
    this.buyOffStartTime = buyOffStartTime;
  }

  public Date getBuyOffEndTime() {
    return buyOffEndTime;
  }

  public void setBuyOffEndTime(Date buyOffEndTime) {
    this.buyOffEndTime = buyOffEndTime;
  }

  public String getLockSfcBo() {
    return lockSfcBo;
  }

  public void setLockSfcBo(String lockSfcBo) {
    this.lockSfcBo = lockSfcBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getDeviceBo() {
    return deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getCurrSfcBo() {
    return currSfcBo;
  }

  public void setCurrSfcBo(String currSfcBo) {
    this.currSfcBo = currSfcBo;
  }

  public String getCurrOperationBo() {
    return currOperationBo;
  }

  public void setCurrOperationBo(String currOperationBo) {
    this.currOperationBo = currOperationBo;
  }

  public String getCurrDeviceBo() {
    return currDeviceBo;
  }

  public void setCurrDeviceBo(String currDeviceBo) {
    this.currDeviceBo = currDeviceBo;
  }

  public String getInspResourceBo() {
    return inspResourceBo;
  }

  public void setInspResourceBo(String inspResourceBo) {
    this.inspResourceBo = inspResourceBo;
  }

  public String getInspResult() {
    return inspResult;
  }

  public void setInspResult(String inspResult) {
    this.inspResult = inspResult;
  }

  public String getInspStateName() {
    return inspStateName;
  }

  public void setInspStateName(String inspStateName) {
    this.inspStateName = inspStateName;
  }

  @Override
  public ResvResourceSfc clone() {
    return new ResvResourceSfc(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
