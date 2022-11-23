package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerItemOperationFirstyield {

  private String customerItemBo;

  private String operationBo;

  private BigDecimal firstYield;

  private int firstGoodQty;

  private int stdfTotalQty;

  private String updatedUser;

  private Date updatedTime;


  public CustomerItemOperationFirstyield() {
  }

  public CustomerItemOperationFirstyield(CustomerItemOperationFirstyield data) {
    this.customerItemBo = data.customerItemBo;
    this.operationBo = data.operationBo;
    this.firstYield = data.firstYield;
    this.firstGoodQty = data.firstGoodQty;
    this.stdfTotalQty = data.stdfTotalQty;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
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

  public BigDecimal getFirstYield() {
    return firstYield;
  }

  public void setFirstYield(BigDecimal firstYield) {
    this.firstYield = firstYield;
  }

  public int getFirstGoodQty() {
    return firstGoodQty;
  }

  public void setFirstGoodQty(int firstGoodQty) {
    this.firstGoodQty = firstGoodQty;
  }

  public int getStdfTotalQty() {
    return stdfTotalQty;
  }

  public void setStdfTotalQty(int stdfTotalQty) {
    this.stdfTotalQty = stdfTotalQty;
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
  public CustomerItemOperationFirstyield clone() {
    return new CustomerItemOperationFirstyield(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.operationBo;
  }
}
