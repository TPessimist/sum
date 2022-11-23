package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerItemOperationSoftbin {

  private String customerItemBo;

  private String operationBo;

  private String softBin;

  private int softBinQty;

  private int stdfTotalQty;

  private BigDecimal softBinYield;

  private String updatedUser;

  private Date updatedTime;


  public CustomerItemOperationSoftbin() {
  }

  public CustomerItemOperationSoftbin(CustomerItemOperationSoftbin data) {
    this.customerItemBo = data.customerItemBo;
    this.operationBo = data.operationBo;
    this.softBin = data.softBin;
    this.softBinQty = data.softBinQty;
    this.stdfTotalQty = data.stdfTotalQty;
    this.softBinYield = data.softBinYield;
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

  public String getSoftBin() {
    return softBin;
  }

  public void setSoftBin(String softBin) {
    this.softBin = softBin;
  }

  public int getSoftBinQty() {
    return softBinQty;
  }

  public void setSoftBinQty(int softBinQty) {
    this.softBinQty = softBinQty;
  }

  public int getStdfTotalQty() {
    return stdfTotalQty;
  }

  public void setStdfTotalQty(int stdfTotalQty) {
    this.stdfTotalQty = stdfTotalQty;
  }

  public BigDecimal getSoftBinYield() {
    return softBinYield;
  }

  public void setSoftBinYield(BigDecimal softBinYield) {
    this.softBinYield = softBinYield;
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
  public CustomerItemOperationSoftbin clone() {
    return new CustomerItemOperationSoftbin(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.operationBo + ", " + this.softBin;
  }
}
