package ame.psb.db;

import java.util.Date;

public class PmsPlan {

  private String handle;

  private String site;

  private String resourceBo;

  private String resrce;

  private String enabled;

  private String checklist;

  private String revision;

  private String checkType;

  private String periodValue;

  private String periodUnit;

  private Date nextExecuTime;

  private String baseCompleted;

  private String isWarning;

  private String createUser;

  private Date createdDateTime;

  private String modifyUser;

  private Date modifiedDateTime;

  private String resourceType;

  private String toleranceTime;

  private String toleranceUnit;


  public PmsPlan() {
  }

  public PmsPlan(PmsPlan data) {
    this.handle = data.handle;
    this.site = data.site;
    this.resourceBo = data.resourceBo;
    this.resrce = data.resrce;
    this.enabled = data.enabled;
    this.checklist = data.checklist;
    this.revision = data.revision;
    this.checkType = data.checkType;
    this.periodValue = data.periodValue;
    this.periodUnit = data.periodUnit;
    this.nextExecuTime = data.nextExecuTime;
    this.baseCompleted = data.baseCompleted;
    this.isWarning = data.isWarning;
    this.createUser = data.createUser;
    this.createdDateTime = data.createdDateTime;
    this.modifyUser = data.modifyUser;
    this.modifiedDateTime = data.modifiedDateTime;
    this.resourceType = data.resourceType;
    this.toleranceTime = data.toleranceTime;
    this.toleranceUnit = data.toleranceUnit;
  }

  @Override
  public PmsPlan clone() {
    return new PmsPlan(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getResrce() {
    return resrce;
  }

  public void setResrce(String resrce) {
    this.resrce = resrce;
  }

  public String getEnabled() {
    return enabled;
  }

  public void setEnabled(String enabled) {
    this.enabled = enabled;
  }

  public String getChecklist() {
    return checklist;
  }

  public void setChecklist(String checklist) {
    this.checklist = checklist;
  }

  public String getRevision() {
    return revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public String getCheckType() {
    return checkType;
  }

  public void setCheckType(String checkType) {
    this.checkType = checkType;
  }

  public String getPeriodValue() {
    return periodValue;
  }

  public void setPeriodValue(String periodValue) {
    this.periodValue = periodValue;
  }

  public String getPeriodUnit() {
    return periodUnit;
  }

  public void setPeriodUnit(String periodUnit) {
    this.periodUnit = periodUnit;
  }

  public Date getNextExecuTime() {
    return nextExecuTime;
  }

  public void setNextExecuTime(Date nextExecuTime) {
    this.nextExecuTime = nextExecuTime;
  }

  public String getBaseCompleted() {
    return baseCompleted;
  }

  public void setBaseCompleted(String baseCompleted) {
    this.baseCompleted = baseCompleted;
  }

  public String getIsWarning() {
    return isWarning;
  }

  public void setIsWarning(String isWarning) {
    this.isWarning = isWarning;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public String getModifyUser() {
    return modifyUser;
  }

  public void setModifyUser(String modifyUser) {
    this.modifyUser = modifyUser;
  }

  public Date getModifiedDateTime() {
    return modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public String getToleranceTime() {
    return toleranceTime;
  }

  public void setToleranceTime(String toleranceTime) {
    this.toleranceTime = toleranceTime;
  }

  public String getToleranceUnit() {
    return toleranceUnit;
  }

  public void setToleranceUnit(String toleranceUnit) {
    this.toleranceUnit = toleranceUnit;
  }


}
