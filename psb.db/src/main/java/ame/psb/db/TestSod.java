package ame.psb.db;

import java.util.Date;

public class TestSod {

  private String shopOrder;

  private String device;

  private String size;

  private String sfc;

  private Date iqcOutTime;

  private String bumpingCt;

  private Date bumpingSod;

  private String finCt;

  private Date finSod;


  public TestSod() {
  }

  public TestSod(TestSod data) {
    this.shopOrder = data.shopOrder;
    this.device = data.device;
    this.size = data.size;
    this.sfc = data.sfc;
    this.iqcOutTime = data.iqcOutTime;
    this.bumpingCt = data.bumpingCt;
    this.bumpingSod = data.bumpingSod;
    this.finCt = data.finCt;
    this.finSod = data.finSod;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public Date getIqcOutTime() {
    return iqcOutTime;
  }

  public void setIqcOutTime(Date iqcOutTime) {
    this.iqcOutTime = iqcOutTime;
  }

  public String getBumpingCt() {
    return bumpingCt;
  }

  public void setBumpingCt(String bumpingCt) {
    this.bumpingCt = bumpingCt;
  }

  public Date getBumpingSod() {
    return bumpingSod;
  }

  public void setBumpingSod(Date bumpingSod) {
    this.bumpingSod = bumpingSod;
  }

  public String getFinCt() {
    return finCt;
  }

  public void setFinCt(String finCt) {
    this.finCt = finCt;
  }

  public Date getFinSod() {
    return finSod;
  }

  public void setFinSod(Date finSod) {
    this.finSod = finSod;
  }

  @Override
  public TestSod clone() {
    return new TestSod(this);
  }

  @Override
  public String toString() {
    return this.shopOrder;
  }
}
