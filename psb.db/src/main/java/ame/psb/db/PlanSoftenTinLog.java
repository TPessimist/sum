package ame.psb.db;

import java.util.Date;

public class PlanSoftenTinLog {

  private String id;

  private String name;

  private String content;

  private String logUser;

  private Date logTime;

  private String reversed1;

  private String reversed2;

  private String reversed3;


  public PlanSoftenTinLog() {
  }

  public PlanSoftenTinLog(PlanSoftenTinLog data) {
    this.id = data.id;
    this.name = data.name;
    this.content = data.content;
    this.logUser = data.logUser;
    this.logTime = data.logTime;
    this.reversed1 = data.reversed1;
    this.reversed2 = data.reversed2;
    this.reversed3 = data.reversed3;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getLogUser() {
    return logUser;
  }

  public void setLogUser(String logUser) {
    this.logUser = logUser;
  }

  public Date getLogTime() {
    return logTime;
  }

  public void setLogTime(Date logTime) {
    this.logTime = logTime;
  }

  public String getReversed1() {
    return reversed1;
  }

  public void setReversed1(String reversed1) {
    this.reversed1 = reversed1;
  }

  public String getReversed2() {
    return reversed2;
  }

  public void setReversed2(String reversed2) {
    this.reversed2 = reversed2;
  }

  public String getReversed3() {
    return reversed3;
  }

  public void setReversed3(String reversed3) {
    this.reversed3 = reversed3;
  }

  @Override
  public PlanSoftenTinLog clone() {
    return new PlanSoftenTinLog(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
