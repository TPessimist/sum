package ame.psb.db;

import java.util.Date;

public class ShopOrderBatch {

  private String shopOrderBo;

  private String batchId;

  private String sfcBo;

  private String finishFlag;

  private String reverseField1;

  private String reverseField2;

  private String updateUser;

  private Date updateTime;

  private String carrierBo;

  public ShopOrderBatch() {
  }

  public ShopOrderBatch(ShopOrderBatch data) {
    this.shopOrderBo = data.shopOrderBo;
    this.batchId = data.batchId;
    this.sfcBo = data.sfcBo;
    this.finishFlag = data.finishFlag;
    this.reverseField1 = data.reverseField1;
    this.reverseField2 = data.reverseField2;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getFinishFlag() {
    return finishFlag;
  }

  public void setFinishFlag(String finishFlag) {
    this.finishFlag = finishFlag;
  }

  public String getReverseField1() {
    return reverseField1;
  }

  public void setReverseField1(String reverseField1) {
    this.reverseField1 = reverseField1;
  }

  public String getReverseField2() {
    return reverseField2;
  }

  public void setReverseField2(String reverseField2) {
    this.reverseField2 = reverseField2;
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

  public String getCarrierBo() {
    return carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  @Override
  public ShopOrderBatch clone() {
    return new ShopOrderBatch(this);
  }

  @Override
  public String toString() {
    return this.shopOrderBo + ", " + this.batchId + ", " + this.sfcBo;
  }
}
