package ame.psb.db;

import java.util.Date;

public class InventoryResourcePosition {

  private String inventoryId;

  private String resourceSlotId;

  private String sourceType;

  private String updatedUser;

  private Date updatedTime;

  public InventoryResourcePosition() {
  }

  public InventoryResourcePosition(InventoryResourcePosition data) {
    this.inventoryId = data.inventoryId;
    this.resourceSlotId = data.resourceSlotId;
    this.sourceType = data.sourceType;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public InventoryResourcePosition clone() {
    return new InventoryResourcePosition(this);
  }

  @Override
  public String toString() {
    return this.inventoryId;
  }

  public String getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getResourceSlotId() {
    return resourceSlotId;
  }

  public void setResourceSlotId(String resourceSlotId) {
    this.resourceSlotId = resourceSlotId;
  }

  public String getSourceType() {
    return sourceType;
  }

  public void setSourceType(String sourceType) {
    this.sourceType = sourceType;
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
