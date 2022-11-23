package ame.psb.db;

import java.util.Date;

public class Picture68GenerateData {

  private String customerItemBo;

  private String customerItemsetBo;

  private String sfcBo;

  private String sourceCustomerItemBo;

  private String sourceFilePath;

  private String destinationFilePath;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public Picture68GenerateData() {
  }

  public Picture68GenerateData(Picture68GenerateData data) {
    this.customerItemBo = data.customerItemBo;
    this.customerItemsetBo = data.customerItemsetBo;
    this.sfcBo = data.sfcBo;
    this.sourceCustomerItemBo = data.sourceCustomerItemBo;
    this.sourceFilePath = data.sourceFilePath;
    this.destinationFilePath = data.destinationFilePath;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getCustomerItemsetBo() {
    return customerItemsetBo;
  }

  public void setCustomerItemsetBo(String customerItemsetBo) {
    this.customerItemsetBo = customerItemsetBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSourceCustomerItemBo() {
    return sourceCustomerItemBo;
  }

  public void setSourceCustomerItemBo(String sourceCustomerItemBo) {
    this.sourceCustomerItemBo = sourceCustomerItemBo;
  }

  public String getSourceFilePath() {
    return sourceFilePath;
  }

  public void setSourceFilePath(String sourceFilePath) {
    this.sourceFilePath = sourceFilePath;
  }

  public String getDestinationFilePath() {
    return destinationFilePath;
  }

  public void setDestinationFilePath(String destinationFilePath) {
    this.destinationFilePath = destinationFilePath;
  }

  public String getReversedField1() {
    return reversedField1;
  }

  public void setReversedField1(String reversedField1) {
    this.reversedField1 = reversedField1;
  }

  public String getReversedField2() {
    return reversedField2;
  }

  public void setReversedField2(String reversedField2) {
    this.reversedField2 = reversedField2;
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

  @Override
  public Picture68GenerateData clone() {
    return new Picture68GenerateData(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo;
  }
}
