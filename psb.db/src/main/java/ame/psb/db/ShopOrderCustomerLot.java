package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class ShopOrderCustomerLot {

  private String shopOrderBo;

  private String customerItemLotBo;

  private String rootSfcName;

  private int currSeq;

  private Date createdTime;

  private String dptNo;

  private String lotType;

  public String getShopOrderBo() {
    return this.shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getCustomerItemLotBo() {
    return this.customerItemLotBo;
  }

  public void setCustomerItemLotBo(String customerItemLotBo) {
    this.customerItemLotBo = customerItemLotBo;
  }

  public String getRootSfcName() {
    return this.rootSfcName;
  }

  public void setRootSfcName(String rootSfcName) {
    this.rootSfcName = rootSfcName;
  }

  public int getCurrSeq() {
    return this.currSeq;
  }

  public void setCurrSeq(int currSeq) {
    this.currSeq = currSeq;
  }

  public Date getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public String getDptNo() {
    return this.dptNo;
  }

  public void setDptNo(String dptNo) {
    this.dptNo = dptNo;
  }

  public String getLotType() {
    return this.lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  @Override
  public String toString() {
    return this.shopOrderBo + "," + this.customerItemLotBo + "," + this.dptNo + "," + this.lotType;
  }
}
