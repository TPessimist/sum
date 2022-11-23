package ame.psb.db;

import java.util.Date;

public class DeviceOperationRecipeHold {

  private String itemGroupBo;

  private String operationBo;

  private int count;

  private int dcCount;

  private Date updatedTime;

  private String updatedUser;


  public DeviceOperationRecipeHold() {
  }

  public DeviceOperationRecipeHold(DeviceOperationRecipeHold data) {
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.count = data.count;
    this.dcCount = data.dcCount;
    this.updatedTime = data.updatedTime;
    this.updatedUser = data.updatedUser;
  }

  @Override
  public DeviceOperationRecipeHold clone() {
    return new DeviceOperationRecipeHold(this);
  }

  @Override
  public String toString() {
    return this.itemGroupBo + ", " + this.operationBo;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public int getCount() {
    return this.count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getDcCount() {
    return this.dcCount;
  }

  public void setDcCount(int dcCount) {
    this.dcCount = dcCount;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }
}
