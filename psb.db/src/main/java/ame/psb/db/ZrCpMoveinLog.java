package ame.psb.db;

import java.util.Date;

public class ZrCpMoveinLog {

  private String waferBo;
  private String customerLot;
  private String groupId;
  private String updateUser;
  private Date updateTime;

  public ZrCpMoveinLog() {
  }

  public ZrCpMoveinLog(ZrCpMoveinLog data) {
    this.waferBo = data.waferBo;
    this.customerLot = data.customerLot;
    this.groupId = data.groupId;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getWaferBo() {
    return waferBo;
  }

  public void setWaferBo(String waferBo) {
    this.waferBo = waferBo;
  }

  public String getCustomerLot() {
    return customerLot;
  }

  public void setCustomerLot(String customerLot) {
    this.customerLot = customerLot;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date date) {
    this.updateTime = date;
  }

  @Override
  public ZrCpMoveinLog clone() {
    return new ZrCpMoveinLog(this);
  }

  @Override
  public String toString() {
    return this.waferBo;
  }
}
