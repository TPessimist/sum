package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class WaferStorage {

  private String handle;
  private String sfc;
  private String deviceName;
  private String customer;
  private String waferId;
  private BigDecimal balanceQty;
  private Date filmTime;
  private Date expireTime;
  private String membranceType;
  private String storageLocation1;
  private String storageLocation2;
  private String storageLocation3;
  private String createdUser;
  private String claimedUser;
  private Date createdTime;
  private Date claimedTime;

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getWaferId() {
    return waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
  }

  public BigDecimal getBalanceQty() {
    return balanceQty;
  }

  public void setBalanceQty(BigDecimal balanceQty) {
    this.balanceQty = balanceQty;
  }

  public Date getFilmTime() {
    return filmTime;
  }

  public void setFilmTime(Date filmTime) {
    this.filmTime = filmTime;
  }

  public Date getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(Date expireTime) {
    this.expireTime = expireTime;
  }

  public String getMembranceType() {
    return membranceType;
  }

  public void setMembranceType(String membranceType) {
    this.membranceType = membranceType;
  }

  public String getStorageLocation1() {
    return storageLocation1;
  }

  public void setStorageLocation1(String storageLocation1) {
    this.storageLocation1 = storageLocation1;
  }

  public String getStorageLocation2() {
    return storageLocation2;
  }

  public void setStorageLocation2(String storageLocation2) {
    this.storageLocation2 = storageLocation2;
  }

  public String getStorageLocation3() {
    return storageLocation3;
  }

  public void setStorageLocation3(String storageLocation3) {
    this.storageLocation3 = storageLocation3;
  }

  public String getCreatedUser() {
    return createdUser;
  }

  public void setCreatedUser(String createdUser) {
    this.createdUser = createdUser;
  }

  public String getClaimedUser() {
    return claimedUser;
  }

  public void setClaimedUser(String claimedUser) {
    this.claimedUser = claimedUser;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getClaimedTime() {
    return claimedTime;
  }

  public void setClaimedTime(Date claimedTime) {
    this.claimedTime = claimedTime;
  }

}
