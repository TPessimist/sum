package ame.psb.db;

import java.util.Date;

public class ContainerNewLot {

  private String containerBo;

  private String shopOrder;

  private String lotNo;

  private String newLotNo;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public ContainerNewLot() {
  }

  public ContainerNewLot(ContainerNewLot data) {
    this.containerBo = data.containerBo;
    this.shopOrder = data.shopOrder;
    this.lotNo = data.lotNo;
    this.newLotNo = data.newLotNo;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public ContainerNewLot clone() {
    return new ContainerNewLot(this);
  }

  @Override
  public String toString() {
    return this.containerBo + ", " + this.shopOrder;
  }

  public String getContainerBo() {
    return containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getLotNo() {
    return lotNo;
  }

  public void setLotNo(String lotNo) {
    this.lotNo = lotNo;
  }

  public String getNewLotNo() {
    return newLotNo;
  }

  public void setNewLotNo(String newLotNo) {
    this.newLotNo = newLotNo;
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
}
