package ame.psb.db;

import java.util.Date;

public class FcToFtInfo {

  private String batchId;

  private String state;

  private String shopOrderBo;

  private String criteria;

  private String result;

  private String reverseField1;

  private String reverseField2;

  private String updatedUser;

  private Date updatedTime;


  public FcToFtInfo() {
  }

  public FcToFtInfo(FcToFtInfo data) {
    this.batchId = data.batchId;
    this.state = data.state;
    this.shopOrderBo = data.shopOrderBo;
    this.criteria = data.criteria;
    this.result = data.result;
    this.reverseField1 = data.reverseField1;
    this.reverseField2 = data.reverseField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getCriteria() {
    return criteria;
  }

  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
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
  public FcToFtInfo clone() {
    return new FcToFtInfo(this);
  }

  @Override
  public String toString() {
    return this.batchId;
  }
}
