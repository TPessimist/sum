package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class MtInventory {

  private String inventoryBo;

  private String stateName;

  private int pickedCount;

  private Date availableTime;

  private Date validFrom;

  private Date validTo;

  private BigDecimal minsInProcess;

  public MtInventory() {
    this.availableTime = new Date();
    this.validFrom = this.availableTime;
    this.minsInProcess = new BigDecimal(0);
  }

  public MtInventory(MtInventory data) {
    this.inventoryBo = data.inventoryBo;
    this.stateName = data.stateName;
    this.pickedCount = data.pickedCount;
    this.availableTime = data.availableTime;
    this.validFrom = data.validFrom;
    this.validTo = data.validTo;
    this.minsInProcess = data.minsInProcess;
  }

  public String getInventoryBo() {
    return this.inventoryBo;
  }

  public void setInventoryBo(String inventoryBo) {
    this.inventoryBo = inventoryBo;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public int getPickedCount() {
    return this.pickedCount;
  }

  public void setPickedCount(int pickedCount) {
    this.pickedCount = pickedCount;
  }

  public Date getAvailableTime() {
    return this.availableTime;
  }

  public void setAvailableTime(Date availableTime) {
    this.availableTime = availableTime;
  }

  public Date getValidFrom() {
    return this.validFrom;
  }

  public void setValidFrom(Date validFrom) {
    this.validFrom = validFrom;
  }

  public Date getValidTo() {
    return this.validTo;
  }

  public void setValidTo(Date validTo) {
    this.validTo = validTo;
  }

  public BigDecimal getMinsInProcess() {
    return this.minsInProcess;
  }

  public void setMinsInProcess(BigDecimal minsInProcess) {
    this.minsInProcess = minsInProcess;
  }

  @Override
  public MtInventory clone() {
    return new MtInventory(this);
  }

  @Override
  public String toString() {
    return this.inventoryBo;
  }
}
