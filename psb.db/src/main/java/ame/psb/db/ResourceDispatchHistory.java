package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ResourceDispatchHistory {

  private String resourceName;

  private Date updatedTime;

  private String sfcName;

  private BigDecimal crValue;

  private String priority;

  private String priorityDesc;

  private String sfcStepBo;


  public ResourceDispatchHistory() {
  }

  public ResourceDispatchHistory(ResourceDispatchHistory data) {
    this.resourceName = data.resourceName;
    this.updatedTime = data.updatedTime;
    this.sfcName = data.sfcName;
    this.crValue = data.crValue;
    this.priority = data.priority;
    this.priorityDesc = data.priorityDesc;
    this.sfcStepBo = data.sfcStepBo;
  }

  @Override
  public ResourceDispatchHistory clone() {
    return new ResourceDispatchHistory(this);
  }

  @Override
  public String toString() {
    return this.resourceName + ", " + this.updatedTime + ", " + this.sfcName;
  }

  public String getResourceName() {
    return this.resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getSfcName() {
    return this.sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public BigDecimal getCrValue() {
    return this.crValue;
  }

  public void setCrValue(BigDecimal crValue) {
    this.crValue = crValue;
  }

  public String getPriority() {
    return this.priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public String getPriorityDesc() {
    return this.priorityDesc;
  }

  public void setPriorityDesc(String priorityDesc) {
    this.priorityDesc = priorityDesc;
  }

  public String getSfcStepBo() {
    return this.sfcStepBo;
  }

  public void setSfcStepBo(String sfcStepBo) {
    this.sfcStepBo = sfcStepBo;
  }
}
