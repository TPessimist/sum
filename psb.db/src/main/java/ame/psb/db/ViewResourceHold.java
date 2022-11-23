package ame.psb.db;

import java.util.Date;

public class ViewResourceHold {

  private String id;

  private String resourceBo;

  private String resource;

  private String operationBo;

  private String operation;

  private String dcopBo;

  private Date dcTime;

  private String itemGroupBo;

  private String itemGroup;

  private String sfcBo;

  private String sfcName;

  private String updatedUser;

  private Date updatedTime;

  private String stateName;


  public ViewResourceHold() {
  }

  public ViewResourceHold(ViewResourceHold data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.resource = data.resource;
    this.operationBo = data.operationBo;
    this.operation = data.operation;
    this.dcopBo = data.dcopBo;
    this.dcTime = data.dcTime;
    this.itemGroupBo = data.itemGroupBo;
    this.itemGroup = data.itemGroup;
    this.sfcBo = data.sfcBo;
    this.sfcName = data.sfcName;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.stateName = data.stateName;
  }

  @Override
  public ViewResourceHold clone() {
    return new ViewResourceHold(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getDcopBo() {
    return dcopBo;
  }

  public void setDcopBo(String dcopBo) {
    this.dcopBo = dcopBo;
  }

  public Date getDcTime() {
    return dcTime;
  }

  public void setDcTime(Date dcTime) {
    this.dcTime = dcTime;
  }

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getItemGroup() {
    return itemGroup;
  }

  public void setItemGroup(String itemGroup) {
    this.itemGroup = itemGroup;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
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

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }
}
