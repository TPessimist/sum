package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class PkgContainerLog extends PkgContainer {

  private String handle;

  private String actionName;

  private Date runTime;

  private String runUser;

  public PkgContainerLog() {
  }

  public PkgContainerLog(PkgContainer data, String actionName) {
    super(data);
    this.handle = System.currentTimeMillis() + "::" + UUID.randomUUID().toString();
    this.actionName = actionName;
    this.runTime = new Date();
    this.runUser = data.getPackingUser();
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public Date getRunTime() {
    return runTime;
  }

  public void setRunTime(Date runTime) {
    this.runTime = runTime;
  }

  public String getRunUser() {
    return runUser;
  }

  public void setRunUser(String runUser) {
    this.runUser = runUser;
  }
}