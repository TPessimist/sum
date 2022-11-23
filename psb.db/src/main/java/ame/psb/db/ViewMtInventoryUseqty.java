package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ViewMtInventoryUseqty {

  private String inventoryBo;
  private String stateName;
  private BigDecimal pickedCount;
  private Date availableTime;
  private Date validFrom;
  private Date validTo;
  private BigDecimal minsInProcess;
  private String statusBo;
  private String inventoryId;
  private String inventoryDescription;
  private BigDecimal qtyOnHand;
  private Date receiveDateTime;
  private Date modifiedDateTime;
  private String supSn;
  private String prdDate;
  private String effDate;
  private String itemBo;
  private String itemName;
  private String itemDescription;
  private BigDecimal useQty;
  private String updateUser;
  private Date updateTime;
  private String updateLog;

  public ViewMtInventoryUseqty() {
  }

  public ViewMtInventoryUseqty(ViewMtInventoryUseqty data) {
    this.inventoryBo = data.inventoryBo;
    this.stateName = data.stateName;
    this.pickedCount = data.pickedCount;
    this.availableTime = data.availableTime;
    this.validFrom = data.validFrom;
    this.validTo = data.validTo;
    this.minsInProcess = data.minsInProcess;
    this.statusBo = data.statusBo;
    this.inventoryId = data.inventoryId;
    this.inventoryDescription = data.inventoryDescription;
    this.qtyOnHand = data.qtyOnHand;
    this.receiveDateTime = data.receiveDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.supSn = data.supSn;
    this.prdDate = data.prdDate;
    this.effDate = data.effDate;
    this.itemBo = data.itemBo;
    this.itemName = data.itemName;
    this.itemDescription = data.itemDescription;
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

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public BigDecimal getPickedCount() {
    return pickedCount;
  }

  public void setPickedCount(BigDecimal pickedCount) {
    this.pickedCount = pickedCount;
  }

  public Date getAvailableTime() {
    return availableTime;
  }

  public void setAvailableTime(Date availableTime) {
    this.availableTime = availableTime;
  }

  public Date getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(Date validFrom) {
    this.validFrom = validFrom;
  }

  public Date getValidTo() {
    return validTo;
  }

  public void setValidTo(Date validTo) {
    this.validTo = validTo;
  }

  public BigDecimal getMinsInProcess() {
    return minsInProcess;
  }

  public void setMinsInProcess(BigDecimal minsInProcess) {
    this.minsInProcess = minsInProcess;
  }

  public String getStatusBo() {
    return statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getInventoryDescription() {
    return inventoryDescription;
  }

  public void setInventoryDescription(String inventoryDescription) {
    this.inventoryDescription = inventoryDescription;
  }

  public BigDecimal getQtyOnHand() {
    return qtyOnHand;
  }

  public void setQtyOnHand(BigDecimal qtyOnHand) {
    this.qtyOnHand = qtyOnHand;
  }

  public Date getReceiveDateTime() {
    return receiveDateTime;
  }

  public void setReceiveDateTime(Date receiveDateTime) {
    this.receiveDateTime = receiveDateTime;
  }

  public Date getModifiedDateTime() {
    return modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public String getSupSn() {
    return supSn;
  }

  public void setSupSn(String supSn) {
    this.supSn = supSn;
  }

  public String getPrdDate() {
    return prdDate;
  }

  public void setPrdDate(String prdDate) {
    this.prdDate = prdDate;
  }

  public String getEffDate() {
    return effDate;
  }

  public void setEffDate(String effDate) {
    this.effDate = effDate;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
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
  public ViewMtInventoryUseqty clone() {
    return new ViewMtInventoryUseqty(this);
  }

  @Override
  public String toString() {
    return this.inventoryBo;
  }
}
