package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class RunSplitMergeItem {

  private String id;

  private String runBo;

  private String sfcBo;

  private String customerItemBo;

  private BigDecimal slotNo;

  private Date runTime;

  private String runUser;


  public RunSplitMergeItem() {
    this.id = UUID.randomUUID().toString();
    this.runTime = new Date();
  }

  public RunSplitMergeItem(RunSplitMergeItem data) {
    this.id = data.id;
    this.runBo = data.runBo;
    this.sfcBo = data.sfcBo;
    this.customerItemBo = data.customerItemBo;
    this.slotNo = data.slotNo;
    this.runTime = data.runTime;
    this.runUser = data.runUser;
  }

  @Override
  public RunSplitMergeItem clone() {
    return new RunSplitMergeItem(this);
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

  public String getRunBo() {
    return runBo;
  }

  public void setRunBo(String runBo) {
    this.runBo = runBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public BigDecimal getSlotNo() {
    return slotNo;
  }

  public void setSlotNo(BigDecimal slotNo) {
    this.slotNo = slotNo;
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