package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class CustomerItemOperationDefect {

  private String customerItemBo;

  private String operationBo;

  private String ncCodeBo;

  private BigDecimal ncValue;

  private String updatedUser;

  private Date updatedTime;


  public CustomerItemOperationDefect() {
  }

  public CustomerItemOperationDefect(CustomerItemOperationDefect data) {
    this.customerItemBo = data.customerItemBo;
    this.operationBo = data.operationBo;
    this.ncCodeBo = data.ncCodeBo;
    this.ncValue = data.ncValue;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public CustomerItemOperationDefect clone() {
    return new CustomerItemOperationDefect(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.operationBo + ", " + this.ncCodeBo;
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

  public String getNcCodeBo() {
    return ncCodeBo;
  }

  public void setNcCodeBo(String ncCodeBo) {
    this.ncCodeBo = ncCodeBo;
  }

  public BigDecimal getNcValue() {
    return ncValue;
  }

  public void setNcValue(BigDecimal ncValue) {
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


}
