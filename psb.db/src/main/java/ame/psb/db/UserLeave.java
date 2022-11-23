package ame.psb.db;

import java.util.Date;

public class UserLeave {

  private String id;

  private String opUser;

  private String leaderUser;

  private String department;

  private String area;

  private String reason;

  private Date leaveTime;

  private Date backTime;

  private String flag;

  private String value;

  private String content;

  public UserLeave() {
  }

  public UserLeave(UserLeave data) {
    this.id = data.id;
    this.opUser = data.opUser;
    this.leaderUser = data.leaderUser;
    this.department = data.department;
    this.area = data.area;
    this.reason = data.reason;
    this.leaveTime = data.leaveTime;
    this.backTime = data.backTime;
    this.flag = data.flag;
    this.value = data.value;
    this.content = data.content;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOpUser() {
    return opUser;
  }

  public void setOpUser(String opUser) {
    this.opUser = opUser;
  }

  public String getLeaderUser() {
    return leaderUser;
  }

  public void setLeaderUser(String leaderUser) {
    this.leaderUser = leaderUser;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Date getLeaveTime() {
    return leaveTime;
  }

  public void setLeaveTime(Date leaveTime) {
    this.leaveTime = leaveTime;
  }

  public Date getBackTime() {
    return backTime;
  }

  public void setBackTime(Date backTime) {
    this.backTime = backTime;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public UserLeave clone() {
    return new UserLeave(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
