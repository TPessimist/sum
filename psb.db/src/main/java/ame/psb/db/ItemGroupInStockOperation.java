package ame.psb.db;

import java.util.Date;

public class ItemGroupInStockOperation {

  private String itemGroupBo;

  private String operationBo;

  private String instockType;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public ItemGroupInStockOperation() {
  }

  public ItemGroupInStockOperation(ItemGroupInStockOperation data) {
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.instockType = data.instockType;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
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

  public String getInstockType() {
    return instockType;
  }

  public void setInstockType(String instockType) {
    this.instockType = instockType;
  }

  public String getReversedField1() {
    return reversedField1;
  }

  public void setReversedField1(String reversedField1) {
    this.reversedField1 = reversedField1;
  }

  public String getReversedField2() {
    return reversedField2;
  }

  public void setReversedField2(String reversedField2) {
    this.reversedField2 = reversedField2;
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

  @Override
  public ItemGroupInStockOperation clone() {
    return new ItemGroupInStockOperation(this);
  }

  @Override
  public String toString() {
    return this.itemGroupBo + ", " + this.operationBo + ", " + this.instockType;
  }

  public String value() {
    return this.itemGroupBo + ", " + this.operationBo + ", " + this.instockType;
  }
}
