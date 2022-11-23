package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class InventoryUseqty {

  private String inventoryBo;

  private BigDecimal useQty;

  private String updateUser;

  private Date updateTime;
  private String updateLog;

  public InventoryUseqty() {
  }

  public InventoryUseqty(InventoryUseqty data) {
    this.inventoryBo = data.inventoryBo;
    this.useQty = data.useQty;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.updateLog = data.updateLog;
  }

  public String getInventoryBo() {
    return inventoryBo;
  }

  public void setInventoryBo(String inventoryBo) {
    this.inventoryBo = inventoryBo;
  }

  public BigDecimal getUseQty() {
    return useQty;
  }

  public void setUseQty(BigDecimal useQty) {
    this.useQty = useQty;
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

  public String getUpdateLog() {
    return updateLog;
  }

  public void setUpdateLog(String updateLog) {
    this.updateLog = updateLog;
  }

  @Override
  public InventoryUseqty clone() {
    return new InventoryUseqty(this);
  }

  @Override
  public String toString() {
    return this.inventoryBo;
  }
}
