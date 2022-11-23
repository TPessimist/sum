package ame.psb.db;

import java.math.BigDecimal;

public class InventoryFcPrint {

  private String itemId;

  private String itemName;

  private BigDecimal itemQty;

  private String rewarmTime;

  private String endTime;

  private String printId;

  private String labelId;

  private String spcName;

  private String modName;


  public InventoryFcPrint() {
  }

  public InventoryFcPrint(InventoryFcPrint data) {
    this.itemId = data.itemId;
    this.itemName = data.itemName;
    this.itemQty = data.itemQty;
    this.rewarmTime = data.rewarmTime;
    this.endTime = data.endTime;
    this.printId = data.printId;
    this.labelId = data.labelId;
    this.spcName = data.spcName;
    this.modName = data.modName;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public BigDecimal getItemQty() {
    return itemQty;
  }

  public void setItemQty(BigDecimal itemQty) {
    this.itemQty = itemQty;
  }

  public String getRewarmTime() {
    return rewarmTime;
  }

  public void setRewarmTime(String rewarmTime) {
    this.rewarmTime = rewarmTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getPrintId() {
    return printId;
  }

  public void setPrintId(String printId) {
    this.printId = printId;
  }

  public String getLabelId() {
    return labelId;
  }

  public void setLabelId(String labelId) {
    this.labelId = labelId;
  }

  public String getSpcName() {
    return spcName;
  }

  public void setSpcName(String spcName) {
    this.spcName = spcName;
  }

  public String getModName() {
    return modName;
  }

  public void setModName(String modName) {
    this.modName = modName;
  }

  @Override
  public InventoryFcPrint clone() {
    return new InventoryFcPrint(this);
  }

  @Override
  public String toString() {
    return this.itemId;
  }
}
