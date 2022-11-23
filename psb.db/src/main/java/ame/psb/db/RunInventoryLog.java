package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class RunInventoryLog {

  private String id;

  private String inventoryBo;

  private String actionName;

  private String pickedUser;

  private String sfcBo;

  private String runSfcBo;

  private String resourceBo;

  private String slotBo;

  private BigDecimal count;

  private String updatedUser;

  private Date updatedTime;


  public RunInventoryLog() {
    this.id = UUID.randomUUID().toString();
  }


  public RunInventoryLog(RunInventoryLog data) {
    this.id = data.id;
    this.inventoryBo = data.inventoryBo;
    this.actionName = data.actionName;
    this.pickedUser = data.pickedUser;
    this.sfcBo = data.sfcBo;
    this.runSfcBo = data.runSfcBo;
    this.resourceBo = data.resourceBo;
    this.slotBo = data.slotBo;
    this.count = data.count;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public RunInventoryLog clone() {
    return new RunInventoryLog(this);
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

  public String getInventoryBo() {
    return inventoryBo;
  }

  public void setInventoryBo(String inventoryBo) {
    this.inventoryBo = inventoryBo;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getPickedUser() {
    return pickedUser;
  }

  public void setPickedUser(String pickedUser) {
    this.pickedUser = pickedUser;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getRunSfcBo() {
    return runSfcBo;
  }

  public void setRunSfcBo(String runSfcBo) {
    this.runSfcBo = runSfcBo;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getSlotBo() {
    return slotBo;
  }

  public void setSlotBo(String slotBo) {
    this.slotBo = slotBo;
  }

  public BigDecimal getCount() {
    return count;
  }

  public void setCount(BigDecimal count) {
    this.count = count;
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

}
