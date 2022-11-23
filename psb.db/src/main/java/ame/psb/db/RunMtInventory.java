package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class RunMtInventory {

  private String id;

  private String inventoryBo;

  private String actionName;

  private BigDecimal count;

  private Date validFrom;

  private Date validTo;

  private String updatedUser;

  private Date updatedTime;


  public RunMtInventory() {
  }

  public RunMtInventory(RunMtInventory data) {
    this.id = data.id;
    this.inventoryBo = data.inventoryBo;
    this.actionName = data.actionName;
    this.count = data.count;
    this.validFrom = data.validFrom;
    this.validTo = data.validTo;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public RunMtInventory clone() {
    return new RunMtInventory(this);
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

  public BigDecimal getCount() {
    return count;
  }

  public void setCount(BigDecimal count) {
    this.count = count;
  }

  public Date getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(Date validFrom) {
    this.validFrom = validFrom;
  }

  public Date getValidTo() {
    return validTo;
  }

  public void setValidTo(Date validTo) {
    this.validTo = validTo;
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
