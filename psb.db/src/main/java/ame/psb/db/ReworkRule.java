package ame.psb.db;

import java.util.Date;

public class ReworkRule {

  private String reworkItem;

  private String reworkDepend;

  private String comment;

  private String reworktype;

  private String updatedUser;

  private Date updatedTime;

  private String state;

  private String reworkRule;


  public ReworkRule() {
  }

  public ReworkRule(ReworkRule data) {
    this.reworkItem = data.reworkItem;
    this.reworkDepend = data.reworkDepend;
    this.comment = data.comment;
    this.reworktype = data.reworktype;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.state = data.state;
    this.reworkRule = data.reworkRule;
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

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getReworktype() {
    return reworktype;
  }

  public void setReworktype(String reworktype) {
    this.reworktype = reworktype;
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

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getReworkRule() {
    return reworkRule;
  }

  public void setReworkRule(String reworkRule) {
    this.reworkRule = reworkRule;
  }

  @Override
  public ReworkRule clone() {
    return new ReworkRule(this);
  }

  @Override
  public String toString() {
    return this.reworkItem + ", " + this.reworkDepend;
  }
}
