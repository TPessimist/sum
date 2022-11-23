package ame.psb.db;

import java.util.Date;

public class SorterMcsItems {

  private String id;

  private String customerItemBo;

  private String slotNo;

  private String carrierBoA;

  private String carrierBoB;

  private String carrierBoC;

  private String sfcBoA;

  private String sfcBoB;

  private String sfcBoC;

  private String newFlagA;

  private String newFlagB;

  private String newFlagC;

  private String jobType;

  private String contentA;

  private String contentB;

  private String contentC;

  private String updateUser;

  private Date updateTime;


  public SorterMcsItems() {
  }

  public SorterMcsItems(SorterMcsItems data) {
    this.id = data.id;
    this.customerItemBo = data.customerItemBo;
    this.slotNo = data.slotNo;
    this.carrierBoA = data.carrierBoA;
    this.carrierBoB = data.carrierBoB;
    this.carrierBoC = data.carrierBoC;
    this.sfcBoA = data.sfcBoA;
    this.sfcBoB = data.sfcBoB;
    this.sfcBoC = data.sfcBoC;
    this.newFlagA = data.newFlagA;
    this.newFlagB = data.newFlagB;
    this.newFlagC = data.newFlagC;
    this.jobType = data.jobType;
    this.contentA = data.contentA;
    this.contentB = data.contentB;
    this.contentC = data.contentC;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getSlotNo() {
    return slotNo;
  }

  public void setSlotNo(String slotNo) {
    this.slotNo = slotNo;
  }

  public String getCarrierBoA() {
    return carrierBoA;
  }

  public void setCarrierBoA(String carrierBoA) {
    this.carrierBoA = carrierBoA;
  }

  public String getCarrierBoB() {
    return carrierBoB;
  }

  public void setCarrierBoB(String carrierBoB) {
    this.carrierBoB = carrierBoB;
  }

  public String getCarrierBoC() {
    return carrierBoC;
  }

  public void setCarrierBoC(String carrierBoC) {
    this.carrierBoC = carrierBoC;
  }

  public String getSfcBoA() {
    return sfcBoA;
  }

  public void setSfcBoA(String sfcBoA) {
    this.sfcBoA = sfcBoA;
  }

  public String getSfcBoB() {
    return sfcBoB;
  }

  public void setSfcBoB(String sfcBoB) {
    this.sfcBoB = sfcBoB;
  }

  public String getSfcBoC() {
    return sfcBoC;
  }

  public void setSfcBoC(String sfcBoC) {
    this.sfcBoC = sfcBoC;
  }

  public String getNewFlagA() {
    return newFlagA;
  }

  public void setNewFlagA(String newFlagA) {
    this.newFlagA = newFlagA;
  }

  public String getNewFlagB() {
    return newFlagB;
  }

  public void setNewFlagB(String newFlagB) {
    this.newFlagB = newFlagB;
  }

  public String getNewFlagC() {
    return newFlagC;
  }

  public void setNewFlagC(String newFlagC) {
    this.newFlagC = newFlagC;
  }

  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  public String getContentA() {
    return contentA;
  }

  public void setContentA(String contentA) {
    this.contentA = contentA;
  }

  public String getContentB() {
    return contentB;
  }

  public void setContentB(String contentB) {
    this.contentB = contentB;
  }

  public String getContentC() {
    return contentC;
  }

  public void setContentC(String contentC) {
    this.contentC = contentC;
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

  @Override
  public SorterMcsItems clone() {
    return new SorterMcsItems(this);
  }

  @Override
  public String toString() {
    return this.id + ", " + this.customerItemBo;
  }
}
