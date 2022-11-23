package ame.psb.db;

import java.util.Date;

public class ZdBincode {

  private String id;

  private String itemGroupBo;

  private String itemGroupName;

  private String binType;

  private String binCode;

  private String binName;

  private String operationBo;

  private String operationName;

  private String updateUser;

  private Date updateTime;


  public ZdBincode() {
  }

  public ZdBincode(ZdBincode data) {
    this.id = data.id;
    this.itemGroupBo = data.itemGroupBo;
    this.itemGroupName = data.itemGroupName;
    this.binType = data.binType;
    this.binCode = data.binCode;
    this.binName = data.binName;
    this.operationBo = data.operationBo;
    this.operationName = data.operationName;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getItemGroupName() {
    return itemGroupName;
  }

  public void setItemGroupName(String itemGroupName) {
    this.itemGroupName = itemGroupName;
  }

  public String getBinType() {
    return binType;
  }

  public void setBinType(String binType) {
    this.binType = binType;
  }

  public String getBinCode() {
    return binCode;
  }

  public void setBinCode(String binCode) {
    this.binCode = binCode;
  }

  public String getBinName() {
    return binName;
  }

  public void setBinName(String binName) {
    this.binName = binName;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getOperationName() {
    return operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
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

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public ZdBincode clone() {
    return new ZdBincode(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
