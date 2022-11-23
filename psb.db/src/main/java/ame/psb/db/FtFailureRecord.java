package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class FtFailureRecord {

  private String id;

  private String sfcStepBo;

  private String actionName;

  private String stateName;

  private String sfcBo;

  private String shopOrderBo;

  private String operationBo;

  private String updateUser;

  private Date updateTime;

  private String content1;

  private String content2;


  public FtFailureRecord() {
    this.id = UUID.randomUUID().toString();
  }

  public FtFailureRecord(FtFailureRecord data) {
    this.id = data.id;
    this.sfcStepBo = data.sfcStepBo;
    this.actionName = data.actionName;
    this.stateName = data.stateName;
    this.sfcBo = data.sfcBo;
    this.shopOrderBo = data.shopOrderBo;
    this.operationBo = data.operationBo;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.content1 = data.content1;
    this.content2 = data.content2;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfcStepBo() {
    return sfcStepBo;
  }

  public void setSfcStepBo(String sfcStepBo) {
    this.sfcStepBo = sfcStepBo;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
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

  public String getContent1() {
    return content1;
  }

  public void setContent1(String content1) {
    this.content1 = content1;
  }

  public String getContent2() {
    return content2;
  }

  public void setContent2(String content2) {
    this.content2 = content2;
  }

  @Override
  public FtFailureRecord clone() {
    return new FtFailureRecord(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
