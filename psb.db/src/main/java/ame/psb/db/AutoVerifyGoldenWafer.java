package ame.psb.db;

import java.util.Date;

public class AutoVerifyGoldenWafer {

  private String id;

  private String resourceBo;

  private String goldenWafer;

  private String operationBo;

  private String shopOrderBo;

  private String shopOrderName;

  private String deviceBo;

  private String deviceName;

  private String stateName;

  private String updateUser;

  private Date updateTime;

  private String reserve1;

  private String reserve2;


  public AutoVerifyGoldenWafer() {
  }

  public AutoVerifyGoldenWafer(AutoVerifyGoldenWafer data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.goldenWafer = data.goldenWafer;
    this.operationBo = data.operationBo;
    this.shopOrderBo = data.shopOrderBo;
    this.shopOrderName = data.shopOrderName;
    this.deviceBo = data.deviceBo;
    this.deviceName = data.deviceName;
    this.stateName = data.stateName;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.reserve1 = data.reserve1;
    this.reserve2 = data.reserve2;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getGoldenWafer() {
    return goldenWafer;
  }

  public void setGoldenWafer(String goldenWafer) {
    this.goldenWafer = goldenWafer;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getShopOrderName() {
    return shopOrderName;
  }

  public void setShopOrderName(String shopOrderName) {
    this.shopOrderName = shopOrderName;
  }

  public String getDeviceBo() {
    return deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getReserve1() {
    return reserve1;
  }

  public void setReserve1(String reserve1) {
    this.reserve1 = reserve1;
  }

  public String getReserve2() {
    return reserve2;
  }

  public void setReserve2(String reserve2) {
    this.reserve2 = reserve2;
  }

  @Override
  public AutoVerifyGoldenWafer clone() {
    return new AutoVerifyGoldenWafer(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
