package ame.me.db;

import java.util.Date;

public class ZdFTLocatocationData {

  private String shopOrderBo;

  private String shopOrderName;

  private String locationData;

  private String locationState;

  private String custom1;

  private String custom2;

  private String updatedUser;

  private Date updatedTime;

  public ZdFTLocatocationData() {
  }

  public ZdFTLocatocationData(ZdFTLocatocationData data) {
    this.shopOrderBo = data.shopOrderBo;
    this.shopOrderName = data.shopOrderName;
    this.locationData = data.locationData;
    this.locationState = data.locationState;
    this.custom1 = data.custom1;
    this.custom2 = data.custom2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
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

  public String getLocationData() {
    return locationData;
  }

  public void setLocationData(String locationData) {
    this.locationData = locationData;
  }

  public String getLocationState() {
    return locationState;
  }

  public void setLocationState(String locationState) {
    this.locationState = locationState;
  }

  public String getCustom1() {
    return custom1;
  }

  public void setCustom1(String custom1) {
    this.custom1 = custom1;
  }

  public String getCustom2() {
    return custom2;
  }

  public void setCustom2(String custom2) {
    this.custom2 = custom2;
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
  public ZdFTLocatocationData clone() {
    return new ZdFTLocatocationData(this);
  }

  @Override
  public String toString() {
    return this.shopOrderBo + ", " + this.locationData;
  }
}
