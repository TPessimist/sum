package ame.psb.db;

import java.util.Date;

public class MPSSampleControl {

  private String customerItemsetName;

  private String shopOrderName;

  private String customerFileResult;

  private String customerFileTestSite;

  private String customerFilePart;

  private String customerFileMesLot;

  private String customerFileSubLot;

  private String customerFileDc;

  private String customerFileDate;

  private String customerFileQty;

  private String customerRelTestSite;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public MPSSampleControl() {
  }

  public MPSSampleControl(MPSSampleControl data) {
    this.customerItemsetName = data.customerItemsetName;
    this.shopOrderName = data.shopOrderName;
    this.customerFileResult = data.customerFileResult;
    this.customerFileTestSite = data.customerFileTestSite;
    this.customerFilePart = data.customerFilePart;
    this.customerFileMesLot = data.customerFileMesLot;
    this.customerFileSubLot = data.customerFileSubLot;
    this.customerFileDc = data.customerFileDc;
    this.customerFileDate = data.customerFileDate;
    this.customerFileQty = data.customerFileQty;
    this.customerRelTestSite = data.customerRelTestSite;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getCustomerItemsetName() {
    return customerItemsetName;
  }

  public void setCustomerItemsetName(String customerItemsetName) {
    this.customerItemsetName = customerItemsetName;
  }

  public String getShopOrderName() {
    return shopOrderName;
  }

  public void setShopOrderName(String shopOrderName) {
    this.shopOrderName = shopOrderName;
  }

  public String getCustomerFileResult() {
    return customerFileResult;
  }

  public void setCustomerFileResult(String customerFileResult) {
    this.customerFileResult = customerFileResult;
  }

  public String getCustomerFileTestSite() {
    return customerFileTestSite;
  }

  public void setCustomerFileTestSite(String customerFileTestSite) {
    this.customerFileTestSite = customerFileTestSite;
  }

  public String getCustomerFilePart() {
    return customerFilePart;
  }

  public void setCustomerFilePart(String customerFilePart) {
    this.customerFilePart = customerFilePart;
  }

  public String getCustomerFileMesLot() {
    return customerFileMesLot;
  }

  public void setCustomerFileMesLot(String customerFileMesLot) {
    this.customerFileMesLot = customerFileMesLot;
  }

  public String getCustomerFileSubLot() {
    return customerFileSubLot;
  }

  public void setCustomerFileSubLot(String customerFileSubLot) {
    this.customerFileSubLot = customerFileSubLot;
  }

  public String getCustomerFileDc() {
    return customerFileDc;
  }

  public void setCustomerFileDc(String customerFileDc) {
    this.customerFileDc = customerFileDc;
  }

  public String getCustomerFileDate() {
    return customerFileDate;
  }

  public void setCustomerFileDate(String customerFileDate) {
    this.customerFileDate = customerFileDate;
  }

  public String getCustomerFileQty() {
    return customerFileQty;
  }

  public void setCustomerFileQty(String customerFileQty) {
    this.customerFileQty = customerFileQty;
  }

  public String getCustomerRelTestSite() {
    return customerRelTestSite;
  }

  public void setCustomerRelTestSite(String customerRelTestSite) {
    this.customerRelTestSite = customerRelTestSite;
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
  public MPSSampleControl clone() {
    return new MPSSampleControl(this);
  }

  @Override
  public String toString() {
    return this.customerItemsetName + ", " + this.shopOrderName;
  }
}
