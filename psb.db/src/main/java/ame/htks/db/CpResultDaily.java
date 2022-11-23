package ame.htks.db;

import java.util.Date;

public class CpResultDaily {

  private String id;

  private String waferId;

  private String customer;

  private String deviceName;

  private String customerLot;

  private String indexX;

  private String indexY;

  private String waferSize;

  private String ofDirection;

  private String passQty;

  private String totalQty;

  private String failQty;

  private Date startTime;

  private Date endTime;

  private Date updatedTime;

  private String operationBo;

  private String runSfcItemBo;


  public CpResultDaily() {
  }

  public CpResultDaily(CpResultDaily data) {
    this.id = data.id;
    this.waferId = data.waferId;
    this.customer = data.customer;
    this.deviceName = data.deviceName;
    this.customerLot = data.customerLot;
    this.indexX = data.indexX;
    this.indexY = data.indexY;
    this.waferSize = data.waferSize;
    this.ofDirection = data.ofDirection;
    this.passQty = data.passQty;
    this.totalQty = data.totalQty;
    this.failQty = data.failQty;
    this.startTime = data.startTime;
    this.endTime = data.endTime;
    this.updatedTime = data.updatedTime;
    this.operationBo = data.operationBo;
    this.runSfcItemBo = data.runSfcItemBo;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getWaferId() {
    return waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getCustomerLot() {
    return customerLot;
  }

  public void setCustomerLot(String customerLot) {
    this.customerLot = customerLot;
  }

  public String getIndexX() {
    return indexX;
  }

  public void setIndexX(String indexX) {
    this.indexX = indexX;
  }

  public String getIndexY() {
    return indexY;
  }

  public void setIndexY(String indexY) {
    this.indexY = indexY;
  }

  public String getWaferSize() {
    return waferSize;
  }

  public void setWaferSize(String waferSize) {
    this.waferSize = waferSize;
  }

  public String getOfDirection() {
    return ofDirection;
  }

  public void setOfDirection(String ofDirection) {
    this.ofDirection = ofDirection;
  }

  public String getPassQty() {
    return passQty;
  }

  public void setPassQty(String passQty) {
    this.passQty = passQty;
  }

  public String getTotalQty() {
    return totalQty;
  }

  public void setTotalQty(String totalQty) {
    this.totalQty = totalQty;
  }

  public String getFailQty() {
    return failQty;
  }

  public void setFailQty(String failQty) {
    this.failQty = failQty;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getRunSfcItemBo() {
    return runSfcItemBo;
  }

  public void setRunSfcItemBo(String runSfcItemBo) {
    this.runSfcItemBo = runSfcItemBo;
  }

  @Override
  public CpResultDaily clone() {
    return new CpResultDaily(this);
  }

  @Override
  public String toString() {
    return this.waferId + ", " + this.updatedTime + ", " + this.operationBo;
  }
}
