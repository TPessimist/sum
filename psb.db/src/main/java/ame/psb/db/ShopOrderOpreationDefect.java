package ame.psb.db;

import java.util.Date;

public class ShopOrderOpreationDefect {

  private String shopOrderBo;

  private String operationBo;

  private String ncCodeBo;

  private int ncValue;

  private String updatedUser;

  private Date updatedTime;


  public ShopOrderOpreationDefect() {
  }

  public ShopOrderOpreationDefect(ShopOrderOpreationDefect data) {
    this.shopOrderBo = data.shopOrderBo;
    this.operationBo = data.operationBo;
    this.ncCodeBo = data.ncCodeBo;
    this.ncValue = data.ncValue;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getNcCodeBo() {
    return ncCodeBo;
  }

  public void setNcCodeBo(String ncCodeBo) {
    this.ncCodeBo = ncCodeBo;
  }

  public int getNcValue() {
    return ncValue;
  }

  public void setNcValue(int ncValue) {
    this.ncValue = ncValue;
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
  public ShopOrderOpreationDefect clone() {
    return new ShopOrderOpreationDefect(this);
  }

  @Override
  public String toString() {
    return this.shopOrderBo + ", " + this.operationBo + ", " + this.ncCodeBo;
  }
}
