package ame.psb.db;

import java.util.Date;

public class FCPmcCarrierChange {

  private String sfcBo;

  private String batchId;

  private String originalCarrier;

  private String newCarrier;

  private String operationBo;

  private String resourceBo;

  private String updateUser;

  private Date updateTime;

  private String shopOrderBo;



  public FCPmcCarrierChange() {
  }

  public FCPmcCarrierChange(FCPmcCarrierChange data) {
    this.sfcBo = data.sfcBo;
    this.batchId = data.batchId;
    this.originalCarrier = data.originalCarrier;
    this.newCarrier = data.newCarrier;
    this.operationBo = data.operationBo;
    this.resourceBo = data.resourceBo;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.shopOrderBo = data.shopOrderBo;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getOriginalCarrier() {
    return originalCarrier;
  }

  public void setOriginalCarrier(String originalCarrier) {
    this.originalCarrier = originalCarrier;
  }

  public String getNewCarrier() {
    return newCarrier;
  }

  public void setNewCarrier(String newCarrier) {
    this.newCarrier = newCarrier;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
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

  @Override
  public FCPmcCarrierChange clone() {
    return new FCPmcCarrierChange(this);
  }

  @Override
  public String toString() {
    return this.sfcBo;
  }
}
