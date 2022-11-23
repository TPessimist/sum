package ame.psb.db;

import java.util.Date;

public class ReworkShopOrderJumpStation {

  private String sfcBo;

  private String shopOrderBo;

  private String operationBo;

  private String type;

  private String shopOrderName;

  private String tableName;

  private String stateName;

  private String message;

  private String updateUser;

  private Date updateTime;

  private String reverse1;

  private String reverse2;


  public ReworkShopOrderJumpStation() {
  }

  public ReworkShopOrderJumpStation(ReworkShopOrderJumpStation data) {
    this.sfcBo = data.sfcBo;
    this.shopOrderBo = data.shopOrderBo;
    this.operationBo = data.operationBo;
    this.type = data.type;
    this.shopOrderName = data.shopOrderName;
    this.tableName = data.tableName;
    this.stateName = data.stateName;
    this.message = data.message;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.reverse1 = data.reverse1;
    this.reverse2 = data.reverse2;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getShopOrderName() {
    return shopOrderName;
  }

  public void setShopOrderName(String shopOrderName) {
    this.shopOrderName = shopOrderName;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getReverse1() {
    return reverse1;
  }

  public void setReverse1(String reverse1) {
    this.reverse1 = reverse1;
  }

  public String getReverse2() {
    return reverse2;
  }

  public void setReverse2(String reverse2) {
    this.reverse2 = reverse2;
  }

  @Override
  public ReworkShopOrderJumpStation clone() {
    return new ReworkShopOrderJumpStation(this);
  }

  @Override
  public String toString() {
    return this.sfcBo + ", " + this.shopOrderBo;
  }
}
