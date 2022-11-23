package ame.psb.db;

import java.util.Date;

public class FttestSplitContainer {

  private String id;

  private String shopOrderBo;

  private String sfcBo;

  private String containerBo;

  private String markingCode;

  private String reverseField1;

  private String reverseField2;

  private String updateUser;

  private Date updateTime;

  public FttestSplitContainer() {
  }

  public FttestSplitContainer(FttestSplitContainer data) {
    this.id = data.id;
    this.shopOrderBo = data.shopOrderBo;
    this.sfcBo = data.sfcBo;
    this.containerBo = data.containerBo;
    this.markingCode = data.markingCode;
    this.reverseField1 = data.reverseField1;
    this.reverseField2 = data.reverseField2;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getContainerBo() {
    return containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getMarkingCode() {
    return markingCode;
  }

  public void setMarkingCode(String markingCode) {
    this.markingCode = markingCode;
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
  public FttestSplitContainer clone() {
    return new FttestSplitContainer(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
