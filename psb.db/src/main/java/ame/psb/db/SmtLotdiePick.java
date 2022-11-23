package ame.psb.db;

import java.util.Date;

public class SmtLotdiePick {

  private String sfc;

  private String lot;

  private String device;

  private String lotType;

  private String content;

  private String value;

  private String updatedUser;

  private Date updatedTime;

  public SmtLotdiePick() {
  }

  public SmtLotdiePick(SmtLotdiePick data) {
    this.sfc = data.sfc;
    this.lot = data.lot;
    this.device = data.device;
    this.lotType = data.lotType;
    this.content = data.content;
    this.value = data.value;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getLot() {
    return lot;
  }

  public void setLot(String lot) {
    this.lot = lot;
  }

  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public String getLotType() {
    return lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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
  public SmtLotdiePick clone() {
    return new SmtLotdiePick(this);
  }

  @Override
  public String toString() {
    return this.sfc;
  }
}
