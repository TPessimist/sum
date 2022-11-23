package ame.psb.db;

import java.util.Date;

public class HoldBonedSfc {

  private String holdHandle;

  private String sfcBo;

  private String operationBo;

  private String holdCode;

  private String holdComment;

  private Date updatedTime;


  public HoldBonedSfc() {
  }

  public HoldBonedSfc(HoldBonedSfc data) {
    this.holdHandle = data.holdHandle;
    this.sfcBo = data.sfcBo;
    this.operationBo = data.operationBo;
    this.holdCode = data.holdCode;
    this.holdComment = data.holdComment;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public HoldBonedSfc clone() {
    return new HoldBonedSfc(this);
  }

  @Override
  public String toString() {
    return this.holdHandle;
  }

  public String getHoldHandle() {
    return holdHandle;
  }

  public void setHoldHandle(String holdHandle) {
    this.holdHandle = holdHandle;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getHoldCode() {
    return holdCode;
  }

  public void setHoldCode(String holdCode) {
    this.holdCode = holdCode;
  }

  public String getHoldComment() {
    return holdComment;
  }

  public void setHoldComment(String holdComment) {
    this.holdComment = holdComment;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
