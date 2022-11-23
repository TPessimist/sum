package ame.psb.db;

import java.util.Date;

public class BadSupplementCheck {

  private String waferBo;

  private String operation;

  private String checkSum;

  private String reason;

  private String description;

  private String updatedUser;

  private Date updatedTime;


  public BadSupplementCheck() {
  }

  public BadSupplementCheck(BadSupplementCheck data) {
    this.waferBo = data.waferBo;
    this.operation = data.operation;
    this.checkSum = data.checkSum;
    this.reason = data.reason;
    this.description = data.description;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public BadSupplementCheck clone() {
    return new BadSupplementCheck(this);
  }

  @Override
  public String toString() {
    return this.waferBo + ", " + this.operation;
  }

  public String getWaferBo() {
    return waferBo;
  }

  public void setWaferBo(String waferBo) {
    this.waferBo = waferBo;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getCheckSum() {
    return checkSum;
  }

  public void setCheckSum(String checkSum) {
    this.checkSum = checkSum;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
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
