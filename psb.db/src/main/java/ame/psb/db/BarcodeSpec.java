package ame.psb.db;

import java.util.Date;

public class BarcodeSpec {

  private String barcodeId;

  private String item;

  private String spec;

  private String usageLimit;

  private String limitType;

  private Date updatedTime;

  private String updatedUser;


  public BarcodeSpec() {
  }

  public BarcodeSpec(BarcodeSpec data) {
    this.barcodeId = data.barcodeId;
    this.item = data.item;
    this.spec = data.spec;
    this.usageLimit = data.usageLimit;
    this.limitType = data.limitType;
    this.updatedTime = data.updatedTime;
    this.updatedUser = data.updatedUser;
  }

  @Override
  public BarcodeSpec clone() {
    return new BarcodeSpec(this);
  }

  @Override
  public String toString() {
    return this.barcodeId;
  }

  public String getBarcodeId() {
    return this.barcodeId;
  }

  public void setBarcodeId(String barcodeId) {
    this.barcodeId = barcodeId;
  }

  public String getItem() {
    return this.item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getSpec() {
    return this.spec;
  }

  public void setSpec(String spec) {
    this.spec = spec;
  }

  public String getUsageLimit() {
    return this.usageLimit;
  }

  public void setUsageLimit(String usageLimit) {
    this.usageLimit = usageLimit;
  }

  public String getLimitType() {
    return this.limitType;
  }

  public void setLimitType(String limitType) {
    this.limitType = limitType;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }
}
