package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ZrCpTestTime {

  private String customerItemBo;

  private String operationBo;

  private Date dateTime;

  private BigDecimal costTime;

  private String shopOrder;

  private String sfcName;

  private String testerProgram;

  private String tester;

  private String deviceName;

  private String flag;

  private String cdpStatus;

  private String updatedUser;


  public ZrCpTestTime() {
  }

  public ZrCpTestTime(ZrCpTestTime data) {
    this.customerItemBo = data.customerItemBo;
    this.operationBo = data.operationBo;
    this.dateTime = data.dateTime;
    this.costTime = data.costTime;
    this.shopOrder = data.shopOrder;
    this.sfcName = data.sfcName;
    this.testerProgram = data.testerProgram;
    this.tester = data.tester;
    this.deviceName = data.deviceName;
    this.flag = data.flag;
    this.cdpStatus = data.cdpStatus;
    this.updatedUser = data.updatedUser;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public BigDecimal getCostTime() {
    return costTime;
  }

  public void setCostTime(BigDecimal costTime) {
    this.costTime = costTime;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getTesterProgram() {
    return testerProgram;
  }

  public void setTesterProgram(String testerProgram) {
    this.testerProgram = testerProgram;
  }

  public String getTester() {
    return tester;
  }

  public void setTester(String tester) {
    this.tester = tester;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getCdpStatus() {
    return cdpStatus;
  }

  public void setCdpStatus(String cdpStatus) {
    this.cdpStatus = cdpStatus;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  @Override
  public ZrCpTestTime clone() {
    return new ZrCpTestTime(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.operationBo + ", " + this.dateTime;
  }
}
