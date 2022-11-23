package ame.psb.db;

import java.util.Date;

public class BySfcInkSfcItem {

  private String id;

  private String sfcName;

  private String mapRuleName;

  private String inkRuleName;

  private String bySfcInk;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public BySfcInkSfcItem() {
  }

  public BySfcInkSfcItem(BySfcInkSfcItem data) {
    this.id = data.id;
    this.sfcName = data.sfcName;
    this.mapRuleName = data.mapRuleName;
    this.inkRuleName = data.inkRuleName;
    this.bySfcInk = data.bySfcInk;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getMapRuleName() {
    return mapRuleName;
  }

  public void setMapRuleName(String mapRuleName) {
    this.mapRuleName = mapRuleName;
  }

  public String getInkRuleName() {
    return inkRuleName;
  }

  public void setInkRuleName(String inkRuleName) {
    this.inkRuleName = inkRuleName;
  }

  public String getBySfcInk() {
    return bySfcInk;
  }

  public void setBySfcInk(String bySfcInk) {
    this.bySfcInk = bySfcInk;
  }

  public String getReversedField1() {
    return reversedField1;
  }

  public void setReversedField1(String reversedField1) {
    this.reversedField1 = reversedField1;
  }

  public String getReversedField2() {
    return reversedField2;
  }

  public void setReversedField2(String reversedField2) {
    this.reversedField2 = reversedField2;
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
  public BySfcInkSfcItem clone() {
    return new BySfcInkSfcItem(this);
  }

  @Override
  public String toString() {
    return this.id + ", " + this.mapRuleName + ", " + this.inkRuleName;
  }
}
