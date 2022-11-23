package ame.psb.db;

import java.util.Date;

public class ShopOrderScheduledCompDate {

  private String shopOrderBo;

  private Date scheduledCompDate;

  private String updateUser;

  private Date updateTime;


  public ShopOrderScheduledCompDate() {
  }

  public ShopOrderScheduledCompDate(ShopOrderScheduledCompDate data) {
    this.shopOrderBo = data.shopOrderBo;
    this.scheduledCompDate = data.scheduledCompDate;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public Date getScheduledCompDate() {
    return scheduledCompDate;
  }

  public void setScheduledCompDate(Date scheduledCompDate) {
    this.scheduledCompDate = scheduledCompDate;
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

  @Override
  public ShopOrderScheduledCompDate clone() {
    return new ShopOrderScheduledCompDate(this);
  }

  @Override
  public String toString() {
    return this.shopOrderBo;
  }
}
