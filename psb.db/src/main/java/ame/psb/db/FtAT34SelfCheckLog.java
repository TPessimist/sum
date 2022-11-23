package ame.psb.db;

import java.util.Date;

public class FtAT34SelfCheckLog {

  private String id;

  private String shopOrderName;

  private String responseCode;

  private String responseMessage;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public FtAT34SelfCheckLog() {
  }

  public FtAT34SelfCheckLog(FtAT34SelfCheckLog data) {
    this.id = data.id;
    this.shopOrderName = data.shopOrderName;
    this.responseCode = data.responseCode;
    this.responseMessage = data.responseMessage;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getShopOrderName() {
    return shopOrderName;
  }

  public void setShopOrderName(String shopOrderName) {
    this.shopOrderName = shopOrderName;
  }

  public String getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  public String getResponseMessage() {
    return responseMessage;
  }

  public void setResponseMessage(String responseMessage) {
    this.responseMessage = responseMessage;
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
  public FtAT34SelfCheckLog clone() {
    return new FtAT34SelfCheckLog(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
