package ame.psb.db;

import java.util.Date;

public class RunPmsJob {

  private String jobId;

  private String checklist;

  private String checkType;

  private String resourceBo;

  private String jobDesc;

  private String jobStatus;

  private String remark;

  private String createUser;

  private Date createdDateTime;

  private String modifyUser;

  private Date modifiedDateTime;

  private String completeUser;

  private Date completeDateTime;


  public RunPmsJob() {
  }

  public RunPmsJob(RunPmsJob data) {
    this.jobId = data.jobId;
    this.checklist = data.checklist;
    this.checkType = data.checkType;
    this.resourceBo = data.resourceBo;
    this.jobDesc = data.jobDesc;
    this.jobStatus = data.jobStatus;
    this.remark = data.remark;
    this.createUser = data.createUser;
    this.createdDateTime = data.createdDateTime;
    this.modifyUser = data.modifyUser;
    this.modifiedDateTime = data.modifiedDateTime;
    this.completeUser = data.completeUser;
    this.completeDateTime = data.completeDateTime;
  }

  @Override
  public RunPmsJob clone() {
    return new RunPmsJob(this);
  }

  @Override
  public String toString() {
    return this.jobId;
  }

  public String getJobId() {
    return this.jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public String getChecklist() {
    return this.checklist;
  }

  public void setChecklist(String checklist) {
    this.checklist = checklist;
  }

  public String getCheckType() {
    return this.checkType;
  }

  public void setCheckType(String checkType) {
    this.checkType = checkType;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getJobDesc() {
    return this.jobDesc;
  }

  public void setJobDesc(String jobDesc) {
    this.jobDesc = jobDesc;
  }

  public String getJobStatus() {
    return this.jobStatus;
  }

  public void setJobStatus(String jobStatus) {
    this.jobStatus = jobStatus;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getCreateUser() {
    return this.createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getCreatedDateTime() {
    return this.createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public String getModifyUser() {
    return this.modifyUser;
  }

  public void setModifyUser(String modifyUser) {
    this.modifyUser = modifyUser;
  }

  public Date getModifiedDateTime() {
    return this.modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public String getCompleteUser() {
    return this.completeUser;
  }

  public void setCompleteUser(String completeUser) {
    this.completeUser = completeUser;
  }

  public Date getCompleteDateTime() {
    return this.completeDateTime;
  }

  public void setCompleteDateTime(Date completeDateTime) {
    this.completeDateTime = completeDateTime;
  }
}
