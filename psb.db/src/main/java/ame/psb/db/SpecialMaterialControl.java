package ame.psb.db;

import java.util.Date;

public class SpecialMaterialControl {

  private String id;

  private String resourceBo;

  private String itemBo;

  private int waferCount;

  private int waferCountResult;

  private int sfcCount;

  private int sfcCountResult;

  private int minutes;

  private int minutesResult;

  private Date beginTime;

  private Date endTime;

  private String state;

  private String updatedUser;

  private Date updatedTime;

  private String dummyShopOrderBo;

  private String reverseField1;

  private String reverseField2;


  public SpecialMaterialControl() {
  }

  public SpecialMaterialControl(SpecialMaterialControl data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.itemBo = data.itemBo;
    this.waferCount = data.waferCount;
    this.waferCountResult = data.waferCountResult;
    this.sfcCount = data.sfcCount;
    this.sfcCountResult = data.sfcCountResult;
    this.minutes = data.minutes;
    this.minutesResult = data.minutesResult;
    this.beginTime = data.beginTime;
    this.endTime = data.endTime;
    this.state = data.state;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.dummyShopOrderBo = data.dummyShopOrderBo;
    this.reverseField1 = data.reverseField1;
    this.reverseField2 = data.reverseField2;
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

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public int getWaferCount() {
    return waferCount;
  }

  public void setWaferCount(int waferCount) {
    this.waferCount = waferCount;
  }

  public int getWaferCountResult() {
    return waferCountResult;
  }

  public void setWaferCountResult(int waferCountResult) {
    this.waferCountResult = waferCountResult;
  }

  public int getSfcCount() {
    return sfcCount;
  }

  public void setSfcCount(int sfcCount) {
    this.sfcCount = sfcCount;
  }

  public int getSfcCountResult() {
    return sfcCountResult;
  }

  public void setSfcCountResult(int sfcCountResult) {
    this.sfcCountResult = sfcCountResult;
  }

  public int getMinutes() {
    return minutes;
  }

  public void setMinutes(int minutes) {
    this.minutes = minutes;
  }

  public int getMinutesResult() {
    return minutesResult;
  }

  public void setMinutesResult(int minutesResult) {
    this.minutesResult = minutesResult;
  }

  public Date getBeginTime() {
    return beginTime;
  }

  public void setBeginTime(Date beginTime) {
    this.beginTime = beginTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
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

  public String getDummyShopOrderBo() {
    return dummyShopOrderBo;
  }

  public void setDummyShopOrderBo(String dummyShopOrderBo) {
    this.dummyShopOrderBo = dummyShopOrderBo;
  }

  public String getReverseField1() {
    return reverseField1;
  }

  public void setReverseField1(String reverseField1) {
    this.reverseField1 = reverseField1;
  }

  public String getReverseField2() {
    return reverseField2;
  }

  public void setReverseField2(String reverseField2) {
    this.reverseField2 = reverseField2;
  }

  @Override
  public SpecialMaterialControl clone() {
    return new SpecialMaterialControl(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
