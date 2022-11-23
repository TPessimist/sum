package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ViewMtInventory extends MtInventory {

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

  public ViewMtInventory() {
  }

  public ViewMtInventory(ViewMtInventory data) {
    super(data);
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
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getInventoryId() {
    return this.inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getInventoryDescription() {
    return this.inventoryDescription;
  }

  public void setInventoryDescription(String inventoryDescription) {
    this.inventoryDescription = inventoryDescription;
  }

  public BigDecimal getQtyOnHand() {
    return this.qtyOnHand;
  }

  public void setQtyOnHand(BigDecimal qtyOnHand) {
    this.qtyOnHand = qtyOnHand;
  }

  public Date getReceiveDateTime() {
    return this.receiveDateTime;
  }

  public void setReceiveDateTime(Date receiveDateTime) {
    this.receiveDateTime = receiveDateTime;
  }

  public Date getModifiedDateTime() {
    return this.modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public String getSupSn() {
    return this.supSn;
  }

  public void setSupSn(String supSn) {
    this.supSn = supSn;
  }

  public String getPrdDate() {
    return this.prdDate;
  }

  public void setPrdDate(String prdDate) {
    this.prdDate = prdDate;
  }

  public String getEffDate() {
    return this.effDate;
  }

  public void setEffDate(String effDate) {
    this.effDate = effDate;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemDescription() {
    return this.itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  @Override
  public ViewMtInventory clone() {
    return new ViewMtInventory(this);
  }

  @Override
  public String toString() {
    return String.format("%s, %s:%-9s, item:%s, qty:%13s, validTo:%s",
        getInventoryBo(),
        getStatusBo(),
        getStateName(),
        getItemBo(),
        getQtyOnHand(),
        getValidTo());
  }
}
