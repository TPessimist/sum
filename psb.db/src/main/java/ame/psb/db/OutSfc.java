package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class OutSfc {

  private String id;

  private String sfcBo;

  private String stateName;

  private String perviousStateName;

  private String flag;

  private String updatedUser;

  private Date updatedTime;

  private int itemQty;

  private String waferList;

  private String customerItemSet;

  private String deliverWay;

  private String postagePayment;

  private String receivedAddress;

  private String contact;

  private String telephone;

  private String senderName;

  private String senderPhone;

  private String sapMatkl;

  private String expressNumber;

  public OutSfc() {
    this.id = UUID.randomUUID().toString();
  }

  public OutSfc(OutSfc data) {

    this.id = data.id;
    this.sfcBo = data.sfcBo;
    this.stateName = data.stateName;
    this.perviousStateName = data.perviousStateName;
    this.flag = data.flag;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;

    this.itemQty = data.itemQty;
    this.waferList = data.waferList;
    this.customerItemSet = data.customerItemSet;
    this.deliverWay = data.deliverWay;
    this.postagePayment = data.postagePayment;
    this.receivedAddress = data.receivedAddress;
    this.contact = data.contact;
    this.telephone = data.telephone;
    this.senderName = data.senderName;
    this.senderPhone = data.senderPhone;
    this.sapMatkl = data.sapMatkl;
    this.expressNumber = data.expressNumber;
  }


  @Override
  public OutSfc clone() {
    return new OutSfc(this);
  }

  @Override
  public String toString() {
    return this.sfcBo;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getPerviousStateName() {
    return perviousStateName;
  }

  public void setPerviousStateName(String perviousStateName) {
    this.perviousStateName = perviousStateName;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public int getItemQty() {
    return itemQty;
  }

  public void setItemQty(int itemQty) {
    this.itemQty = itemQty;
  }

  public String getWaferList() {
    return waferList;
  }

  public void setWaferList(String waferList) {
    this.waferList = waferList;
  }

  public String getCustomerItemSet() {
    return customerItemSet;
  }

  public void setCustomerItemSet(String customerItemSet) {
    this.customerItemSet = customerItemSet;
  }

  public String getDeliverWay() {
    return deliverWay;
  }

  public void setDeliverWay(String deliverWay) {
    this.deliverWay = deliverWay;
  }

  public String getPostagePayment() {
    return postagePayment;
  }

  public void setPostagePayment(String postagePayment) {
    this.postagePayment = postagePayment;
  }

  public String getReceivedAddress() {
    return receivedAddress;
  }

  public void setReceivedAddress(String receivedAddress) {
    this.receivedAddress = receivedAddress;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getSenderName() {
    return senderName;
  }

  public void setSenderName(String senderName) {
    this.senderName = senderName;
  }

  public String getSenderPhone() {
    return senderPhone;
  }

  public void setSenderPhone(String senderPhone) {
    this.senderPhone = senderPhone;
  }

  public String getSapMatkl() {
    return sapMatkl;
  }

  public void setSapMatkl(String sapMatkl) {
    this.sapMatkl = sapMatkl;
  }

  public String getExpressNumber() {
    return expressNumber;
  }

  public void setExpressNumber(String expressNumber) {
    this.expressNumber = expressNumber;
  }
}
