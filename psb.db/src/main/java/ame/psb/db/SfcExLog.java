package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class SfcExLog extends SfcEx {

  private String id;

  private String actionName;

  private String runUser;

  private Date runTime;

  public SfcExLog() {
  }

  public SfcExLog(SfcEx data, String actionName) {
    super(data);
    this.id = UUID.randomUUID().toString();
    this.setActionName(actionName);
    this.setRunUser(data.getCreatedUser());
    this.runTime = new Date();
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getRunUser() {
    return runUser;
  }

  public void setRunUser(String runUser) {
    this.runUser = runUser;
  }

  public Date getRunTime() {
    return runTime;
  }

  public void setRunTime(Date runTime) {
    this.runTime = runTime;
  }
}