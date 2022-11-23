package ame.psb.db;

import java.util.Date;

public class BaddiePackingPass { //

  private String operation; //站点

  private String customerId; //客户

  private String code; //状态码

  private String updateUser; //更新人员

  private Date updateTime; //更新时间

  private String comment; //备用列1

  private String description; //备用列2

  private String message; //备用列3


  public BaddiePackingPass() {
  }

  public BaddiePackingPass(BaddiePackingPass data) {
    this.operation = data.operation;
    this.customerId = data.customerId;
    this.code = data.code;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.comment = data.comment;
    this.description = data.description;
    this.message = data.message;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
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

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public BaddiePackingPass clone() {
    return new BaddiePackingPass(this);
  }

  @Override
  public String toString() {
    return this.operation + ", " + this.customerId;
  }
}
