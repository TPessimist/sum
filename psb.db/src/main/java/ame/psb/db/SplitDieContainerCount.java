package ame.psb.db;

import java.util.Date;

public class SplitDieContainerCount {

  private String customerDevice;

  private String customerItemsetName;

  private String shopOrderBo;

  private String shopOrderName;

  private String containerBo;

  private String customer;

  private String splitDie;

  private String markingCode;

  private String updateUser;

  private Date updateTime;

  private String reverseField1;

  private String reverseField2;

  private String status;


  public SplitDieContainerCount() {
  }

  public SplitDieContainerCount(SplitDieContainerCount data) {
    this.customerDevice = data.customerDevice;
    this.customerItemsetName = data.customerItemsetName;
    this.shopOrderBo = data.shopOrderBo;
    this.shopOrderName = data.shopOrderName;
    this.containerBo = data.containerBo;
    this.customer = data.customer;
    this.splitDie = data.splitDie;
    this.markingCode = data.markingCode;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.reverseField1 = data.reverseField1;
    this.reverseField2 = data.reverseField2;
    this.status = data.status;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCustomerDevice() {
    return customerDevice;
  }

  public void setCustomerDevice(String customerDevice) {
    this.customerDevice = customerDevice;
  }

  public String getCustomerItemsetName() {
    return customerItemsetName;
  }

  public void setCustomerItemsetName(String customerItemsetName) {
    this.customerItemsetName = customerItemsetName;
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

  public String getContainerBo() {
    return containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getSplitDie() {
    return splitDie;
  }

  public void setSplitDie(String splitDie) {
    this.splitDie = splitDie;
  }

  public String getMarkingCode() {
    return markingCode;
  }

  public void setMarkingCode(String markingCode) {
    this.markingCode = markingCode;
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

  @Override
  public SplitDieContainerCount clone() {
    return new SplitDieContainerCount(this);
  }

  @Override
  public String toString() {
    return this.customerDevice + ", " + this.customerItemsetName + ", " + this.shopOrderBo;
  }
}
