package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class SfcNotify {

  private String id;

  private String sfcBo;

  private String operationBo;

  private String holdCode;

  private String holdComment;

  private String stateName;

  private String notifyUser;

  private String notifyComment;

  private Date notifyTime;

  private String notifiedUser;

  private Date notifiedTime;

  private String notifiedComment;

  private Date createdTime;

  private String createdUser;

  private Date moveInTime;

  private String moveInUser;


  public SfcNotify() {
    this.id = UUID.randomUUID().toString();
  }

  public SfcNotify(SfcNotify data) {
    this.id = data.id;
    this.sfcBo = data.sfcBo;
    this.operationBo = data.operationBo;
    this.holdCode = data.holdCode;
    this.holdComment = data.holdComment;
    this.stateName = data.stateName;
    this.notifyUser = data.notifyUser;
    this.notifyComment = data.notifyComment;
    this.notifyTime = data.notifyTime;
    this.notifiedUser = data.notifiedUser;
    this.notifiedTime = data.notifiedTime;
    this.notifiedComment = data.notifiedComment;
    this.createdTime = data.createdTime;
    this.createdUser = data.createdUser;
    this.moveInTime = data.moveInTime;
    this.moveInUser = data.moveInUser;
  }

  @Override
  public SfcNotify clone() {
    return new SfcNotify(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getHoldCode() {
    return this.holdCode;
  }

  public void setHoldCode(String holdCode) {
    this.holdCode = holdCode;
  }

  public String getHoldComment() {
    return this.holdComment;
  }

  public void setHoldComment(String holdComment) {
    this.holdComment = holdComment;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getNotifyUser() {
    return this.notifyUser;
  }

  public void setNotifyUser(String notifyUser) {
    this.notifyUser = notifyUser;
  }

  public String getNotifyComment() {
    return this.notifyComment;
  }

  public void setNotifyComment(String notifyComment) {
    this.notifyComment = notifyComment;
  }

  public Date getNotifyTime() {
    return this.notifyTime;
  }

  public void setNotifyTime(Date notifyTime) {
    this.notifyTime = notifyTime;
  }

  public String getNotifiedUser() {
    return this.notifiedUser;
  }

  public void setNotifiedUser(String notifiedUser) {
    this.notifiedUser = notifiedUser;
  }

  public Date getNotifiedTime() {
    return this.notifiedTime;
  }

  public void setNotifiedTime(Date notifiedTime) {
    this.notifiedTime = notifiedTime;
  }

  public String getNotifiedComment() {
    return this.notifiedComment;
  }

  public void setNotifiedComment(String notifiedComment) {
    this.notifiedComment = notifiedComment;
  }

  public Date getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public String getCreatedUser() {
    return this.createdUser;
  }

  public void setCreatedUser(String createdUser) {
    this.createdUser = createdUser;
  }

  public Date getMoveInTime() {
    return this.moveInTime;
  }

  public void setMoveInTime(Date moveInTime) {
    this.moveInTime = moveInTime;
  }

  public String getMoveInUser() {
    return this.moveInUser;
  }

  public void setMoveInUser(String moveInUser) {
    this.moveInUser = moveInUser;
  }
}
