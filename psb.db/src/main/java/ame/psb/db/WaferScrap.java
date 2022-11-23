package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class WaferScrap {

  private String sfcBo;

  private String sfc;

  private String itemBo;

  private BigDecimal dieQty;

  private BigDecimal badQty;

  private BigDecimal goodQty;

  private String reason;

  private String updateUser;

  private Date updateTime;

  private String extend;

  public WaferScrap() {
  }

  public WaferScrap(WaferScrap data) {
    this.sfcBo = data.sfcBo;
    this.sfc = data.sfc;
    this.itemBo = data.itemBo;
    this.dieQty = data.dieQty;
    this.badQty = data.badQty;
    this.goodQty = data.goodQty;
    this.reason = data.reason;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.extend = data.extend;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public BigDecimal getDieQty() {
    return dieQty;
  }

  public void setDieQty(BigDecimal dieQty) {
    this.dieQty = dieQty;
  }

  public BigDecimal getBadQty() {
    return badQty;
  }

  public void setBadQty(BigDecimal badQty) {
    this.badQty = badQty;
  }

  public BigDecimal getGoodQty() {
    return goodQty;
  }

  public void setGoodQty(BigDecimal goodQty) {
    this.goodQty = goodQty;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getExtend() {
    return extend;
  }

  public void setExtend(String extend) {
    this.extend = extend;
  }

  @Override
  public WaferScrap clone() {
    return new WaferScrap(this);
  }

  @Override
  public String toString() {
    return this.sfcBo + ", " + this.itemBo;
  }
}
