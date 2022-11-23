package ame.htks.db;

import java.math.BigDecimal;
import java.util.Date;

public class PlatingMetal {

  private String resourceBo;

  private String metal1;

  private String metal2;

  private BigDecimal a1LimitAh;

  private BigDecimal a1CurrentAh;

  private BigDecimal a1NafionAh;

  private Date a1NafionInstall;

  private BigDecimal b1LimitAh;

  private BigDecimal b1CurrentAh;

  private BigDecimal b1NafionAh;

  private Date b1NafionInstall;

  private BigDecimal a2LimitAh;

  private BigDecimal a2CurrentAh;

  private BigDecimal a2NafionAh;

  private Date a2NafionInstall;

  private BigDecimal b2LimitAh;

  private BigDecimal b2CurrentAh;

  private BigDecimal b2NafionAh;

  private Date b2NafionInstall;

  private Date updateTime;

  private String updateUser;

  public PlatingMetal() {
    this.metal1 = "";
    this.metal2 = "";
  }

  public PlatingMetal(PlatingMetal data) {
    this.resourceBo = data.resourceBo;
    this.metal1 = data.metal1;
    this.metal2 = data.metal2;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getMetal1() {
    return metal1;
  }

  public void setMetal1(String metal1) {
    this.metal1 = metal1;
  }

  public String getMetal2() {
    return metal2;
  }

  public void setMetal2(String metal2) {
    this.metal2 = metal2;
  }

  public BigDecimal getA1LimitAh() {
    return a1LimitAh;
  }

  public void setA1LimitAh(BigDecimal a1LimitAh) {
    this.a1LimitAh = a1LimitAh;
  }

  public BigDecimal getA1CurrentAh() {
    return a1CurrentAh;
  }

  public void setA1CurrentAh(BigDecimal a1CurrentAh) {
    this.a1CurrentAh = a1CurrentAh;
  }

  public BigDecimal getB1LimitAh() {
    return b1LimitAh;
  }

  public void setB1LimitAh(BigDecimal b1LimitAh) {
    this.b1LimitAh = b1LimitAh;
  }

  public BigDecimal getB1CurrentAh() {
    return b1CurrentAh;
  }

  public void setB1CurrentAh(BigDecimal b1CurrentAh) {
    this.b1CurrentAh = b1CurrentAh;
  }

  public BigDecimal getA2LimitAh() {
    return a2LimitAh;
  }

  public void setA2LimitAh(BigDecimal a2LimitAh) {
    this.a2LimitAh = a2LimitAh;
  }

  public BigDecimal getA2CurrentAh() {
    return a2CurrentAh;
  }

  public void setA2CurrentAh(BigDecimal a2CurrentAh) {
    this.a2CurrentAh = a2CurrentAh;
  }

  public BigDecimal getB2LimitAh() {
    return b2LimitAh;
  }

  public void setB2LimitAh(BigDecimal b2LimitAh) {
    this.b2LimitAh = b2LimitAh;
  }

  public BigDecimal getB2CurrentAh() {
    return b2CurrentAh;
  }

  public void setB2CurrentAh(BigDecimal b2CurrentAh) {
    this.b2CurrentAh = b2CurrentAh;
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

  public BigDecimal getA1NafionAh() {
    return a1NafionAh;
  }

  public void setA1NafionAh(BigDecimal a1NafionAh) {
    this.a1NafionAh = a1NafionAh;
  }

  public Date getA1NafionInstall() {
    return a1NafionInstall;
  }

  public void setA1NafionInstall(Date a1NafionInstall) {
    this.a1NafionInstall = a1NafionInstall;
  }

  public BigDecimal getB1NafionAh() {
    return b1NafionAh;
  }

  public void setB1NafionAh(BigDecimal b1NafionAh) {
    this.b1NafionAh = b1NafionAh;
  }

  public Date getB1NafionInstall() {
    return b1NafionInstall;
  }

  public void setB1NafionInstall(Date b1NafionInstall) {
    this.b1NafionInstall = b1NafionInstall;
  }

  public BigDecimal getA2NafionAh() {
    return a2NafionAh;
  }

  public void setA2NafionAh(BigDecimal a2NafionAh) {
    this.a2NafionAh = a2NafionAh;
  }

  public Date getA2NafionInstall() {
    return a2NafionInstall;
  }

  public void setA2NafionInstall(Date a2NafionInstall) {
    this.a2NafionInstall = a2NafionInstall;
  }

  public BigDecimal getB2NafionAh() {
    return b2NafionAh;
  }

  public void setB2NafionAh(BigDecimal b2NafionAh) {
    this.b2NafionAh = b2NafionAh;
  }

  public Date getB2NafionInstall() {
    return b2NafionInstall;
  }

  public void setB2NafionInstall(Date b2NafionInstall) {
    this.b2NafionInstall = b2NafionInstall;
  }

}
