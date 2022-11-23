package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class IqcDefectResult {

  private String id;

  private String sfcBo;

  private String appearanceCategory;

  private String appearanceWaferList;

  private String appearanceResult;

  private String microCategory;

  private String microWaferList;

  private String microResult;

  private String qtyCategory;

  private BigDecimal badDieQty;

  private BigDecimal totalDieQty;

  private BigDecimal badDieYield;

  private String qtyWaferList;

  private String qtyResult;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public IqcDefectResult() {
  }

  public IqcDefectResult(IqcDefectResult data) {
    this.id = data.id;
    this.sfcBo = data.sfcBo;
    this.appearanceCategory = data.appearanceCategory;
    this.appearanceWaferList = data.appearanceWaferList;
    this.appearanceResult = data.appearanceResult;
    this.microCategory = data.microCategory;
    this.microWaferList = data.microWaferList;
    this.microResult = data.microResult;
    this.qtyCategory = data.qtyCategory;
    this.badDieQty = data.badDieQty;
    this.totalDieQty = data.totalDieQty;
    this.badDieYield = data.badDieYield;
    this.qtyWaferList = data.qtyWaferList;
    this.qtyResult = data.qtyResult;
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

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getAppearanceCategory() {
    return appearanceCategory;
  }

  public void setAppearanceCategory(String appearanceCategory) {
    this.appearanceCategory = appearanceCategory;
  }

  public String getAppearanceWaferList() {
    return appearanceWaferList;
  }

  public void setAppearanceWaferList(String appearanceWaferList) {
    this.appearanceWaferList = appearanceWaferList;
  }

  public String getAppearanceResult() {
    return appearanceResult;
  }

  public void setAppearanceResult(String appearanceResult) {
    this.appearanceResult = appearanceResult;
  }

  public String getMicroCategory() {
    return microCategory;
  }

  public void setMicroCategory(String microCategory) {
    this.microCategory = microCategory;
  }

  public String getMicroWaferList() {
    return microWaferList;
  }

  public void setMicroWaferList(String microWaferList) {
    this.microWaferList = microWaferList;
  }

  public String getMicroResult() {
    return microResult;
  }

  public void setMicroResult(String microResult) {
    this.microResult = microResult;
  }

  public String getQtyCategory() {
    return qtyCategory;
  }

  public void setQtyCategory(String qtyCategory) {
    this.qtyCategory = qtyCategory;
  }

  public BigDecimal getBadDieQty() {
    return badDieQty;
  }

  public void setBadDieQty(BigDecimal badDieQty) {
    this.badDieQty = badDieQty;
  }

  public BigDecimal getTotalDieQty() {
    return totalDieQty;
  }

  public void setTotalDieQty(BigDecimal totalDieQty) {
    this.totalDieQty = totalDieQty;
  }

  public BigDecimal getBadDieYield() {
    return badDieYield;
  }

  public void setBadDieYield(BigDecimal badDieYield) {
    this.badDieYield = badDieYield;
  }

  public String getQtyWaferList() {
    return qtyWaferList;
  }

  public void setQtyWaferList(String qtyWaferList) {
    this.qtyWaferList = qtyWaferList;
  }

  public String getQtyResult() {
    return qtyResult;
  }

  public void setQtyResult(String qtyResult) {
    this.qtyResult = qtyResult;
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
  public IqcDefectResult clone() {
    return new IqcDefectResult(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
