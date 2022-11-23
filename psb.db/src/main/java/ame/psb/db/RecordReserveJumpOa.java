package ame.psb.db;

import java.util.Date;

public class RecordReserveJumpOa {

  private String sfcbo;

  private String customItem;

  private String shopOrder;

  private String oaId;

  private String waferId;

  private String startOp;

  private String endOp;

  private Date createTime;

  private Date updateTime;

  private String jumpState;

  private String oaState;

  private String updateUser;


  public RecordReserveJumpOa() {
  }

  public RecordReserveJumpOa(RecordReserveJumpOa data) {
    this.sfcbo = data.sfcbo;
    this.customItem = data.customItem;
    this.shopOrder = data.shopOrder;
    this.oaId = data.oaId;
    this.waferId = data.waferId;
    this.startOp = data.startOp;
    this.endOp = data.endOp;
    this.createTime = data.createTime;
    this.updateTime = data.updateTime;
    this.jumpState = data.jumpState;
    this.oaState = data.oaState;
    this.updateUser = data.updateUser;
  }

  @Override
  public RecordReserveJumpOa clone() {
    return new RecordReserveJumpOa(this);
  }

  @Override
  public String toString() {
    return this.oaId;
  }

  public String getSfcbo() {
    return sfcbo;
  }

  public void setSfcbo(String sfcbo) {
    this.sfcbo = sfcbo;
  }

  public String getCustomItem() {
    return customItem;
  }

  public void setCustomItem(String customItem) {
    this.customItem = customItem;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getOaId() {
    return oaId;
  }

  public void setOaId(String oaId) {
    this.oaId = oaId;
  }

  public String getWaferId() {
    return waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
  }

  public String getStartOp() {
    return startOp;
  }

  public void setStartOp(String startOp) {
    this.startOp = startOp;
  }

  public String getEndOp() {
    return endOp;
  }

  public void setEndOp(String endOp) {
    this.endOp = endOp;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getJumpState() {
    return jumpState;
  }

  public void setJumpState(String jumpState) {
    this.jumpState = jumpState;
  }

  public String getOaState() {
    return oaState;
  }

  public void setOaState(String oaState) {
    this.oaState = oaState;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }
}
