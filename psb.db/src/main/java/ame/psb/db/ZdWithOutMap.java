package ame.psb.db;

import java.util.Date;

public class ZdWithOutMap {

  private String operationBo;

  private String sfcBo;

  private String updatedUser;

  private Date updatedTime;

  private String customerItemBo;


  public ZdWithOutMap() {
  }

  public ZdWithOutMap(ZdWithOutMap data) {
    this.operationBo = data.operationBo;
    this.sfcBo = data.sfcBo;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.customerItemBo = data.customerItemBo;
  }

  @Override
  public ZdWithOutMap clone() {
    return new ZdWithOutMap(this);
  }

  @Override
  public String toString() {
    return this.operationBo + ", " + this.sfcBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
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

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

}
