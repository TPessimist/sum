package ame.psb.db;

import java.util.Date;

public class ViewPmsPlan {

  private String handle;

  private String resrce;

  private String site;

  private String resourceType;

  private String enabled;

  private String checkList;

  private String revision;

  private String checkType;

  private String periodValue;

  private String periodUnit;

  private String jobId;

  private String jobStatus;

  private Date createdDateTime;

  private Date startDateTime;

  private Date completeDateTime;

  private Date nextExecuTime;

  public ViewPmsPlan() {
  }

  public ViewPmsPlan(ViewPmsPlan data) {
    this.handle = data.handle;
    this.resrce = data.resrce;
    this.site = data.site;
    this.resourceType = data.resourceType;
    this.enabled = data.enabled;
    this.checkList = data.checkList;
    this.revision = data.revision;
    this.checkType = data.checkType;
    this.periodValue = data.periodValue;
    this.periodUnit = data.periodUnit;
    this.jobId = data.jobId;
    this.jobStatus = data.jobStatus;
    this.createdDateTime = data.createdDateTime;
    this.startDateTime = data.startDateTime;
    this.completeDateTime = data.completeDateTime;
    this.nextExecuTime = data.nextExecuTime;
  }

  @Override
  public ViewPmsPlan clone() {
    return new ViewPmsPlan(this);
  }

  @Override
  public String toString() {
    return this.resrce;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getResrce() {
    return resrce;
  }

  public void setResrce(String resrce) {
    this.resrce = resrce;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public String getEnabled() {
    return enabled;
  }

  public void setEnabled(String enabled) {
    this.enabled = enabled;
  }

  public String getCheckList() {
    return checkList;
  }

  public void setCheckList(String checkList) {
    this.checkList = checkList;
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

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public String getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(String jobStatus) {
    this.jobStatus = jobStatus;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Date getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(Date startDateTime) {
    this.startDateTime = startDateTime;
  }

  public Date getCompleteDateTime() {
    return completeDateTime;
  }

  public void setCompleteDateTime(Date completeDateTime) {
    this.completeDateTime = completeDateTime;
  }

  public Date getNextExecuTime() {
    return nextExecuTime;
  }

  public void setNextExecuTime(Date nextExecuTime) {
    this.nextExecuTime = nextExecuTime;
  }
}
