package ame.me.db;

import java.util.Date;

public class ZdFcBatchNumber {

  private String id;

  private String shopOrderBo;

  private String shopOrderName;

  private String batchQty;

  private String customFields1;

  private String customFields2;

  private String updatedUser;

  private Date updatedTime;


  public ZdFcBatchNumber() {
  }

  public ZdFcBatchNumber(ZdFcBatchNumber data) {
    this.id = data.id;
    this.shopOrderBo = data.shopOrderBo;
    this.shopOrderName = data.shopOrderName;
    this.batchQty = data.batchQty;
    this.customFields1 = data.customFields1;
    this.customFields2 = data.customFields2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getShopOrderName() {
    return shopOrderName;
  }

  public void setShopOrderName(String shopOrderName) {
    this.shopOrderName = shopOrderName;
  }

  public String getBatchQty() {
    return batchQty;
  }

  public void setBatchQty(String batchQty) {
    this.batchQty = batchQty;
  }

  public String getCustomFields1() {
    return customFields1;
  }

  public void setCustomFields1(String customFields1) {
    this.customFields1 = customFields1;
  }

  public String getCustomFields2() {
    return customFields2;
  }

  public void setCustomFields2(String customFields2) {
    this.customFields2 = customFields2;
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
  public ZdFcBatchNumber clone() {
    return new ZdFcBatchNumber(this);
  }

  @Override
  public String toString() {
    return this.shopOrderBo;
  }
}
