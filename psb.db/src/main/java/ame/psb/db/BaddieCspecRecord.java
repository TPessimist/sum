package ame.psb.db;

import java.util.Date;

public class BaddieCspecRecord {

  private String shopOrder; //工单

  private String customer; //客户

  private String lot; //客批

  private String device; //厂内机种

  private String customerDevice; //客户机种

  private String code; //处理方式

  private String comment; //备用列1

  private String description; //备用列2

  private String message; //备用列3

  private String remarks; //备用列4

  private String definition; //备用列5

  private String flag; //备用列6

  private String notes; //备用列7

  private String updateUser; //更新人员

  private Date updateTime; //更新时间

  private String item; //产品


  public BaddieCspecRecord() {
  }

  public BaddieCspecRecord(BaddieCspecRecord data) {
    this.shopOrder = data.shopOrder;
    this.customer = data.customer;
    this.lot = data.lot;
    this.device = data.device;
    this.customerDevice = data.customerDevice;
    this.code = data.code;
    this.comment = data.comment;
    this.description = data.description;
    this.message = data.message;
    this.remarks = data.remarks;
    this.definition = data.definition;
    this.flag = data.flag;
    this.notes = data.notes;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.item = data.item;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getLot() {
    return lot;
  }

  public void setLot(String lot) {
    this.lot = lot;
  }

  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public String getCustomerDevice() {
    return customerDevice;
  }

  public void setCustomerDevice(String customerDevice) {
    this.customerDevice = customerDevice;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getDefinition() {
    return definition;
  }

  public void setDefinition(String definition) {
    this.definition = definition;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
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

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  @Override
  public BaddieCspecRecord clone() {
    return new BaddieCspecRecord(this);
  }

  @Override
  public String toString() {
    return this.shopOrder;
  }
}
