package ame.psb.db;

import java.util.Date;

public class FcAutoDeduction {

  private String sfcBo; //生产批号

  private String stateName; //状态:WAIT  DONE  FIAL

  private String message; //信息

  private String description;

  private String remarks;

  private String note;

  private String updatedUser; //人员

  private Date updatedTime; //时间


  public FcAutoDeduction() {
  }

  public FcAutoDeduction(FcAutoDeduction data) {
    this.sfcBo = data.sfcBo;
    this.stateName = data.stateName;
    this.message = data.message;
    this.description = data.description;
    this.remarks = data.remarks;
    this.note = data.note;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public FcAutoDeduction clone() {
    return new FcAutoDeduction(this);
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

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
