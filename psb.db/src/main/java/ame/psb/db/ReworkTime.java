package ame.psb.db;

import java.util.Date;

public class ReworkTime {

  private String customerItemBo;

  private String operation;

  private String reworkRouter;

  private Integer reworkTime;

  private Date updateTime;

  private String updateUser;


  public ReworkTime() {
  }

  public ReworkTime(ReworkTime data) {
    this.customerItemBo = data.customerItemBo;
    this.operation = data.operation;
    this.reworkRouter = data.reworkRouter;
    this.reworkTime = data.reworkTime;
    this.updateTime = data.updateTime;
    this.updateUser = data.updateUser;
  }

  @Override
  public ReworkTime clone() {
    return new ReworkTime(this);
  }

  @Override
  public String toString() {
    return this.customerItemBo + ", " + this.operation + ", " + this.reworkRouter;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getReworkRouter() {
    return reworkRouter;
  }

  public void setReworkRouter(String reworkRouter) {
    this.reworkRouter = reworkRouter;
  }

  public Integer getReworkTime() {
    return reworkTime;
  }

  public void setReworkTime(Integer reworkTime) {
    this.reworkTime = reworkTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }


}
