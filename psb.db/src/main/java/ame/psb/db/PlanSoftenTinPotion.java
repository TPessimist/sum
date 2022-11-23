package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class PlanSoftenTinPotion {

  private String itemBo;

  private String slotId;

  private String itemName;

  private BigDecimal replacementTime;

  private BigDecimal replacementQuantity;

  private String type;

  private String updateUser;

  private String status;

  private Date updateTime;

  private String content1;

  private String content2;


  public PlanSoftenTinPotion() {
  }

  public PlanSoftenTinPotion(PlanSoftenTinPotion data) {
    this.itemBo = data.itemBo;
    this.slotId = data.slotId;
    this.itemName = data.itemName;
    this.replacementTime = data.replacementTime;
    this.replacementQuantity = data.replacementQuantity;
    this.type = data.type;
    this.updateUser = data.updateUser;
    this.status = data.status;
    this.updateTime = data.updateTime;
    this.content1 = data.content1;
    this.content2 = data.content2;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getSlotId() {
    return slotId;
  }

  public void setSlotId(String slotId) {
    this.slotId = slotId;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public BigDecimal getReplacementTime() {
    return replacementTime;
  }

  public void setReplacementTime(BigDecimal replacementTime) {
    this.replacementTime = replacementTime;
  }

  public BigDecimal getReplacementQuantity() {
    return replacementQuantity;
  }

  public void setReplacementQuantity(BigDecimal replacementQuantity) {
    this.replacementQuantity = replacementQuantity;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getContent1() {
    return content1;
  }

  public void setContent1(String content1) {
    this.content1 = content1;
  }

  public String getContent2() {
    return content2;
  }

  public void setContent2(String content2) {
    this.content2 = content2;
  }

  @Override
  public PlanSoftenTinPotion clone() {
    return new PlanSoftenTinPotion(this);
  }

  @Override
  public String toString() {
    return this.itemBo + ", " + this.slotId;
  }
}
