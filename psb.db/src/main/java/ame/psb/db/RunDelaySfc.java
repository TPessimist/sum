package ame.psb.db;

import java.util.Date;

public class RunDelaySfc {

  private String sfcBo;

  private String operationBo;

  private int delayCount;

  private String stateName;

  private String resourceBo;

  private String updatedUser;

  private Date createdTime;

  private Date disableTime;

  private Date moveInTime;

  private String comment;


  public RunDelaySfc() {
  }

  public RunDelaySfc(RunDelaySfc data) {
    this.sfcBo = data.sfcBo;
    this.operationBo = data.operationBo;
    this.delayCount = data.delayCount;
    this.stateName = data.stateName;
    this.resourceBo = data.resourceBo;
    this.updatedUser = data.updatedUser;
    this.createdTime = data.createdTime;
    this.disableTime = data.disableTime;
    this.moveInTime = data.moveInTime;
  }

  @Override
  public RunDelaySfc clone() {
    return new RunDelaySfc(this);
  }

  @Override
  public String toString() {
    return this.sfcBo + ", " + this.operationBo;
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

  public int getDelayCount() {
    return this.delayCount;
  }

  public void setDelayCount(int delayCount) {
    this.delayCount = delayCount;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getDisableTime() {
    return this.disableTime;
  }

  public void setDisableTime(Date disableTime) {
    this.disableTime = disableTime;
  }

  public Date getMoveInTime() {
    return this.moveInTime;
  }

  public void setMoveInTime(Date moveInTime) {
    this.moveInTime = moveInTime;
  }

  public String getComment() {
    return this.comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public boolean isEnabled() {
    return "Y".equals(this.stateName);
  }
}
