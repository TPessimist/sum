package ame.psb.db;

import java.util.Date;

public class ConfigLog extends AbstractLoggable {

  private String batchId;

  private String tableName;

  private String content;

  private String logUser;

  private Date logTime;


  public ConfigLog() {
  }

  public ConfigLog(ConfigLog data) {
    this.batchId = data.batchId;
    this.tableName = data.tableName;
    this.content = data.content;
    this.logUser = data.logUser;
    this.logTime = data.logTime;
  }

  public ConfigLog(String batchId, String tableName, String logUser, Date logTime, String content) {
    this.batchId = batchId;
    this.tableName = tableName;
    this.content = content;
    this.logUser = logUser;
    this.logTime = logTime;
  }

  @Override
  public ConfigLog clone() {
    return new ConfigLog(this);
  }

  @Override
  public String toString() {
    return this.batchId;
  }

  @Override
  public String getBatchId() {
    return batchId;
  }

  @Override
  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  @Override
  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  @Override
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String getLogUser() {
    return logUser;
  }

  public void setLogUser(String logUser) {
    this.logUser = logUser;
  }

  @Override
  public Date getLogDateTime() {
    return logTime;
  }

  public void setLogTime(Date logTime) {
    this.logTime = logTime;
  }
}