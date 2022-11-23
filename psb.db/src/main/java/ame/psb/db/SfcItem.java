package ame.psb.db;

import java.util.Date;

public class SfcItem implements Cloneable {

  private String sfcBo;

  private String customerItemBo;

  private String stateName;

  private String currentRun;

  private String carrierBo;

  private int slotNo;

  private int dieQty;

  private String updatedUser;

  private Date updatedTime;

  private String batchNo;

  public SfcItem() {
    this.stateName = "WAIT";
  }

  public SfcItem(SfcItem data) {
    this.sfcBo = data.sfcBo;
    this.customerItemBo = data.customerItemBo;
    this.stateName = data.stateName;
    this.currentRun = data.currentRun;
    this.carrierBo = data.carrierBo;
    this.slotNo = data.slotNo;
    this.dieQty = data.dieQty;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.batchNo = "A";
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCurrentRun() {
    return this.currentRun;
  }

  public void setCurrentRun(String currentRun) {
    this.currentRun = currentRun;
  }

  public String getCarrierBo() {
    return this.carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public int getSlotNo() {
    return this.slotNo;
  }

  public void setSlotNo(int slotNo) {
    this.slotNo = slotNo;
  }

  public int getDieQty() {
    return this.dieQty;
  }

  public void setDieQty(int dieQty) {
    this.dieQty = dieQty;
  }

  public String getBatchNo() {
    return this.batchNo;
  }

  public void setBatchNo(String batchNo) {
    this.batchNo = batchNo;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  @Override
  public String toString() {
    return this.sfcBo + ", " + this.customerItemBo;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
