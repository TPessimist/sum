package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class HandOverSfc {

  private String id;

  private String sfcBo;

  private String stateName;

  private String perviousStateName;

  private String flag;

  private String updatedUser;

  private Date updatedTime;

  private int itemQty;

  private String waferList;

  private String customerItemSet;

  private String operation;

  private int nums;

  private String computerIp;

  public HandOverSfc() {
    this.id = UUID.randomUUID().toString();
  }

  public HandOverSfc(HandOverSfc data) {
    this.id = data.id;
    this.sfcBo = data.sfcBo;
    this.stateName = data.stateName;
    this.perviousStateName = data.perviousStateName;
    this.flag = data.flag;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.operation = data.operation;
    this.nums = data.nums;
    this.computerIp = data.computerIp;
  }

  @Override
  public HandOverSfc clone() {
    return new HandOverSfc(this);
  }

  @Override
  public String toString() {
    return this.sfcBo;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getPerviousStateName() {
    return perviousStateName;
  }

  public void setPerviousStateName(String perviousStateName) {
    this.perviousStateName = perviousStateName;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
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

  public int getItemQty() {
    return itemQty;
  }

  public void setItemQty(int itemQty) {
    this.itemQty = itemQty;
  }

  public String getWaferList() {
    return waferList;
  }

  public void setWaferList(String waferList) {
    this.waferList = waferList;
  }

  public String getCustomerItemSet() {
    return customerItemSet;
  }

  public void setCustomerItemSet(String customerItemSet) {
    this.customerItemSet = customerItemSet;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public int getNums() {
    return nums;
  }

  public void setNums(int nums) {
    this.nums = nums;
  }

  public String getComputerIp() {
    return computerIp;
  }

  public void setComputerIp(String computerIp) {
    this.computerIp = computerIp;
  }
}
