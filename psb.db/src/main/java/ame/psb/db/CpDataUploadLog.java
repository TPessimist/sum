package ame.psb.db;

import java.util.Date;

public class CpDataUploadLog {

  private String customer;

  private String fileName;

  private String updatedUser;

  private Date updatedTime;

  private boolean mailRemindFlag;

  public CpDataUploadLog() {
  }

  public CpDataUploadLog(CpDataUploadLog data) {
    this.customer = data.customer;
    this.fileName = data.fileName;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.mailRemindFlag = data.mailRemindFlag;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
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

  public boolean isMailRemindFlag() {
    return mailRemindFlag;
  }

  public void setMailRemindFlag(boolean mailRemindFlag) {
    this.mailRemindFlag = mailRemindFlag;
  }

  @Override
  public CpDataUploadLog clone() {
    return new CpDataUploadLog(this);
  }

  @Override
  public String toString() {
    return this.customer;
  }
}
