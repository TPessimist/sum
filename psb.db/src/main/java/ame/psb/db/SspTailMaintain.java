package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class SspTailMaintain {

  private String uuid;

  private String sfcBo;

  private String itemGroupBo;

  private String dateCode;

  private BigDecimal tailQty;

  private String stateName;

  private String secondarySfcBo;

  private BigDecimal secondaryTailQty;

  private String reversedField1;

  private String reversedField2;

  private Date updatedTime;

  private String updatedUser;


  public SspTailMaintain() {
  }

  public SspTailMaintain(SspTailMaintain data) {
    this.uuid = data.uuid;
    this.sfcBo = data.sfcBo;
    this.itemGroupBo = data.itemGroupBo;
    this.dateCode = data.dateCode;
    this.tailQty = data.tailQty;
    this.stateName = data.stateName;
    this.secondarySfcBo = data.secondarySfcBo;
    this.secondaryTailQty = data.secondaryTailQty;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedTime = data.updatedTime;
    this.updatedUser = data.updatedUser;
  }

  @Override
  public SspTailMaintain clone() {
    return new SspTailMaintain(this);
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

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getDateCode() {
    return dateCode;
  }

  public void setDateCode(String dateCode) {
    this.dateCode = dateCode;
  }

  public BigDecimal getTailQty() {
    return tailQty;
  }

  public void setTailQty(BigDecimal tailQty) {
    this.tailQty = tailQty;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getSecondarySfcBo() {
    return secondarySfcBo;
  }

  public void setSecondarySfcBo(String secondarySfcBo) {
    this.secondarySfcBo = secondarySfcBo;
  }

  public BigDecimal getSecondaryTailQty() {
    return secondaryTailQty;
  }

  public void setSecondaryTailQty(BigDecimal secondaryTailQty) {
    this.secondaryTailQty = secondaryTailQty;
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

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }
}
