package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class FtTailStorage {

  private String shopOrderBo;

  private String sfcBo;

  private BigDecimal tailQty;

  private String tailLocation;

  private String tailCustomerDevice;

  private String tailState;

  private String reversedField1;

  private String reversedField2;

  private Date updatedTime;

  private String updatedUser;


  public FtTailStorage() {
  }

  public FtTailStorage(FtTailStorage data) {
    this.shopOrderBo = data.shopOrderBo;
    this.sfcBo = data.sfcBo;
    this.tailQty = data.tailQty;
    this.tailLocation = data.tailLocation;
    this.tailCustomerDevice = data.tailCustomerDevice;
    this.tailState = data.tailState;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedTime = data.updatedTime;
    this.updatedUser = data.updatedUser;
  }


  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public BigDecimal getTailQty() {
    return tailQty;
  }

  public void setTailQty(BigDecimal tailQty) {
    this.tailQty = tailQty;
  }

  public String getTailLocation() {
    return tailLocation;
  }

  public void setTailLocation(String tailLocation) {
    this.tailLocation = tailLocation;
  }

  public String getTailCustomerDevice() {
    return tailCustomerDevice;
  }

  public void setTailCustomerDevice(String tailCustomerDevice) {
    this.tailCustomerDevice = tailCustomerDevice;
  }

  public String getTailState() {
    return tailState;
  }

  public void setTailState(String tailState) {
    this.tailState = tailState;
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

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  @Override
  public FtTailStorage clone() {
    return new FtTailStorage(this);
  }

  @Override
  public String toString() {
    return this.shopOrderBo;
  }
}
