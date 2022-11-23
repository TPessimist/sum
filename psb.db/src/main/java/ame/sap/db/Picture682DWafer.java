package ame.sap.db;

import java.math.BigDecimal;
import java.util.Date;

public class Picture682DWafer {

  private String itemGroupBo;

  private String customerItemBo;

  private String sfcBo;

  private BigDecimal waferCount;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public Picture682DWafer() {
  }

  public Picture682DWafer(Picture682DWafer data) {
    this.itemGroupBo = data.itemGroupBo;
    this.customerItemBo = data.customerItemBo;
    this.sfcBo = data.sfcBo;
    this.waferCount = data.waferCount;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public BigDecimal getWaferCount() {
    return waferCount;
  }

  public void setWaferCount(BigDecimal waferCount) {
    this.waferCount = waferCount;
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
  public Picture682DWafer clone() {
    return new Picture682DWafer(this);
  }

  @Override
  public String toString() {
    return this.itemGroupBo + ", " + this.customerItemBo;
  }
}
