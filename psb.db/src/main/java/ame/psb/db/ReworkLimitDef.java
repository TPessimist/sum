package ame.psb.db;

import java.util.Date;

public class ReworkLimitDef {

  private String itemGroup;

  private String operation;

  private String reworkRouter;

  private Integer limitTimes;

  private Date updateTime;

  private String updateUser;


  public ReworkLimitDef() {
  }

  public ReworkLimitDef(ReworkLimitDef data) {
    this.itemGroup = data.itemGroup;
    this.operation = data.operation;
    this.reworkRouter = data.reworkRouter;
    this.limitTimes = data.limitTimes;
    this.updateTime = data.updateTime;
    this.updateUser = data.updateUser;
  }

  @Override
  public ReworkLimitDef clone() {
    return new ReworkLimitDef(this);
  }

  @Override
  public String toString() {
    return this.itemGroup + ", " + this.operation + ", " + this.reworkRouter;
  }

  public String getItemGroup() {
    return itemGroup;
  }

  public void setItemGroup(String itemGroup) {
    this.itemGroup = itemGroup;
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

  public Integer getLimitTimes() {
    return limitTimes;
  }

  public void setLimitTimes(Integer limitTimes) {
    this.limitTimes = limitTimes;
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