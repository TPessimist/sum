package ame.psb.db;

import java.util.Date;

public class SfcItemGrade {

  private String sfcBo;

  private String customerItemBo;

  private String gradeId;

  private int dieQty;

  private String goodBad;

  private String updatedUser;

  private Date updatedTime;

  public SfcItemGrade() {
  }

  public SfcItemGrade(String sfcBo, String customerItemBo, String gradeId, int dieQty,
      String goodBad) {
    this.sfcBo = sfcBo;
    this.customerItemBo = customerItemBo;
    this.gradeId = gradeId;
    this.dieQty = dieQty;
    this.goodBad = goodBad;
  }

  public SfcItemGrade(SfcItemGrade data) {
    this.sfcBo = data.sfcBo;
    this.customerItemBo = data.customerItemBo;
    this.gradeId = data.gradeId;
    this.dieQty = data.dieQty;
    this.goodBad = data.goodBad;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getGradeId() {
    return this.gradeId;
  }

  public void setGradeId(String gradeId) {
    this.gradeId = gradeId;
  }

  public int getDieQty() {
    return this.dieQty;
  }

  public void setDieQty(int dieQty) {
    this.dieQty = dieQty;
  }

  public String getGoodBad() {
    return this.goodBad;
  }

  public void setGoodBad(String goodBad) {
    this.goodBad = goodBad;
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
  public String toString() {
    return this.sfcBo + ", " + this.customerItemBo + ", " + this.gradeId + "=" + this.dieQty;
  }
}
