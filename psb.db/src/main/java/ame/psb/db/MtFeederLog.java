package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class MtFeederLog extends MtFeeder {

  private String id;

  private String actionName;

  private BigDecimal changeQty;

  private Date runTime;

  private String runUser;

  public MtFeederLog() {
  }

  public MtFeederLog(MtFeeder data, BigDecimal changeQty, String actionName) {
    super(data);
    this.id = System.currentTimeMillis() + "::" + UUID.randomUUID().toString();
    this.actionName = actionName;
    this.changeQty = changeQty;
    this.runTime = new Date();
    this.runUser = data.getCreatedUser();
  }

  @Override
  public String toString() {
    return this.id;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public BigDecimal getChangeQty() {
    return changeQty;
  }

  public void setChangeQty(BigDecimal changeQty) {
    this.changeQty = changeQty;
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