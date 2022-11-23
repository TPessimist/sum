package ame.psb.db;

import ame.psb.commons.Env;
import java.util.Date;

public class ViewSfcEx extends SfcEx implements Comparable<ViewSfcEx> {

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

  private String statusBo;

  private String customer;

  private String customerItemLotNameOrig;

  private String carrierBo;

  private String carrierName;

  private String carrierStateName;

  private Date createdDateTime;

  private String meSfcStateName;

  private String resourceSlotId;

  private String itemsetNameOrig;

  public ViewSfcEx() {
  }

  public ViewSfcEx(String sfcBo, String stateName) {
    super(sfcBo, stateName);
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

  /**
   * 取得 Die 總數量。
   *
   * @return Die 總數量。
   */
  public int getSfcQty() {
    return this.sfcQty;
  }

  /**
   * 設定 Die 總數量。
   *
   * @param sfcQty Die 總數量。
   */
  public void setSfcQty(int sfcQty) {
    this.sfcQty = sfcQty;
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getCustomerItemLotNameOrig() {
    return this.customerItemLotNameOrig;
  }

  public void setCustomerItemLotNameOrig(String customerItemLotNameOrig) {
    this.customerItemLotNameOrig = customerItemLotNameOrig;
  }

  public String getCustomer() {
    return this.customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

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

  public String getCarrierStateName() {
    return this.carrierStateName;
  }

  public void setCarrierStateName(String carrierStateName) {
    this.carrierStateName = carrierStateName;
  }

  public Date getCreatedDateTime() {
    return this.createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public String getMeSfcStateName() {
    return this.meSfcStateName;
  }

  public void setMeSfcStateName(String meSfcStateName) {
    this.meSfcStateName = meSfcStateName;
  }

  public String getResourceSlotId() {
    return this.resourceSlotId;
  }

  public void setResourceSlotId(String resourceSlotId) {
    this.resourceSlotId = resourceSlotId;
  }

  public String getItemsetNameOrig() {
    return itemsetNameOrig;
  }

  public void setItemsetNameOrig(String itemsetNameOrig) {
    this.itemsetNameOrig = itemsetNameOrig;
  }

  public boolean isClosed() {
    if (this.statusBo == null) {
      return false;
    }

    String status = Env.trimHandle(this.statusBo);
    return !"401".equals(status) && !"402".equals(status) && !"403".equals(status) && !"404"
        .equals(status);
  }

  public boolean isInQueue() {
    if (this.statusBo == null) {
      return false;
    }

    String status = Env.trimHandle(this.statusBo);
    return "402".equals(status) || "401".equals(status);
  }

  public boolean isNew() {
    if (this.statusBo == null) {
      return false;
    }

    String status = Env.trimHandle(this.statusBo);
    return "401".equals(status);
  }

  @Override
  public boolean equals(Object o) {
    return o != null && o instanceof ViewSfcEx && ((ViewSfcEx) o).getSfcBo()
        .equals(this.getSfcBo());
  }

  @Override
  public int hashCode() {
    return this.getSfcBo().hashCode();
  }

  @Override
  public int compareTo(ViewSfcEx lot) {
    return this.getSfcBo().compareTo(lot.getSfcBo());
  }

}
