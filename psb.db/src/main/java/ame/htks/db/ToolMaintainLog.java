package ame.htks.db;

import java.util.Date;

public class ToolMaintainLog {

  private String uuid;

  private String toolNumberBo;

  private String currentStatus;

  private String lastUpdateFlag;

  private String comments;

  private String updateUsr;

  private Date updateTime;


  public ToolMaintainLog() {
  }

  public ToolMaintainLog(ToolMaintainLog data) {
    this.uuid = data.uuid;
    this.toolNumberBo = data.toolNumberBo;
    this.currentStatus = data.currentStatus;
    this.lastUpdateFlag = data.lastUpdateFlag;
    this.comments = data.comments;
    this.updateUsr = data.updateUsr;
    this.updateTime = data.updateTime;
  }

  @Override
  public ToolMaintainLog clone() {
    return new ToolMaintainLog(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getToolNumberBo() {
    return toolNumberBo;
  }

  public void setToolNumberBo(String toolNumberBo) {
    this.toolNumberBo = toolNumberBo;
  }

  public String getCurrentStatus() {
    return currentStatus;
  }

  public void setCurrentStatus(String currentStatus) {
    this.currentStatus = currentStatus;
  }

  public String getLastUpdateFlag() {
    return lastUpdateFlag;
  }

  public void setLastUpdateFlag(String lastUpdateFlag) {
    this.lastUpdateFlag = lastUpdateFlag;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getUpdateUsr() {
    return updateUsr;
  }

  public void setUpdateUsr(String updateUsr) {
    this.updateUsr = updateUsr;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }


}
