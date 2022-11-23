package ame.psb.db;

import java.util.Date;

public class FoBuyOffResult {

  private String id;

  private String itemGroupBo;

  private String operationBo;

  private String operation;

  private String holdType;

  private String sfcBo;

  private String state;

  private String updatedUser;

  private Date updatedTime;

  private String reverseField1;

  private String reverseField2;


  public FoBuyOffResult() {
  }

  public FoBuyOffResult(FoBuyOffResult data) {
    this.id = data.id;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.operation = data.operation;
    this.holdType = data.holdType;
    this.sfcBo = data.sfcBo;
    this.state = data.state;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.reverseField1 = data.reverseField1;
    this.reverseField2 = data.reverseField2;
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

  public String getHoldType() {
    return holdType;
  }

  public void setHoldType(String holdType) {
    this.holdType = holdType;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
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

  public String getReverseField1() {
    return reverseField1;
  }

  public void setReverseField1(String reverseField1) {
    this.reverseField1 = reverseField1;
  }

  public String getReverseField2() {
    return reverseField2;
  }

  public void setReverseField2(String reverseField2) {
    this.reverseField2 = reverseField2;
  }

  @Override
  public FoBuyOffResult clone() {
    return new FoBuyOffResult(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
