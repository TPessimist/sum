package ame.psb.db;

import java.util.Date;

public class ItemGroupCustomData {

  private String itemGroupBo;

  private String customName;

  private String customValue;

  private String comment;

  private String updatedUser;

  private Date updatedTime;


  public ItemGroupCustomData() {
  }

  public ItemGroupCustomData(ItemGroupCustomData data) {
    this.itemGroupBo = data.itemGroupBo;
    this.customName = data.customName;
    this.customValue = data.customValue;
    this.comment = data.comment;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }


  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getCustomName() {
    return customName;
  }

  public void setCustomName(String customName) {
    this.customName = customName;
  }

  public String getCustomValue() {
    return customValue;
  }

  public void setCustomValue(String customValue) {
    this.customValue = customValue;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
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
  public ItemGroupCustomData clone() {
    return new ItemGroupCustomData(this);
  }

  @Override
  public String toString() {
    return this.itemGroupBo + ", " + this.customName;
  }
}
