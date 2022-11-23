package ame.htks.db;

import java.math.BigDecimal;
import java.util.Date;

public class PlatingMetal2 {

  private String resourceBo;

  private String metal;

  private BigDecimal aLimitAh;

  private BigDecimal aCurrentAh;

  private BigDecimal aNafionAh;

  private Date aNafionInstall;

  private BigDecimal bLimitAh;

  private BigDecimal bCurrentAh;

  private BigDecimal bNafionAh;

  private Date bNafionInstall;

  private Date updateTime;

  private String updateUser;

  public PlatingMetal2() {
    this.metal = "";
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getMetal() {
    return metal;
  }

  public void setMetal(String metal) {
    this.metal = metal;
  }

  public BigDecimal getaLimitAh() {
    return aLimitAh;
  }

  public void setaLimitAh(BigDecimal aLimitAh) {
    this.aLimitAh = aLimitAh;
  }

  public BigDecimal getaCurrentAh() {
    return aCurrentAh;
  }

  public void setaCurrentAh(BigDecimal aCurrentAh) {
    this.aCurrentAh = aCurrentAh;
  }

  public BigDecimal getaNafionAh() {
    return aNafionAh;
  }

  public void setaNafionAh(BigDecimal aNafionAh) {
    this.aNafionAh = aNafionAh;
  }

  public Date getaNafionInstall() {
    return aNafionInstall;
  }

  public void setaNafionInstall(Date aNafionInstall) {
    this.aNafionInstall = aNafionInstall;
  }

  public BigDecimal getbLimitAh() {
    return bLimitAh;
  }

  public void setbLimitAh(BigDecimal bLimitAh) {
    this.bLimitAh = bLimitAh;
  }

  public BigDecimal getbCurrentAh() {
    return bCurrentAh;
  }

  public void setbCurrentAh(BigDecimal bCurrentAh) {
    this.bCurrentAh = bCurrentAh;
  }

  public BigDecimal getbNafionAh() {
    return bNafionAh;
  }

  public void setbNafionAh(BigDecimal bNafionAh) {
    this.bNafionAh = bNafionAh;
  }

  public Date getbNafionInstall() {
    return bNafionInstall;
  }

  public void setbNafionInstall(Date bNafionInstall) {
    this.bNafionInstall = bNafionInstall;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

}
