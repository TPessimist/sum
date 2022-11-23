package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerItemOperationFirstbin {

  private String customerItemBo;

  private String operationBo;

  private String firstBin;

  private int firstBinQty;

  private int stdfTotalQty;

  private BigDecimal firstBinYield;

  private String updatedUser;

  private Date updatedTime;


  public CustomerItemOperationFirstbin() {
  }

  public CustomerItemOperationFirstbin(CustomerItemOperationFirstbin data) {
    this.customerItemBo = data.customerItemBo;
    this.operationBo = data.operationBo;
    this.firstBin = data.firstBin;
    this.firstBinQty = data.firstBinQty;
    this.stdfTotalQty = data.stdfTotalQty;
    this.firstBinYield = data.firstBinYield;
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

  public String getFirstBin() {
    return firstBin;
  }

  public void setFirstBin(String firstBin) {
    this.firstBin = firstBin;
  }

  public int getFirstBinQty() {
    return firstBinQty;
  }

  public void setFirstBinQty(int firstBinQty) {
    this.firstBinQty = firstBinQty;
  }

  public int getStdfTotalQty() {
    return stdfTotalQty;
  }

  public void setStdfTotalQty(int stdfTotalQty) {
    this.stdfTotalQty = stdfTotalQty;
  }

  public BigDecimal getFirstBinYield() {
    return firstBinYield;
  }

  public void setFirstBinYield(BigDecimal firstBinYield) {
    this.firstBinYield = firstBinYield;
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
  public CustomerItemOperationFirstbin clone() {
    return new CustomerItemOperationFirstbin(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.operationBo + ", " + this.firstBin;
  }
}
