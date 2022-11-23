package ame.psb.db;

import java.util.Date;

public class AutoInstock {

  private String itemGroupBo;

  private String itemGroupName;

  private String operationBo;

  private String operationName;

  private String flag;

  private String content;

  private String value;

  private String updatedUser;

  private Date updatedTime;


  public AutoInstock() {
  }

  public AutoInstock(AutoInstock data) {
    this.itemGroupBo = data.itemGroupBo;
    this.itemGroupName = data.itemGroupName;
    this.operationBo = data.operationBo;
    this.operationName = data.operationName;
    this.flag = data.flag;
    this.content = data.content;
    this.value = data.value;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
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

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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
  public AutoInstock clone() {
    return new AutoInstock(this);
  }

  @Override
  public String toString() {
    return this.itemGroupBo + ", " + this.operationBo;
  }
}
