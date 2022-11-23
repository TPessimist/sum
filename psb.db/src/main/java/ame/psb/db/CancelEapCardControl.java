package ame.psb.db;

import java.util.Date;

public class CancelEapCardControl {

  private String sfcBo;

  private String sfc;

  private String operationBo;

  private String reason;

  private String other;

  private String updateUser;

  private Date updateTime;


  public CancelEapCardControl() {
  }

  public CancelEapCardControl(CancelEapCardControl data) {
    this.sfcBo = data.sfcBo;
    this.sfc = data.sfc;
    this.operationBo = data.operationBo;
    this.reason = data.reason;
    this.other = data.other;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  @Override
  public CancelEapCardControl clone() {
    return new CancelEapCardControl(this);
  }

  @Override
  public String toString() {
    return this.sfcBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getOther() {
    return other;
  }

  public void setOther(String other) {
    this.other = other;
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
}
