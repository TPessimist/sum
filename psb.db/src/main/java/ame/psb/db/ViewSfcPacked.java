package ame.psb.db;

import java.util.Date;

public class ViewSfcPacked extends SfcEx {

  private String sfcName;

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

  private int sfcQty;

  private String customer;

  private String statusBo;

  private String customerItemsetNameOrig;

  private String containerBo;

  private String containerStateName;

  private String pkgContainerBo;

  private Date packingTime;

  private String operationBo;

  public ViewSfcPacked() {
  }

  public ViewSfcPacked(ViewSfcPacked data) {
    super(data);
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
    this.customerItemsetNameOrig = data.customerItemsetNameOrig;
    this.containerBo = data.containerBo;
    this.containerStateName = data.containerStateName;
    this.pkgContainerBo = data.pkgContainerBo;
    this.packingTime = data.packingTime;
    this.operationBo = data.operationBo;
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

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getDeviceBo() {
    return this.deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getDeviceName() {
    return this.deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getPackageBo() {
    return this.packageBo;
  }

  public void setPackageBo(String packageBo) {
    this.packageBo = packageBo;
  }

  public String getPackageName() {
    return this.packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getRouterBo() {
    return this.routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getRouterName() {
    return this.routerName;
  }

  public void setRouterName(String routerName) {
    this.routerName = routerName;
  }

  public int getSfcQty() {
    return this.sfcQty;
  }

  public void setSfcQty(int sfcQty) {
    this.sfcQty = sfcQty;
  }

  public String getCustomer() {
    return this.customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getCustomerItemsetNameOrig() {
    return this.customerItemsetNameOrig;
  }

  public void setCustomerItemsetNameOrig(String customerItemsetNameOrig) {
    this.customerItemsetNameOrig = customerItemsetNameOrig;
  }

  public String getContainerBo() {
    return this.containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getContainerStateName() {
    return this.containerStateName;
  }

  public void setContainerStateName(String containerStateName) {
    this.containerStateName = containerStateName;
  }

  public String getPkgContainerBo() {
    return this.pkgContainerBo;
  }

  public void setPkgContainerBo(String pkgContainerBo) {
    this.pkgContainerBo = pkgContainerBo;
  }

  public Date getPackingTime() {
    return this.packingTime;
  }

  public void setPackingTime(Date packingTime) {
    this.packingTime = packingTime;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  @Override
  public ViewSfcPacked clone() {
    return new ViewSfcPacked(this);
  }
}