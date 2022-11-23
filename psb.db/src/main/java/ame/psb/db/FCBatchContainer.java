package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class FCBatchContainer {

  private String shopOrderBo;

  private String batchId;

  private String containerName;

  private String sfcBo;

  private String customerItemBo;

  private String grade;

  private BigDecimal qty;

  private BigDecimal grossQty;

  private String updatedUser;

  private Date updatedTime;


  public FCBatchContainer() {
  }

  public FCBatchContainer(FCBatchContainer data) {
    this.shopOrderBo = data.shopOrderBo;
    this.batchId = data.batchId;
    this.containerName = data.containerName;
    this.sfcBo = data.sfcBo;
    this.customerItemBo = data.customerItemBo;
    this.grade = data.grade;
    this.qty = data.qty;
    this.grossQty = data.grossQty;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getContainerName() {
    return containerName;
  }

  public void setContainerName(String containerName) {
    this.containerName = containerName;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public BigDecimal getGrossQty() {
    return grossQty;
  }

  public void setGrossQty(BigDecimal grossQty) {
    this.grossQty = grossQty;
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
  public FCBatchContainer clone() {
    return new FCBatchContainer(this);
  }

  @Override
  public String toString() {
    return this.batchId + ", " + this.containerName + ", " + this.sfcBo + ", " + this.customerItemBo
        + ", " + this.grade;
  }
}
