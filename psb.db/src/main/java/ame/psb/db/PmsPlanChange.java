package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class PmsPlanChange {

  private String id;

  private String resourceType;

  private String checkList;

  private String checkListVersion;

  private String checkListType;

  private String planningCycle;

  private String cycleUnit;

  private Date delayTime;

  private String remark;

  private String status;

  private String updateUser;

  private Date updateTime;

  private String site;

  private String resrce;


  public PmsPlanChange() {
    this.id = UUID.randomUUID().toString();
  }

  public PmsPlanChange(PmsPlanChange data) {
    this.id = data.id;
    this.resrce = data.resrce;
    this.resourceType = data.resourceType;
    this.checkList = data.checkList;
    this.checkListVersion = data.checkListVersion;
    this.checkListType = data.checkListType;
    this.planningCycle = data.planningCycle;
    this.cycleUnit = data.cycleUnit;
    this.delayTime = data.delayTime;
    this.remark = data.remark;
    this.status = data.status;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.site = data.site;
  }

  @Override
  public PmsPlanChange clone() {
    return new PmsPlanChange(this);
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

  public String getResrce() {
    return resrce;
  }

  public void setResrce(String resrce) {
    this.resrce = resrce;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public String getCheckList() {
    return checkList;
  }

  public void setCheckList(String checkList) {
    this.checkList = checkList;
  }

  public String getCheckListVersion() {
    return checkListVersion;
  }

  public void setCheckListVersion(String checkListVersion) {
    this.checkListVersion = checkListVersion;
  }

  public String getCheckListType() {
    return checkListType;
  }

  public void setCheckListType(String checkListType) {
    this.checkListType = checkListType;
  }

  public String getPlanningCycle() {
    return planningCycle;
  }

  public void setPlanningCycle(String planningCycle) {
    this.planningCycle = planningCycle;
  }

  public String getCycleUnit() {
    return cycleUnit;
  }

  public void setCycleUnit(String cycleUnit) {
    this.cycleUnit = cycleUnit;
  }

  public Date getDelayTime() {
    return delayTime;
  }

  public void setDelayTime(Date delayTime) {
    this.delayTime = delayTime;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

}
