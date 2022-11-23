package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class PkgContainerSfcLog extends PkgContainerSfc {

  private String id;

  private Date runTime;

  private String runUser;

  public PkgContainerSfcLog() {
  }

  public PkgContainerSfcLog(PkgContainerSfc data, String user) {
    super(data);
    this.id = System.currentTimeMillis() + "::" + UUID.randomUUID().toString();
    this.runTime = new Date();
    this.runUser = user;
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