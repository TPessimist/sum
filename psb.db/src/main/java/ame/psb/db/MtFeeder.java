package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class MtFeeder {

  private String id;

  private String inventoryBo;

  private BigDecimal feedQty;

  private BigDecimal availableQty;

  private Date createdTime;

  private Date installTime;

  private Date addTime;

  private String createdUser;

  private String resourceBo;

  private String slotName;

  private Date validTo;

  private String qtyStrict;

  private String subResourceBo;

  private Date lifeTime;

  public MtFeeder() {
    this.id = System.currentTimeMillis() + "::" + UUID.randomUUID().toString();
  }

  public MtFeeder(MtFeeder data) {
    this.id = data.id;
    this.inventoryBo = data.inventoryBo;
    this.feedQty = data.feedQty;
    this.availableQty = data.availableQty;
    this.createdTime = data.createdTime;
    this.installTime = data.installTime;
    this.addTime = data.addTime;
    this.createdUser = data.createdUser;
    this.resourceBo = data.resourceBo;
    this.slotName = data.slotName;
    this.validTo = data.validTo;
    this.qtyStrict = data.qtyStrict;
    this.subResourceBo = data.subResourceBo;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getInventoryBo() {
    return this.inventoryBo;
  }

  public void setInventoryBo(String inventoryBo) {
    this.inventoryBo = inventoryBo;
  }

  public BigDecimal getFeedQty() {
    return this.feedQty;
  }

  public void setFeedQty(BigDecimal feedQty) {
    this.feedQty = feedQty;
  }

  public BigDecimal getAvailableQty() {
    return this.availableQty;
  }

  public void setAvailableQty(BigDecimal availableQty) {
    this.availableQty = availableQty;
  }

  public Date getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getInstallTime() {
    return installTime;
  }

  public void setInstallTime(Date installTime) {
    this.installTime = installTime;
  }

  public Date getAddTime() {
    return addTime;
  }

  public void setAddTime(Date addTime) {
    this.addTime = addTime;
  }

  public String getCreatedUser() {
    return this.createdUser;
  }

  public void setCreatedUser(String createdUser) {
    this.createdUser = createdUser;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getSlotName() {
    return this.slotName;
  }

  public void setSlotName(String slotName) {
    this.slotName = slotName;
  }

  public Date getValidTo() {
    return this.validTo;
  }

  public void setValidTo(Date validTo) {
    this.validTo = validTo;
  }

  public String getQtyStrict() {
    return this.qtyStrict;
  }

  public void setQtyStrict(String qtyStrict) {
    this.qtyStrict = qtyStrict;
  }


  public String getSubResourceBo() {
    return subResourceBo;
  }

  public void setSubResourceBo(String subResourceBo) {
    this.subResourceBo = subResourceBo;
  }

  public Date getLifeTime() {
    return lifeTime;
  }

  public void setLifeTime(Date lifeTime) {
    this.lifeTime = lifeTime;
  }

  @Override
  public MtFeeder clone() {
    return new MtFeeder(this);
  }

  @Override
  public String toString() {
    return String.format("%s - %s, slot:%s, available:%s",
        this.id,
        this.resourceBo,
        this.slotName,
        this.availableQty);
  }
}
