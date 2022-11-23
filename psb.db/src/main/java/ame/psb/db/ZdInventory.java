package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ZdInventory {

  private String inventoryBo;

  private String type;

  private String stateName;

  private String resourceSlotId;

  private String parentInventoryBo;

  private String pickedUser;

  private String updatedUser;

  private Date updatedTime;

  private String installUser;

  private Date installTime;

  private Date validTo;

  private String resource;

  private String qty;


  public ZdInventory() {
  }

  public ZdInventory(ZdInventory data) {
    this.inventoryBo = data.inventoryBo;
    this.type = data.type;
    this.stateName = data.stateName;
    this.resourceSlotId = data.resourceSlotId;
    this.parentInventoryBo = data.parentInventoryBo;
    this.pickedUser = data.pickedUser;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.resource = data.resource;
    this.qty = data.qty;

  }

  @Override
  public ZdInventory clone() {
    return new ZdInventory(this);
  }

  @Override
  public String toString() {
    return this.inventoryBo;
  }

  public String getInventoryBo() {
    return inventoryBo;
  }

  public void setInventoryBo(String inventoryBo) {
    this.inventoryBo = inventoryBo;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getResourceSlotId() {
    return resourceSlotId;
  }

  public void setResourceSlotId(String resourceSlotId) {
    this.resourceSlotId = resourceSlotId;
  }

  public String getParentInventoryBo() {
    return parentInventoryBo;
  }

  public void setParentInventoryBo(String parentInventoryBo) {
    this.parentInventoryBo = parentInventoryBo;
  }

  public String getPickedUser() {
    return pickedUser;
  }

  public void setPickedUser(String pickedUser) {
    this.pickedUser = pickedUser;
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

  public String getInstallUser() {
    return installUser;
  }

  public void setInstallUser(String installUser) {
    this.installUser = installUser;
  }

  public Date getInstallTime() {
    return installTime;
  }

  public void setInstallTime(Date installTime) {
    this.installTime = installTime;
  }

  public Date getValidTo() {
    return validTo;
  }

  public void setValidTo(Date validTo) {
    this.validTo = validTo;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getQty() {
    return qty;
  }

  public void setQty(String qty) {
    this.qty = qty;
  }

  public boolean isAvailable() {
    if (this.validTo == null) {
      return true;
    }
    Date now = new Date();
    return now.before(this.validTo);
  }

}
