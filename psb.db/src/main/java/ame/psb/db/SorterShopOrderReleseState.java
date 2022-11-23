package ame.psb.db;

import java.util.Date;

public class SorterShopOrderReleseState {

  private String shopOrder;

  private String job;

  private String type;

  private String state;

  private String message;

  private String spareValue;

  private String spareValue2;

  private String updateUser;

  private Date updateTime;


  public SorterShopOrderReleseState() {
  }

  public SorterShopOrderReleseState(SorterShopOrderReleseState data) {
    this.shopOrder = data.shopOrder;
    this.job = data.job;
    this.type = data.type;
    this.state = data.state;
    this.message = data.message;
    this.spareValue = data.spareValue;
    this.spareValue2 = data.spareValue2;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getSpareValue() {
    return spareValue;
  }

  public void setSpareValue(String spareValue) {
    this.spareValue = spareValue;
  }

  public String getSpareValue2() {
    return spareValue2;
  }

  public void setSpareValue2(String spareValue2) {
    this.spareValue2 = spareValue2;
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

  @Override
  public SorterShopOrderReleseState clone() {
    return new SorterShopOrderReleseState(this);
  }

  @Override
  public String toString() {
    return this.shopOrder;
  }
}
