package ame.psb.db;


import java.util.Date;

public class ZrCustomerItemGradeMap {

  private String customerItemBo;

  private String gradeId;

  private int dieQty;
  private String goodBad;
  private String updatedUser;
  private Date updatedTime;

  public ZrCustomerItemGradeMap() {
  }

  public ZrCustomerItemGradeMap(ZrCustomerItemGradeMap data) {
    this.customerItemBo = data.customerItemBo;
    this.gradeId = data.gradeId;
    this.dieQty = data.dieQty;
    this.goodBad = data.goodBad;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getGradeId() {
    return gradeId;
  }

  public void setGradeId(String gradeId) {
    this.gradeId = gradeId;
  }

  public int getDieQty() {
    return dieQty;
  }

  public void setDieQty(int dieQty) {
    this.dieQty = dieQty;
  }

  public String getGoodBad() {
    return goodBad;
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
  public ZrCustomerItemGradeMap clone() {
    return new ZrCustomerItemGradeMap(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.gradeId;
  }
}
