package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class ShopOrderCustomerLotLog extends ShopOrderCustomerLot {

  private String id;

  private Date runTime;

  private String runUser;


  public ShopOrderCustomerLotLog() {
  }

  public ShopOrderCustomerLotLog(ShopOrderCustomerLot data, String user) {
    this.id = UUID.randomUUID().toString();
    this.setShopOrderBo(data.getShopOrderBo());
    this.setCustomerItemLotBo(data.getCustomerItemLotBo());
    this.setRootSfcName(data.getRootSfcName());
    this.setDptNo(data.getDptNo());
    this.setCurrSeq(data.getCurrSeq());
    this.setLotType(data.getLotType());
    this.runUser = user;
    this.runTime = new Date();
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getRunTime() {
    return runTime;
  }

  public void setRunTime(Date runTime) {
    this.runTime = runTime;
  }

  public String getRunUser() {
    return runUser;
  }

  public void setRunUser(String runUser) {
    this.runUser = runUser;
  }
}