package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class ViewCarrierItem {

  private String carrierBo;

  private String carrierName;

  private int slotNo;

  private String customerItemBo;

  private String customerItemName;

  private String customerItemNameOrig;

  private String customerItemLotBo;

  private String customerItemLotName;

  private String customerBo;

  private String sfcBo;

  private String sfcName;

  private String shopOrderBo;

  private String shopOrderName;

  private String carrierType;

  private String carrierStateName;

  private String carrierCurrentRun;

  private String sfcStateName;

  private String sfcCurrentRun;

  private String sfcItemStateName;

  private String sfcItemCurrentRun;

  private String operationBo;

  private String markCode;

  private int grossQty;

  private int goodQty;

  public String getCarrierBo() {
    return this.carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getCarrierName() {
    return this.carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  public int getSlotNo() {
    return this.slotNo;
  }

  public void setSlotNo(int slotNo) {
    this.slotNo = slotNo;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getCustomerItemName() {
    return this.customerItemName;
  }

  public void setCustomerItemName(String customerItemName) {
    this.customerItemName = customerItemName;
  }

  public String getCustomerItemNameOrig() {
    return customerItemNameOrig;
  }

  public void setCustomerItemNameOrig(String customerItemNameOrig) {
    this.customerItemNameOrig = customerItemNameOrig;
  }

  public String getCustomerItemLotBo() {
    return this.customerItemLotBo;
  }

  public void setCustomerItemLotBo(String customerItemLotBo) {
    this.customerItemLotBo = customerItemLotBo;
  }

  public String getCustomerItemLotName() {
    return this.customerItemLotName;
  }

  public void setCustomerItemLotName(String customerItemLotName) {
    this.customerItemLotName = customerItemLotName;
  }

  public String getCustomerBo() {
    return this.customerBo;
  }

  public void setCustomerBo(String customerBo) {
    this.customerBo = customerBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSfcName() {
    return this.sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getShopOrderBo() {
    return this.shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getShopOrderName() {
    return this.shopOrderName;
  }

  public void setShopOrderName(String shopOrderName) {
    this.shopOrderName = shopOrderName;
  }

  public String getCarrierType() {
    return this.carrierType;
  }

  public void setCarrierType(String carrierType) {
    this.carrierType = carrierType;
  }

  public String getCarrierStateName() {
    return this.carrierStateName;
  }

  public void setCarrierStateName(String carrierStateName) {
    this.carrierStateName = carrierStateName;
  }

  public String getCarrierCurrentRun() {
    return this.carrierCurrentRun;
  }

  public void setCarrierCurrentRun(String carrierCurrentRun) {
    this.carrierCurrentRun = carrierCurrentRun;
  }

  public String getSfcStateName() {
    return this.sfcStateName;
  }

  public void setSfcStateName(String sfcStateName) {
    this.sfcStateName = sfcStateName;
  }

  public String getSfcCurrentRun() {
    return this.sfcCurrentRun;
  }

  public void setSfcCurrentRun(String sfcCurrentRun) {
    this.sfcCurrentRun = sfcCurrentRun;
  }

  public String getSfcItemStateName() {
    return this.sfcItemStateName;
  }

  public void setSfcItemStateName(String sfcItemStateName) {
    this.sfcItemStateName = sfcItemStateName;
  }

  public String getSfcItemCurrentRun() {
    return this.sfcItemCurrentRun;
  }

  public void setSfcItemCurrentRun(String sfcItemCurrentRun) {
    this.sfcItemCurrentRun = sfcItemCurrentRun;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getMarkCode() {
    return this.markCode;
  }

  public void setMarkCode(String markCode) {
    this.markCode = markCode;
  }

  public int getGrossQty() {
    return this.grossQty;
  }

  public void setGrossQty(int grossQty) {
    this.grossQty = grossQty;
  }

  public int getGoodQty() {
    return this.goodQty;
  }

  public void setGoodQty(int goodQty) {
    this.goodQty = goodQty;
  }

  @Override
  public String toString() {
    return String.format("%-13s> %-15s of %-15s at %2s in %s",
        this.sfcName,
        this.customerItemName,
        this.customerItemLotName,
        this.slotNo,
        this.carrierName);
  }
}
