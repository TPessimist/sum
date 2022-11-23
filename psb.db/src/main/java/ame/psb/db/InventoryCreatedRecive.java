package ame.psb.db;

import java.util.Date;

public class InventoryCreatedRecive {

  private String item;

  private String seq;

  private String job;

  private String type;

  private String state;

  private String message;

  private String qty;

  private String prdDate;

  private String effDate;

  private String spareValue;

  private String spareValue2;

  private String spareValue3;

  private String updateUser;

  private Date updateTime;


  public InventoryCreatedRecive() {
  }

  public InventoryCreatedRecive(InventoryCreatedRecive data) {
    this.item = data.item;
    this.seq = data.seq;
    this.job = data.job;
    this.type = data.type;
    this.state = data.state;
    this.message = data.message;
    this.qty = data.qty;
    this.prdDate = data.prdDate;
    this.effDate = data.effDate;
    this.spareValue = data.spareValue;
    this.spareValue2 = data.spareValue2;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
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

  public String getQty() {
    return qty;
  }

  public void setQty(String qty) {
    this.qty = qty;
  }

  public String getPrdDate() {
    return prdDate;
  }

  public void setPrdDate(String prdDate) {
    this.prdDate = prdDate;
  }

  public String getEffDate() {
    return effDate;
  }

  public void setEffDate(String effDate) {
    this.effDate = effDate;
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

  public String getSpareValue3() {
    return spareValue3;
  }

  public void setSpareValue3(String spareValue3) {
    this.spareValue3 = spareValue3;
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
  public InventoryCreatedRecive clone() {
    return new InventoryCreatedRecive(this);
  }

  @Override
  public String toString() {
    return this.item + ", " + this.seq;
  }
}
