package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class ViewPackageDevice {

  private String customerBo;

  private String customer;

  private String customerName;

  private String packageBo;

  private String packageName;

  private String packageDesc;

  private String deviceBo;

  private String deviceName;

  private String deviceDesc;

  private String crFactor;

  private String binCodeList;

  public ViewPackageDevice() {
  }

  public ViewPackageDevice(ViewPackageDevice data) {
    this.customerBo = data.customerBo;
    this.customer = data.customer;
    this.customerName = data.customerName;
    this.packageBo = data.packageBo;
    this.packageName = data.packageName;
    this.packageDesc = data.packageDesc;
    this.deviceBo = data.deviceBo;
    this.deviceName = data.deviceName;
    this.deviceDesc = data.deviceDesc;
    this.crFactor = data.crFactor;
    this.binCodeList = data.binCodeList;
  }

  public String getCustomerBo() {
    return this.customerBo;
  }

  public void setCustomerBo(String customerBo) {
    this.customerBo = customerBo;
  }

  public String getCustomer() {
    return this.customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getPackageBo() {
    return this.packageBo;
  }

  public void setPackageBo(String packageBo) {
    this.packageBo = packageBo;
  }

  public String getPackageName() {
    return this.packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getPackageDesc() {
    return this.packageDesc;
  }

  public void setPackageDesc(String packageDesc) {
    this.packageDesc = packageDesc;
  }

  public String getDeviceBo() {
    return this.deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getDeviceName() {
    return this.deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getDeviceDesc() {
    return this.deviceDesc;
  }

  public void setDeviceDesc(String deviceDesc) {
    this.deviceDesc = deviceDesc;
  }

  public String getCrFactor() {
    return this.crFactor;
  }

  public void setCrFactor(String crFactor) {
    this.crFactor = crFactor;
  }

  public String getBinCodeList() {
    return this.binCodeList;
  }

  public void setBinCodeList(String binCodeList) {
    this.binCodeList = binCodeList;
  }

  @Override
  public String toString() {
    return "P:" + this.packageBo + ", D:" + this.deviceBo;
  }

}
