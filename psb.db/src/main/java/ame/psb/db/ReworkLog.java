package ame.psb.db;

import java.util.Date;

public class ReworkLog {

  private String reworkItem;

  private String reworkDepend;

  private String reworkRuleContent;

  private String updatedUser;

  private Date updatedTime;


  public ReworkLog() {
  }

  public ReworkLog(ReworkLog data) {
    this.reworkItem = data.reworkItem;
    this.reworkDepend = data.reworkDepend;
    this.reworkRuleContent = data.reworkRuleContent;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }


  public String getReworkItem() {
    return reworkItem;
  }

  public void setReworkItem(String reworkItem) {
    this.reworkItem = reworkItem;
  }

  public String getReworkDepend() {
    return reworkDepend;
  }

  public void setReworkDepend(String reworkDepend) {
    this.reworkDepend = reworkDepend;
  }

  public String getReworkRuleContent() {
    return reworkRuleContent;
  }

  public void setReworkRuleContent(String reworkRuleContent) {
    this.reworkRuleContent = reworkRuleContent;
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

  @Override
  public ReworkLog clone() {
    return new ReworkLog(this);
  }

  @Override
  public String toString() {
    return this.reworkItem;
  }
}
