package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class Picture68DataSource {

  private String customerItemBo;

  private String customerItemsetBo;

  private BigDecimal frequency;

  private String filePath;

  private String deviceName;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public Picture68DataSource() {
  }

  public Picture68DataSource(Picture68DataSource data) {
    this.customerItemBo = data.customerItemBo;
    this.customerItemsetBo = data.customerItemsetBo;
    this.frequency = data.frequency;
    this.filePath = data.filePath;
    this.deviceName = data.deviceName;
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

  public BigDecimal getFrequency() {
    return frequency;
  }

  public void setFrequency(BigDecimal frequency) {
    this.frequency = frequency;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
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
  public Picture68DataSource clone() {
    return new Picture68DataSource(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo;
  }
}
