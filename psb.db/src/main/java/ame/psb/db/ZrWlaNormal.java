package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class ZrWlaNormal {

  private String id;

  private String itemName;

  private String sfcBo;

  private String shopOrder;

  private String sapShopOrder;

  private String operationBo;

  private String normalFlag;

  private String updatedUser;

  private Date updatedTime;


  public ZrWlaNormal() {
    this.id = UUID.randomUUID().toString();
  }

  public ZrWlaNormal(ZrWlaNormal data) {
    this.id = data.id;
    this.itemName = data.itemName;
    this.sfcBo = data.sfcBo;
    this.shopOrder = data.shopOrder;
    this.sapShopOrder = data.sapShopOrder;
    this.operationBo = data.operationBo;
    this.normalFlag = data.normalFlag;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getSapShopOrder() {
    return sapShopOrder;
  }

  public void setSapShopOrder(String sapShopOrder) {
    this.sapShopOrder = sapShopOrder;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getNormalFlag() {
    return normalFlag;
  }

  public void setNormalFlag(String normalFlag) {
    this.normalFlag = normalFlag;
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
  public ZrWlaNormal clone() {
    return new ZrWlaNormal(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
