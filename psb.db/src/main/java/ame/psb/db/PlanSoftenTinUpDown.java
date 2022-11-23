package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class PlanSoftenTinUpDown {

  private String id;

  private String inventoryBo;

  private String slotId;

  private String itemBo;

  private String itemName;

  private String inventoryId;

  private String resource;

  private Date expireTime;

  private String type;

  private String itemDescription;

  private String updateUser;

  private Date createTime;

  private String content1;

  private String content2;

  private BigDecimal replacementQuantity;


  public PlanSoftenTinUpDown() {
  }

  public PlanSoftenTinUpDown(PlanSoftenTinUpDown data) {
    this.id = data.id;
    this.inventoryBo = data.inventoryBo;
    this.slotId = data.slotId;
    this.itemBo = data.itemBo;
    this.itemName = data.itemName;
    this.inventoryId = data.inventoryId;
    this.resource = data.resource;
    this.expireTime = data.expireTime;
    this.type = data.type;
    this.itemDescription = data.itemDescription;
    this.updateUser = data.updateUser;
    this.createTime = data.createTime;
    this.content1 = data.content1;
    this.content2 = data.content2;
    this.replacementQuantity = data.replacementQuantity;
  }

  public BigDecimal getReplacementQuantity() {
    return replacementQuantity;
  }

  public void setReplacementQuantity(BigDecimal replacementQuantity) {
    this.replacementQuantity = replacementQuantity;
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

  public String getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getSlotId() {
    return slotId;
  }

  public void setSlotId(String slotId) {
    this.slotId = slotId;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public Date getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(Date expireTime) {
    this.expireTime = expireTime;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
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
  public PlanSoftenTinUpDown clone() {
    return new PlanSoftenTinUpDown(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
