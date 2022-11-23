package ame.me.db;

import java.util.Date;

public class ZhNpiFactorDate {

  private String handle;

  private String factorName;

  private String factorValue;

  private String updatedUser;

  private Date updatedTime;

  private String factorType;

  public ZhNpiFactorDate() {
  }

  public ZhNpiFactorDate(ZhNpiFactorDate data) {
    this.handle = data.handle;
    this.factorName = data.factorName;
    this.factorValue = data.factorValue;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getFactorType() {
    return factorType;
  }

  public void setFactorType(String factorType) {
    this.factorType = factorType;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getFactorName() {
    return factorName;
  }

  public void setFactorName(String factorName) {
    this.factorName = factorName;
  }

  public String getFactorValue() {
    return factorValue;
  }

  public void setFactorValue(String factorValue) {
    this.factorValue = factorValue;
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
  public ZhNpiFactorDate clone() {
    return new ZhNpiFactorDate(this);
  }

  @Override
  public String toString() {
    return this.handle + ", " + this.factorName;
  }
}
