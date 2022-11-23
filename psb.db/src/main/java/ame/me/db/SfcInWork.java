package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class SfcInWork {

  private String handle;

  private String sfcStepBo;

  private String ownerGbo;

  private String paused;

  private String resourceBo;

  private String workCenterBo;

  private BigDecimal qtyInWork;

  private Date dateStarted;

  private String rework;

  private String userBo;


  public SfcInWork() {
  }

  public SfcInWork(SfcInWork data) {
    this.handle = data.handle;
    this.sfcStepBo = data.sfcStepBo;
    this.ownerGbo = data.ownerGbo;
    this.paused = data.paused;
    this.resourceBo = data.resourceBo;
    this.workCenterBo = data.workCenterBo;
    this.qtyInWork = data.qtyInWork;
    this.dateStarted = data.dateStarted;
    this.rework = data.rework;
    this.userBo = data.userBo;
  }


  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSfcStepBo() {
    return sfcStepBo;
  }

  public void setSfcStepBo(String sfcStepBo) {
    this.sfcStepBo = sfcStepBo;
  }

  public String getOwnerGbo() {
    return ownerGbo;
  }

  public void setOwnerGbo(String ownerGbo) {
    this.ownerGbo = ownerGbo;
  }

  public String getPaused() {
    return paused;
  }

  public void setPaused(String paused) {
    this.paused = paused;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getWorkCenterBo() {
    return workCenterBo;
  }

  public void setWorkCenterBo(String workCenterBo) {
    this.workCenterBo = workCenterBo;
  }

  public BigDecimal getQtyInWork() {
    return qtyInWork;
  }

  public void setQtyInWork(BigDecimal qtyInWork) {
    this.qtyInWork = qtyInWork;
  }

  public Date getDateStarted() {
    return dateStarted;
  }

  public void setDateStarted(Date dateStarted) {
    this.dateStarted = dateStarted;
  }

  public String getRework() {
    return rework;
  }

  public void setRework(String rework) {
    this.rework = rework;
  }

  public String getUserBo() {
    return userBo;
  }

  public void setUserBo(String userBo) {
    this.userBo = userBo;
  }

  @Override
  public SfcInWork clone() {
    return new SfcInWork(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
