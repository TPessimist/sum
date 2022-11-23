package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class Pkg37ReelLog {

  private String handle;

  private String actionName;

  private String reelId;

  private String sfcBo;

  private String stateName;

  private String jobId;

  private BigDecimal reelSeq;

  private BigDecimal dieQty;

  private String resourceBo;

  private String reversedField1;

  private String reversedField2;

  private String runUser;

  private Date runTime;


  public Pkg37ReelLog() {
  }

  public Pkg37ReelLog(Pkg37ReelLog data) {
    this.handle = data.handle;
    this.actionName = data.actionName;
    this.reelId = data.reelId;
    this.sfcBo = data.sfcBo;
    this.stateName = data.stateName;
    this.jobId = data.jobId;
    this.reelSeq = data.reelSeq;
    this.dieQty = data.dieQty;
    this.resourceBo = data.resourceBo;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.runUser = data.runUser;
    this.runTime = data.runTime;
  }

  @Override
  public Pkg37ReelLog clone() {
    return new Pkg37ReelLog(this);
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

  public String getReelId() {
    return reelId;
  }

  public void setReelId(String reelId) {
    this.reelId = reelId;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public BigDecimal getReelSeq() {
    return reelSeq;
  }

  public void setReelSeq(BigDecimal reelSeq) {
    this.reelSeq = reelSeq;
  }

  public BigDecimal getDieQty() {
    return dieQty;
  }

  public void setDieQty(BigDecimal dieQty) {
    this.dieQty = dieQty;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getReversedField1() {
    return reversedField1;
  }

  public void setReversedField1(String reversedField1) {
    this.reversedField1 = reversedField1;
  }

  public String getReversedField2() {
    return reversedField2;
  }

  public void setReversedField2(String reversedField2) {
    this.reversedField2 = reversedField2;
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
