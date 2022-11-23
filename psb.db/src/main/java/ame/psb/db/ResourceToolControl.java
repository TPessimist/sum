package ame.psb.db;

import java.util.Date;

public class ResourceToolControl {

  private String inventoryBo;

  private String resourceSlotId;

  private String resourceBo;

  private String type;

  private String state;

  private String updatedUser;

  private Date updatedTime;

  private String reverseField2;


  public ResourceToolControl() {
  }

  public ResourceToolControl(ResourceToolControl data) {
    this.inventoryBo = data.inventoryBo;
    this.resourceSlotId = data.resourceSlotId;
    this.resourceBo = data.resourceBo;
    this.type = data.type;
    this.state = data.state;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.reverseField2 = data.reverseField2;
  }

  public String getInventoryBo() {
    return inventoryBo;
  }

  public void setInventoryBo(String inventoryBo) {
    this.inventoryBo = inventoryBo;
  }

  public String getResourceSlotId() {
    return resourceSlotId;
  }

  public void setResourceSlotId(String resourceSlotId) {
    this.resourceSlotId = resourceSlotId;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
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

  public String getReverseField2() {
    return reverseField2;
  }

  public void setReverseField2(String reverseField2) {
    this.reverseField2 = reverseField2;
  }

  @Override
  public ResourceToolControl clone() {
    return new ResourceToolControl(this);
  }

  @Override
  public String toString() {
    return this.inventoryBo;
  }
}
