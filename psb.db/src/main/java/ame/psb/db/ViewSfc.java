package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ViewSfc {

  private String sfcBo;

  private String sfcName;

  private String stateName;

  private String currentRun;

  private String customerItemsetBo;

  private BigDecimal priority;

  private String dptNo;

  private String lotType;

  private BigDecimal itemQty;

  private String shopOrderBo;

  private String shopOrderName;

  private String itemBo;

  private String itemName;

  private String deviceBo;

  private String deviceName;

  private String packageBo;

  private String packageName;

  private String routerBo;

  private String routerName;

  private BigDecimal sfcQty;

  private String customer;

  private String statusBo;

  private String customerItemsetName;

  private String remark;

  private String customerItemsetNameOrig;

  private String carrierBo;

  private String carrierName;

  private String carrierStateName;

  private BigDecimal currSeq;

  private String sfcType;

  private Date createdDateTime;


  public ViewSfc() {
  }

  public ViewSfc(ViewSfc data) {
    this.sfcBo = data.sfcBo;
    this.sfcName = data.sfcName;
    this.stateName = data.stateName;
    this.currentRun = data.currentRun;
    this.customerItemsetBo = data.customerItemsetBo;
    this.priority = data.priority;
    this.dptNo = data.dptNo;
    this.lotType = data.lotType;
    this.itemQty = data.itemQty;
    this.shopOrderBo = data.shopOrderBo;
    this.shopOrderName = data.shopOrderName;
    this.itemBo = data.itemBo;
    this.itemName = data.itemName;
    this.deviceBo = data.deviceBo;
    this.deviceName = data.deviceName;
    this.packageBo = data.packageBo;
    this.packageName = data.packageName;
    this.routerBo = data.routerBo;
    this.routerName = data.routerName;
    this.sfcQty = data.sfcQty;
    this.customer = data.customer;
    this.statusBo = data.statusBo;
    this.customerItemsetName = data.customerItemsetName;
    this.remark = data.remark;
    this.customerItemsetNameOrig = data.customerItemsetNameOrig;
    this.carrierBo = data.carrierBo;
    this.carrierName = data.carrierName;
    this.carrierStateName = data.carrierStateName;
    this.currSeq = data.currSeq;
    this.sfcType = data.sfcType;
    this.createdDateTime = data.createdDateTime;
  }

  @Override
  public ViewSfc clone() {
    return new ViewSfc(this);
  }

  @Override
  public String toString() {
    return this.sfcBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCurrentRun() {
    return currentRun;
  }

  public void setCurrentRun(String currentRun) {
    this.currentRun = currentRun;
  }

  public String getCustomerItemsetBo() {
    return customerItemsetBo;
  }

  public void setCustomerItemsetBo(String customerItemsetBo) {
    this.customerItemsetBo = customerItemsetBo;
  }

  public BigDecimal getPriority() {
    return priority;
  }

  public void setPriority(BigDecimal priority) {
    this.priority = priority;
  }

  public String getDptNo() {
    return dptNo;
  }

  public void setDptNo(String dptNo) {
    this.dptNo = dptNo;
  }

  public String getLotType() {
    return lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  public BigDecimal getItemQty() {
    return itemQty;
  }

  public void setItemQty(BigDecimal itemQty) {
    this.itemQty = itemQty;
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

  public String getDeviceBo() {
    return deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getPackageBo() {
    return packageBo;
  }

  public void setPackageBo(String packageBo) {
    this.packageBo = packageBo;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getRouterBo() {
    return routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getRouterName() {
    return routerName;
  }

  public void setRouterName(String routerName) {
    this.routerName = routerName;
  }

  public BigDecimal getSfcQty() {
    return sfcQty;
  }

  public void setSfcQty(BigDecimal sfcQty) {
    this.sfcQty = sfcQty;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getStatusBo() {
    return statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getCustomerItemsetName() {
    return customerItemsetName;
  }

  public void setCustomerItemsetName(String customerItemsetName) {
    this.customerItemsetName = customerItemsetName;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getCustomerItemsetNameOrig() {
    return customerItemsetNameOrig;
  }

  public void setCustomerItemsetNameOrig(String customerItemsetNameOrig) {
    this.customerItemsetNameOrig = customerItemsetNameOrig;
  }

  public String getCarrierBo() {
    return carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getCarrierName() {
    return carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  public String getCarrierStateName() {
    return carrierStateName;
  }

  public void setCarrierStateName(String carrierStateName) {
    this.carrierStateName = carrierStateName;
  }

  public BigDecimal getCurrSeq() {
    return currSeq;
  }

  public void setCurrSeq(BigDecimal currSeq) {
    this.currSeq = currSeq;
  }

  public String getSfcType() {
    return sfcType;
  }

  public void setSfcType(String sfcType) {
    this.sfcType = sfcType;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }


}
