package ame.psb.db;

import java.util.Date;

public class GoldenWaferResult {

  private String id;

  private String resourceBo;

  private String customerItemsetName;

  private String goldenWafer;

  private String mapResult;

  private String updateUser;

  private Date updateTime;

  private String reserve1;

  private String reserve2;

  private Date effectiveTime; //有效时间

  private String normalCustomerItemsetName; //正常客户

  public GoldenWaferResult() {
  }

  public GoldenWaferResult(GoldenWaferResult data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.customerItemsetName = data.customerItemsetName;
    this.goldenWafer = data.goldenWafer;
    this.mapResult = data.mapResult;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.reserve1 = data.reserve1;
    this.reserve2 = data.reserve2;
    this.effectiveTime = data.effectiveTime;
    this.normalCustomerItemsetName = data.normalCustomerItemsetName;
  }

  public Date getEffectiveTime() {
    return effectiveTime;
  }

  public void setEffectiveTime(Date effectiveTime) {
    this.effectiveTime = effectiveTime;
  }

  public String getNormalCustomerItemsetName() {
    return normalCustomerItemsetName;
  }

  public void setNormalCustomerItemsetName(String normalCustomerItemsetName) {
    this.normalCustomerItemsetName = normalCustomerItemsetName;
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

  public String getCustomerItemsetName() {
    return customerItemsetName;
  }

  public void setCustomerItemsetName(String customerItemsetName) {
    this.customerItemsetName = customerItemsetName;
  }

  public String getGoldenWafer() {
    return goldenWafer;
  }

  public void setGoldenWafer(String goldenWafer) {
    this.goldenWafer = goldenWafer;
  }

  public String getMapResult() {
    return mapResult;
  }

  public void setMapResult(String mapResult) {
    this.mapResult = mapResult;
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
  public GoldenWaferResult clone() {
    return new GoldenWaferResult(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
