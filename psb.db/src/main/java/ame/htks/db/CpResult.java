package ame.htks.db;

import java.util.Date;

public class CpResult {

  private String id;

  private String waferId;

  private String customer;

  private String deviceName;

  private String customerLot;

  private int indexX;

  private int indexY;

  private int waferSize;

  private int ofDirection;

  private int passQty;

  private int totalQty;

  private int failQty;

  private Date startTime;

  private Date endTime;

  private Date updatedTime;

  private String operationBo;

  public CpResult() {
  }

  public CpResult(CpResult data) {
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
  }

  @Override
  public CpResult clone() {
    return new CpResult(this);
  }

  @Override
  public String toString() {
    return this.id;
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

  public int getIndexX() {
    return indexX;
  }

  public void setIndexX(int indexX) {
    this.indexX = indexX;
  }

  public int getIndexY() {
    return indexY;
  }

  public void setIndexY(int indexY) {
    this.indexY = indexY;
  }

  public int getWaferSize() {
    return waferSize;
  }

  public void setWaferSize(int waferSize) {
    this.waferSize = waferSize;
  }

  public int getOfDirection() {
    return ofDirection;
  }

  public void setOfDirection(int ofDirection) {
    this.ofDirection = ofDirection;
  }

  public int getPassQty() {
    return passQty;
  }

  public void setPassQty(int passQty) {
    this.passQty = passQty;
  }

  public int getTotalQty() {
    return totalQty;
  }

  public void setTotalQty(int totalQty) {
    this.totalQty = totalQty;
  }

  public int getFailQty() {
    return failQty;
  }

  public void setFailQty(int failQty) {
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

}
