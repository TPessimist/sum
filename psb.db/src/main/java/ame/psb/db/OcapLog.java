package ame.psb.db;

import java.util.Date;

public class OcapLog {

  private String oaId;

  private String actionName;

  private String content;

  private String operationBo;

  private String operation;

  private String logUser;

  private Date logTime;

  private String status;

  private String message;


  public OcapLog() {
  }

  public OcapLog(OcapLog data) {
    this.oaId = data.oaId;
    this.actionName = data.actionName;
    this.content = data.content;
    this.operationBo = data.operationBo;
    this.operation = data.operation;
    this.logUser = data.logUser;
    this.logTime = data.logTime;
    this.status = data.status;
    this.message = data.message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getOaId() {
    return oaId;
  }

  public void setOaId(String oaId) {
    this.oaId = oaId;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
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
  public OcapLog clone() {
    return new OcapLog(this);
  }

  @Override
  public String toString() {
    return this.oaId;
  }
}
