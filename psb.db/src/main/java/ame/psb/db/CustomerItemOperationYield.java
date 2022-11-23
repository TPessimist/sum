package ame.psb.db;

import java.math.BigDecimal;

public class CustomerItemOperationYield {

  private String customerItemBo;

  private String operationBo;

  private BigDecimal yield;

  private int dieQty;

  private int badQty;

  private int goodQty;


  public CustomerItemOperationYield() {
  }

  public CustomerItemOperationYield(CustomerItemOperationYield data) {
    this.customerItemBo = data.customerItemBo;
    this.operationBo = data.operationBo;
    this.yield = data.yield;
    this.dieQty = data.dieQty;
    this.badQty = data.badQty;
    this.goodQty = data.goodQty;
  }


  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public BigDecimal getYield() {
    return yield;
  }

  public void setYield(BigDecimal yield) {
    this.yield = yield;
  }


  public int getDieQty() {
    return dieQty;
  }

  public void setDieQty(int dieQty) {
    this.dieQty = dieQty;
  }

  public int getBadQty() {
    return badQty;
  }

  public void setBadQty(int badQty) {
    this.badQty = badQty;
  }

  public int getGoodQty() {
    return goodQty;
  }

  public void setGoodQty(int goodQty) {
    this.goodQty = goodQty;
  }

  @Override
  public CustomerItemOperationYield clone() {
    return new CustomerItemOperationYield(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.operationBo;
  }
}
