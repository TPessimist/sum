package ame.psb.db;

import java.util.Date;

public class FailLog {

  private String id;

  private String action;

  private String dataLog;

  private String messageLog;

  private String contentLog;

  private String logUser;

  private Date logTime;


  public FailLog() {
  }

  public FailLog(FailLog data) {
    this.id = data.id;
    this.action = data.action;
    this.dataLog = data.dataLog;
    this.messageLog = data.messageLog;
    this.contentLog = data.contentLog;
    this.logUser = data.logUser;
    this.logTime = data.logTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getDataLog() {
    return dataLog;
  }

  public void setDataLog(String dataLog) {
    this.dataLog = dataLog;
  }

  public String getMessageLog() {
    return messageLog;
  }

  public void setMessageLog(String messageLog) {
    this.messageLog = messageLog;
  }

  public String getContentLog() {
    return contentLog;
  }

  public void setContentLog(String contentLog) {
    this.contentLog = contentLog;
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

  @Override
  public FailLog clone() {
    return new FailLog(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
