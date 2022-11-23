package ame.psb.db;

import java.math.BigDecimal;

public class InventoryAssyData {

  private String handle;

  private String inventoryBo;

  private BigDecimal sequence;

  private String dataField;

  private String dataAttr;


  public InventoryAssyData() {
  }

  public InventoryAssyData(InventoryAssyData data) {
    this.handle = data.handle;
    this.inventoryBo = data.inventoryBo;
    this.sequence = data.sequence;
    this.dataField = data.dataField;
    this.dataAttr = data.dataAttr;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getInventoryBo() {
    return inventoryBo;
  }

  public void setInventoryBo(String inventoryBo) {
    this.inventoryBo = inventoryBo;
  }

  public BigDecimal getSequence() {
    return sequence;
  }

  public void setSequence(BigDecimal sequence) {
    this.sequence = sequence;
  }

  public String getDataField() {
    return dataField;
  }

  public void setDataField(String dataField) {
    this.dataField = dataField;
  }

  public String getDataAttr() {
    return dataAttr;
  }

  public void setDataAttr(String dataAttr) {
    this.dataAttr = dataAttr;
  }

  @Override
  public InventoryAssyData clone() {
    return new InventoryAssyData(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
