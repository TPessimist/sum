package ame.psb.db;

import java.util.Date;

public class Ts81MarkingCodeRecord {

  private String uuid;

  private String shopOrder;

  private String markingCode;

  private String updatedUser;

  private Date updatedTime;


  public Ts81MarkingCodeRecord() {
  }

  public Ts81MarkingCodeRecord(Ts81MarkingCodeRecord data) {
    this.uuid = data.uuid;
    this.shopOrder = data.shopOrder;
    this.markingCode = data.markingCode;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public Ts81MarkingCodeRecord clone() {
    return new Ts81MarkingCodeRecord(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getMarkingCode() {
    return markingCode;
  }

  public void setMarkingCode(String markingCode) {
    this.markingCode = markingCode;
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
