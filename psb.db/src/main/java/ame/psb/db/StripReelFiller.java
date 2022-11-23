package ame.psb.db;

import java.util.Date;

public class StripReelFiller {

  private String customerItemBo;

  private String fillerCustomerItemBo;

  private String gradeId;

  private int dieQty;

  private String goodBad;

  private String updatedUser;

  private Date updatedTime;


  public StripReelFiller() {
  }

  public StripReelFiller(StripReelFiller data) {
    this.customerItemBo = data.customerItemBo;
    this.fillerCustomerItemBo = data.fillerCustomerItemBo;
    this.gradeId = data.gradeId;
    this.dieQty = data.dieQty;
    this.goodBad = data.goodBad;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public StripReelFiller clone() {
    return new StripReelFiller(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.fillerCustomerItemBo + ", " + this.gradeId;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getFillerCustomerItemBo() {
    return this.fillerCustomerItemBo;
  }

  public void setFillerCustomerItemBo(String fillerCustomerItemBo) {
    this.fillerCustomerItemBo = fillerCustomerItemBo;
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
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
