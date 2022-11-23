package ame.psb.db;

import java.util.Date;

public class CustomerItemGrade {

  private String customerItemBo;

  private String gradeId;

  private int dieQty;

  private String goodBad;

  private String updatedUser;

  private Date updatedTime;


  public CustomerItemGrade() {
    this.gradeId = "G";
  }

  public CustomerItemGrade(String customerItemBo, String gradeId, int dieQty, String goodBad) {
    this.customerItemBo = customerItemBo;
    this.gradeId = gradeId;
    this.dieQty = dieQty;
    this.goodBad = goodBad;
  }

  public CustomerItemGrade(CustomerItemGrade data) {
    this.customerItemBo = data.customerItemBo;
    this.gradeId = data.gradeId;
    this.dieQty = data.dieQty;
    this.goodBad = data.goodBad;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
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
    return this.customerItemBo + ", " + this.gradeId + "=" + this.dieQty;
  }
}
