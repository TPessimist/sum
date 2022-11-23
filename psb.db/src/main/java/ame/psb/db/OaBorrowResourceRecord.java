package ame.psb.db;

import java.util.Date;

public class OaBorrowResourceRecord {

  private String id;

  private String requestId;

  private String resourceBo;

  private String applicant;

  private String pmcUser;

  private Date expectBeginTime;

  private Date expectEndTime;

  private String stateName;

  private Date actualBeginTime;

  private Date actualEndTime;

  private String borrowType;

  private String comment;

  private String note;

  private String description;

  private String updatedUser;

  private Date updatedTime;


  public OaBorrowResourceRecord() {
  }

  public OaBorrowResourceRecord(OaBorrowResourceRecord data) {
    this.id = data.id;
    this.requestId = data.requestId;
    this.resourceBo = data.resourceBo;
    this.applicant = data.applicant;
    this.pmcUser = data.pmcUser;
    this.expectBeginTime = data.expectBeginTime;
    this.expectEndTime = data.expectEndTime;
    this.stateName = data.stateName;
    this.actualBeginTime = data.actualBeginTime;
    this.actualEndTime = data.actualEndTime;
    this.borrowType = data.borrowType;
    this.comment = data.comment;
    this.note = data.note;
    this.description = data.description;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public OaBorrowResourceRecord clone() {
    return new OaBorrowResourceRecord(this);
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

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getApplicant() {
    return applicant;
  }

  public void setApplicant(String applicant) {
    this.applicant = applicant;
  }

  public String getPmcUser() {
    return pmcUser;
  }

  public void setPmcUser(String pmcUser) {
    this.pmcUser = pmcUser;
  }

  public Date getExpectBeginTime() {
    return expectBeginTime;
  }

  public void setExpectBeginTime(Date expectBeginTime) {
    this.expectBeginTime = expectBeginTime;
  }

  public Date getExpectEndTime() {
    return expectEndTime;
  }

  public void setExpectEndTime(Date expectEndTime) {
    this.expectEndTime = expectEndTime;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public Date getActualBeginTime() {
    return actualBeginTime;
  }

  public void setActualBeginTime(Date actualBeginTime) {
    this.actualBeginTime = actualBeginTime;
  }

  public Date getActualEndTime() {
    return actualEndTime;
  }

  public void setActualEndTime(Date actualEndTime) {
    this.actualEndTime = actualEndTime;
  }

  public String getBorrowType() {
    return borrowType;
  }

  public void setBorrowType(String borrowType) {
    this.borrowType = borrowType;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
