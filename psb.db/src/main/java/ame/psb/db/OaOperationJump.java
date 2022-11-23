package ame.psb.db;

import java.util.Date;

public class OaOperationJump {

  private String id;
  private String sfcBo;
  private String operationBo;
  private String nextOperationBo;
  private Date expirationTime;
  private Date updateTime;

  public OaOperationJump() {
  }

  public OaOperationJump(OaOperationJump data) {
    this.id = data.id;
    this.sfcBo = data.sfcBo;
    this.operationBo = data.operationBo;
    this.nextOperationBo = data.nextOperationBo;
    this.expirationTime = data.expirationTime;
    this.updateTime = data.updateTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getNextOperationBo() {
    return nextOperationBo;
  }

  public void setNextOperationBo(String nextOperationBo) {
    this.nextOperationBo = nextOperationBo;
  }

  public Date getExpirationTime() {
    return expirationTime;
  }

  public void setExpirationTime(Date expirationTime) {
    this.expirationTime = expirationTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public OaOperationJump clone() {
    return new OaOperationJump(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
