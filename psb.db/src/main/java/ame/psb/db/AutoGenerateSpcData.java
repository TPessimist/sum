package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class AutoGenerateSpcData {

  private String shopOrderBo;

  private String shopOrderName;

  private String dcopBo;

  private BigDecimal cycleTime;

  private String remarks1;

  private String remarks2;

  private String remarks3;

  private String updatedUser;

  private Date updatedTime;


  public AutoGenerateSpcData() {
  }

  public AutoGenerateSpcData(AutoGenerateSpcData data) {
    this.shopOrderBo = data.shopOrderBo;
    this.shopOrderName = data.shopOrderName;
    this.dcopBo = data.dcopBo;
    this.cycleTime = data.cycleTime;
    this.remarks1 = data.remarks1;
    this.remarks2 = data.remarks2;
    this.remarks3 = data.remarks3;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getShopOrderName() {
    return shopOrderName;
  }

  public void setShopOrderName(String shopOrderName) {
    this.shopOrderName = shopOrderName;
  }

  public String getDcopBo() {
    return dcopBo;
  }

  public void setDcopBo(String dcopBo) {
    this.dcopBo = dcopBo;
  }

  public BigDecimal getCycleTime() {
    return cycleTime;
  }

  public void setCycleTime(BigDecimal cycleTime) {
    this.cycleTime = cycleTime;
  }

  public String getRemarks1() {
    return remarks1;
  }

  public void setRemarks1(String remarks1) {
    this.remarks1 = remarks1;
  }

  public String getRemarks2() {
    return remarks2;
  }

  public void setRemarks2(String remarks2) {
    this.remarks2 = remarks2;
  }

  public String getRemarks3() {
    return remarks3;
  }

  public void setRemarks3(String remarks3) {
    this.remarks3 = remarks3;
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
  public AutoGenerateSpcData clone() {
    return new AutoGenerateSpcData(this);
  }

  @Override
  public String toString() {
    return this.shopOrderBo;
  }
}
