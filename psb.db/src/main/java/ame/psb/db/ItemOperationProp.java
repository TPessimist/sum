package ame.psb.db;

import java.util.Date;

public class ItemOperationProp {

  private String itemBo;

  private String operationBo;

  private String propName;

  private String propValue;

  private String updatedUser;

  private Date updatedTime;

  public ItemOperationProp() {
  }


  public ItemOperationProp(ItemOperationProp data) {
    this.itemBo = data.itemBo;
    this.operationBo = data.operationBo;
    this.propName = data.propName;
    this.propValue = data.propValue;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getPropName() {
    return this.propName;
  }

  public void setPropName(String propName) {
    this.propName = propName;
  }

  public String getPropValue() {
    return this.propValue;
  }

  public void setPropValue(String propValue) {
    this.propValue = propValue;
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
  public ItemOperationProp clone() {
    return new ItemOperationProp(this);
  }

  @Override
  public String toString() {
    return this.itemBo + ", " + this.operationBo + ", " + this.propName;
  }
}
