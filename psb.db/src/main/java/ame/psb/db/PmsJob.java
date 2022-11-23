package ame.psb.db;

import java.util.Date;

public class PmsJob {

  private String handle;

  private String site;

  private String checkType;

  private String jobId;

  private String jobDesc;

  private String jobStatus;

  private String remark;

  private String createUser;

  private Date createdDateTime;

  private String modifyUser;

  private Date modifiedDateTime;

  private String startUser;

  private Date startDateTime;

  private String completeUser;

  private Date completeDateTime;

  private String submitUser;

  private Date submitReviewDateTime;

  private String reviewUser;

  private Date completeReviewDateTime;

  private String cancelUser;

  private Date cancelDateTime;

  private String createMethod;

  private String periodUnit;

  private int pad_upload_num;

  public PmsJob() {
  }

  public PmsJob(PmsJob data) {
    this.handle = data.handle;
    this.site = data.site;
    this.checkType = data.checkType;
    this.jobId = data.jobId;
    this.jobDesc = data.jobDesc;
    this.jobStatus = data.jobStatus;
    this.remark = data.remark;
    this.createUser = data.createUser;
    this.createdDateTime = data.createdDateTime;
    this.modifyUser = data.modifyUser;
    this.modifiedDateTime = data.modifiedDateTime;
    this.startUser = data.startUser;
    this.startDateTime = data.startDateTime;
    this.completeUser = data.completeUser;
    this.completeDateTime = data.completeDateTime;
    this.submitUser = data.submitUser;
    this.submitReviewDateTime = data.submitReviewDateTime;
    this.reviewUser = data.reviewUser;
    this.completeReviewDateTime = data.completeReviewDateTime;
    this.cancelUser = data.cancelUser;
    this.cancelDateTime = data.cancelDateTime;
    this.createMethod = data.createMethod;
    this.periodUnit = data.periodUnit;
    this.pad_upload_num = data.pad_upload_num;
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

  public String getJobDesc() {
    return jobDesc;
  }

  public void setJobDesc(String jobDesc) {
    this.jobDesc = jobDesc;
  }

  public String getJobStatus() {
    return jobStatus;
  }

  public void setJobStatus(String jobStatus) {
    this.jobStatus = jobStatus;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
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

  public String getStartUser() {
    return startUser;
  }

  public void setStartUser(String startUser) {
    this.startUser = startUser;
  }

  public Date getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(Date startDateTime) {
    this.startDateTime = startDateTime;
  }

  public String getCompleteUser() {
    return completeUser;
  }

  public void setCompleteUser(String completeUser) {
    this.completeUser = completeUser;
  }

  public Date getCompleteDateTime() {
    return completeDateTime;
  }

  public void setCompleteDateTime(Date completeDateTime) {
    this.completeDateTime = completeDateTime;
  }

  public String getSubmitUser() {
    return submitUser;
  }

  public void setSubmitUser(String submitUser) {
    this.submitUser = submitUser;
  }

  public Date getSubmitReviewDateTime() {
    return submitReviewDateTime;
  }

  public void setSubmitReviewDateTime(Date submitReviewDateTime) {
    this.submitReviewDateTime = submitReviewDateTime;
  }

  public String getReviewUser() {
    return reviewUser;
  }

  public void setReviewUser(String reviewUser) {
    this.reviewUser = reviewUser;
  }

  public Date getCompleteReviewDateTime() {
    return completeReviewDateTime;
  }

  public void setCompleteReviewDateTime(Date completeReviewDateTime) {
    this.completeReviewDateTime = completeReviewDateTime;
  }

  public String getCancelUser() {
    return cancelUser;
  }

  public void setCancelUser(String cancelUser) {
    this.cancelUser = cancelUser;
  }

  public Date getCancelDateTime() {
    return cancelDateTime;
  }

  public void setCancelDateTime(Date cancelDateTime) {
    this.cancelDateTime = cancelDateTime;
  }

  public String getCreateMethod() {
    return createMethod;
  }

  public void setCreateMethod(String createMethod) {
    this.createMethod = createMethod;
  }

  public String getPeriodUnit() {
    return periodUnit;
  }

  public void setPeriodUnit(String periodUnit) {
    this.periodUnit = periodUnit;
  }

  public int getPad_upload_num() {
    return pad_upload_num;
  }

  public void setPad_upload_num(int pad_upload_num) {
    this.pad_upload_num = pad_upload_num;
  }

  @Override
  public PmsJob clone() {
    return new PmsJob(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}