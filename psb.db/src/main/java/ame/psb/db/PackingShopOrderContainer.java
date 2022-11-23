package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class PackingShopOrderContainer {

  private String dnNum;

  private String shopOrder;

  private String boxId;

  private String itemName;

  private BigDecimal dnQty;

  private BigDecimal shopOrderQty;

  private BigDecimal containerQty;

  private String containerName;

  private String sapOrder;

  private String sapItemName;

  private String custId;

  private String sapCustCode;

  private String creator;

  private String itemGroupName;

  private String deptno;

  private String werks;

  private String lotType;

  private String routeVersion;

  private Date planStartDate;

  private Date planEndDate;

  private Date erpCreateDate;

  private String releaseState;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public PackingShopOrderContainer() {
  }

  public PackingShopOrderContainer(PackingShopOrderContainer data) {
    this.dnNum = data.dnNum;
    this.shopOrder = data.shopOrder;
    this.boxId = data.boxId;
    this.itemName = data.itemName;
    this.dnQty = data.dnQty;
    this.shopOrderQty = data.shopOrderQty;
    this.containerQty = data.containerQty;
    this.containerName = data.containerName;
    this.sapOrder = data.sapOrder;
    this.sapItemName = data.sapItemName;
    this.custId = data.custId;
    this.sapCustCode = data.sapCustCode;
    this.creator = data.creator;
    this.itemGroupName = data.itemGroupName;
    this.deptno = data.deptno;
    this.werks = data.werks;
    this.lotType = data.lotType;
    this.routeVersion = data.routeVersion;
    this.planStartDate = data.planStartDate;
    this.planEndDate = data.planEndDate;
    this.erpCreateDate = data.erpCreateDate;
    this.releaseState = data.releaseState;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getDnNum() {
    return dnNum;
  }

  public void setDnNum(String dnNum) {
    this.dnNum = dnNum;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getBoxId() {
    return boxId;
  }

  public void setBoxId(String boxId) {
    this.boxId = boxId;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public BigDecimal getDnQty() {
    return dnQty;
  }

  public void setDnQty(BigDecimal dnQty) {
    this.dnQty = dnQty;
  }

  public BigDecimal getShopOrderQty() {
    return shopOrderQty;
  }

  public void setShopOrderQty(BigDecimal shopOrderQty) {
    this.shopOrderQty = shopOrderQty;
  }

  public BigDecimal getContainerQty() {
    return containerQty;
  }

  public void setContainerQty(BigDecimal containerQty) {
    this.containerQty = containerQty;
  }

  public String getContainerName() {
    return containerName;
  }

  public void setContainerName(String containerName) {
    this.containerName = containerName;
  }

  public String getSapOrder() {
    return sapOrder;
  }

  public void setSapOrder(String sapOrder) {
    this.sapOrder = sapOrder;
  }

  public String getSapItemName() {
    return sapItemName;
  }

  public void setSapItemName(String sapItemName) {
    this.sapItemName = sapItemName;
  }

  public String getCustId() {
    return custId;
  }

  public void setCustId(String custId) {
    this.custId = custId;
  }

  public String getSapCustCode() {
    return sapCustCode;
  }

  public void setSapCustCode(String sapCustCode) {
    this.sapCustCode = sapCustCode;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public String getItemGroupName() {
    return itemGroupName;
  }

  public void setItemGroupName(String itemGroupName) {
    this.itemGroupName = itemGroupName;
  }

  public String getDeptno() {
    return deptno;
  }

  public void setDeptno(String deptno) {
    this.deptno = deptno;
  }

  public String getWerks() {
    return werks;
  }

  public void setWerks(String werks) {
    this.werks = werks;
  }

  public String getLotType() {
    return lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  public String getRouteVersion() {
    return routeVersion;
  }

  public void setRouteVersion(String routeVersion) {
    this.routeVersion = routeVersion;
  }

  public Date getPlanStartDate() {
    return planStartDate;
  }

  public void setPlanStartDate(Date planStartDate) {
    this.planStartDate = planStartDate;
  }

  public Date getPlanEndDate() {
    return planEndDate;
  }

  public void setPlanEndDate(Date planEndDate) {
    this.planEndDate = planEndDate;
  }

  public Date getErpCreateDate() {
    return erpCreateDate;
  }

  public void setErpCreateDate(Date erpCreateDate) {
    this.erpCreateDate = erpCreateDate;
  }

  public String getReleaseState() {
    return releaseState;
  }

  public void setReleaseState(String releaseState) {
    this.releaseState = releaseState;
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
  public PackingShopOrderContainer clone() {
    return new PackingShopOrderContainer(this);
  }

  @Override
  public String toString() {
    return this.dnNum + ", " + this.shopOrder + ", " + this.boxId;
  }
}
