package ame.psb.db;

import java.util.Date;

public class ResourceSpecialItem {

  private String resourceBo;

  private String itemName;


  private String updatedUser;

  private Date updatedTime;

  private String stateName;

  public ResourceSpecialItem() {
  }

  public ResourceSpecialItem(ResourceSpecialItem data) {
    this.resourceBo = data.resourceBo;
    this.itemName = data.itemName;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.stateName = data.stateName;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
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

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  @Override
  public ResourceSpecialItem clone() {
    return new ResourceSpecialItem(this);
  }

  @Override
  public String toString() {
    return this.resourceBo + ", " + this.itemName;
  }
}
