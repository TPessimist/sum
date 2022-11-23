package ame.psb.db;

import java.util.Date;

public class DcopResultState {

  private String id;

  private String sfcBo;

  private String itemGroupBo;

  private String operationBo;

  private String dcopGroupBo;

  private String dcopResultState;

  private String dcopResultBo;

  private Date updateTime;


  public DcopResultState() {
  }

  public DcopResultState(DcopResultState data) {
    this.id = data.id;
    this.sfcBo = data.sfcBo;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.dcopGroupBo = data.dcopGroupBo;
    this.dcopResultState = data.dcopResultState;
    this.dcopResultBo = data.dcopResultBo;
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

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getDcopGroupBo() {
    return dcopGroupBo;
  }

  public void setDcopGroupBo(String dcopGroupBo) {
    this.dcopGroupBo = dcopGroupBo;
  }

  public String getDcopResultState() {
    return dcopResultState;
  }

  public void setDcopResultState(String dcopResultState) {
    this.dcopResultState = dcopResultState;
  }

  public String getDcopResultBo() {
    return dcopResultBo;
  }

  public void setDcopResultBo(String dcopResultBo) {
    this.dcopResultBo = dcopResultBo;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public DcopResultState clone() {
    return new DcopResultState(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
