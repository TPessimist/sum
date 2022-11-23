package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerItemGradeManu {

  private String customerItemBo;

  private String gradeId;

  private BigDecimal dieQty;

  private String goodBad;

  private String batchFlag;

  private String updatedUser;

  private Date updatedTime;


  public CustomerItemGradeManu() {
  }

  public CustomerItemGradeManu(CustomerItemGradeManu data) {
    this.customerItemBo = data.customerItemBo;
    this.gradeId = data.gradeId;
    this.dieQty = data.dieQty;
    this.goodBad = data.goodBad;
    this.batchFlag = data.batchFlag;
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
    return dieQty.intValue();
  }

  public void setDieQty(BigDecimal dieQty) {
    this.dieQty = dieQty;
  }

  public String getGoodBad() {
    return goodBad;
  }

  public void setGoodBad(String goodBad) {
    this.goodBad = goodBad;
  }

  public String getBatchFlag() {
    return batchFlag;
  }

  public void setBatchFlag(String batchFlag) {
    this.batchFlag = batchFlag;
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
  public CustomerItemGradeManu clone() {
    return new CustomerItemGradeManu(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.gradeId;
  }
}
