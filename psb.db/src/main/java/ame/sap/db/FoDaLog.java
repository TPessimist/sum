package ame.sap.db;

import java.util.Date;

public class FoDaLog {

  private String sfcName;

  private String siId;

  private String waferId;

  private String waferDieQty;

  private String fileName;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public FoDaLog() {
  }

  public FoDaLog(FoDaLog data) {
    this.sfcName = data.sfcName;
    this.siId = data.siId;
    this.waferId = data.waferId;
    this.waferDieQty = data.waferDieQty;
    this.fileName = data.fileName;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getSiId() {
    return siId;
  }

  public void setSiId(String siId) {
    this.siId = siId;
  }

  public String getWaferId() {
    return waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
  }

  public String getWaferDieQty() {
    return waferDieQty;
  }

  public void setWaferDieQty(String waferDieQty) {
    this.waferDieQty = waferDieQty;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
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
  public FoDaLog clone() {
    return new FoDaLog(this);
  }

  @Override
  public String toString() {
    return this.siId + ", " + this.waferId + ", " + this.fileName;
  }
}
