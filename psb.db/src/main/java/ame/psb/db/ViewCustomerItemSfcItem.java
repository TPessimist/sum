package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class ViewCustomerItemSfcItem extends CustomerItem implements
    Comparable<ViewCustomerItemSfcItem> {

  private String sfcBo;

  private String carrierBo;

  private int slotNo;

  private String itemStateName;

  private String itemCurrentRun;

  private String sfcStateName;

  private String sfcCurrentRun;

  private String rootSfcBo;

  private Long currSeq;

  private String itemLotName;

  private String itemLotNameOrig;

  private String customerBo;

  private String customerOrder;

  private String lotType;

  private String dptNo;

  private String shopOrderName;

  private String sfcName;

  private String deviceBo;

  private String deviceName;

  private String packageBo;

  private String packageName;

  private String productBo;

  private String productName;

  private String customerName;

  private String sfcType;

  private String batchNo;

  public ViewCustomerItemSfcItem() {
  }

  public ViewCustomerItemSfcItem(String id, String itemStateName, String sfcBo,
      String sfcStateName) {
    setId(id);
    setItemStateName(itemStateName);
    this.sfcBo = sfcBo;
    this.sfcStateName = sfcStateName;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getItemStateName() {
    return this.itemStateName;
  }

  public void setItemStateName(String itemStateName) {
    this.itemStateName = itemStateName;
  }

  public String getItemCurrentRun() {
    return this.itemCurrentRun;
  }

  public void setItemCurrentRun(String itemCurrentRun) {
    this.itemCurrentRun = itemCurrentRun;
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

  public String getRootSfcBo() {
    return this.rootSfcBo;
  }

  public void setRootSfcBo(String rootSfcBo) {
    this.rootSfcBo = rootSfcBo;
  }

  public Long getCurrSeq() {
    return this.currSeq;
  }

  public void setCurrSeq(Long currSeq) {
    this.currSeq = currSeq;
  }

  public String getCarrierBo() {
    return this.carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public int getSlotNo() {
    return this.slotNo;
  }

  public void setSlotNo(int slotNo) {
    this.slotNo = slotNo;
  }

  public String getItemLotName() {
    return this.itemLotName;
  }

  public void setItemLotName(String itemLotName) {
    this.itemLotName = itemLotName;
  }

  public String getItemLotNameOrig() {
    return this.itemLotNameOrig;
  }

  public void setItemLotNameOrig(String itemLotNameOrig) {
    this.itemLotNameOrig = itemLotNameOrig;
  }

  public String getCustomerBo() {
    return this.customerBo;
  }

  public void setCustomerBo(String customerBo) {
    this.customerBo = customerBo;
  }

  public String getCustomerOrder() {
    return this.customerOrder;
  }

  public void setCustomerOrder(String customerOrder) {
    this.customerOrder = customerOrder;
  }

  public String getLotType() {
    return this.lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  public String getDptNo() {
    return this.dptNo;
  }

  public void setDptNo(String dptNo) {
    this.dptNo = dptNo;
  }

  public String getShopOrderName() {
    return this.shopOrderName;
  }

  public void setShopOrderName(String shopOrderName) {
    this.shopOrderName = shopOrderName;
  }

  public String getSfcName() {
    return this.sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
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

  public String getProductBo() {
    return this.productBo;
  }

  public void setProductBo(String productBo) {
    this.productBo = productBo;
  }

  public String getProductName() {
    return this.productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getSfcType() {
    return this.sfcType;
  }

  public void setSfcType(String sfcType) {
    this.sfcType = sfcType;
  }

  public String getBatchNo() {
    return this.batchNo == null ? "A" : this.batchNo;
  }

  public void setBatchNo(String batchNo) {
    this.batchNo = batchNo;
  }

  @Override
  public String toString() {
    return String.format("%-28s, %-12s, %2s, %6s, %-20s, %-12s, %-12s, %s",
        getId(),
        getSfcName(),
        this.slotNo,
        getGrossQty(),
        getShopOrderName(),
        getDeviceName(),
        getPackageName(),
        getProductName());
  }

  @Override
  public int compareTo(ViewCustomerItemSfcItem o) {
    // TODO Auto-generated method stub
    return this.slotNo - o.slotNo;
  }

}
