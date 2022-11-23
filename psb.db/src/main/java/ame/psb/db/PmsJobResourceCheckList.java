package ame.psb.db;

import java.util.Date;

public class PmsJobResourceCheckList {

  private String jobBo;

  private String checkType;

  private String jobId;

  private String jobStatus;

  private Date createdDateTime;

  private Date completeDateTime;

  private String resourceBo;

  private String resrce;

  private String resourceType;

  private String checklist;


  public PmsJobResourceCheckList() {
  }

  public PmsJobResourceCheckList(PmsJobResourceCheckList data) {
    this.jobBo = data.jobBo;
    this.checkType = data.checkType;
    this.jobId = data.jobId;
    this.jobStatus = data.jobStatus;
    this.createdDateTime = data.createdDateTime;
    this.completeDateTime = data.completeDateTime;
    this.resourceBo = data.resourceBo;
    this.resrce = data.resrce;
    this.resourceType = data.resourceType;
    this.checklist = data.checklist;
  }

  @Override
  public PmsJobResourceCheckList clone() {
    return new PmsJobResourceCheckList(this);
  }

  @Override
  public String toString() {
    return this.jobBo;
  }

  public String getJobBo() {
    return jobBo;
  }

  public void setJobBo(String jobBo) {
    this.jobBo = jobBo;
  }

  public String getCheckType() {
    return checkType;
  }

  public void setCheckType(String checkType) {
    this.checkType = checkType;
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

  public Date getCompleteDateTime() {
    return completeDateTime;
  }

  public void setCompleteDateTime(Date completeDateTime) {
    this.completeDateTime = completeDateTime;
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

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public String getChecklist() {
    return checklist;
  }

  public void setChecklist(String checklist) {
    this.checklist = checklist;
  }


}