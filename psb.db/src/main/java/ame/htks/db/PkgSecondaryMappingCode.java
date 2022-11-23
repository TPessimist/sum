package ame.htks.db;

public class PkgSecondaryMappingCode {

  private String product;

  private String device;

  private String binCodeList;

  private String mappingCode;

  private String updateUser;

  private String updateTime;

  public PkgSecondaryMappingCode() {
  }

  public PkgSecondaryMappingCode(PkgSecondaryMappingCode data) {
    this.product = data.product;
    this.device = data.device;
    this.binCodeList = data.binCodeList;
    this.mappingCode = data.mappingCode;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getProduct() {
    return this.product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getDevice() {
    return this.device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public String getBinCodeList() {
    return this.binCodeList;
  }

  public void setBinCodeList(String binCodeList) {
    this.binCodeList = binCodeList;
  }

  public String getMappingCode() {
    return this.mappingCode;
  }

  public void setMappingCode(String mappingCode) {
    this.mappingCode = mappingCode;
  }

  public String getUpdateUser() {
    return this.updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public String getUpdateTime() {
    return this.updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public PkgSecondaryMappingCode clone() {
    return new PkgSecondaryMappingCode(this);
  }

  @Override
  public String toString() {
    return this.product + ", " + this.device + ", " + this.binCodeList;
  }
}
