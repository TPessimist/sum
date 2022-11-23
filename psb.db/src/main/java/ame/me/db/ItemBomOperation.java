package ame.me.db;

import java.math.BigDecimal;

public class ItemBomOperation {

  private String itemBo;

  private String operationBo;

  private String bomBo;

  private String bomComponentBo;

  private String bomComponentItemBo;

  private String site;

  private String itemDescription;

  private String bomDescription;

  private String item;

  private String itemType;

  private String itemStatusBo;

  private String componentGroupBo;

  private BigDecimal qty;

  private String bomOperationBo;

  public ItemBomOperation() {
  }

  public ItemBomOperation(ItemBomOperation data) {
    this.itemBo = data.itemBo;
    this.operationBo = data.operationBo;
    this.bomBo = data.bomBo;
    this.bomComponentBo = data.bomComponentBo;
    this.bomComponentItemBo = data.bomComponentItemBo;
    this.site = data.site;
    this.itemDescription = data.itemDescription;
    this.bomDescription = data.bomDescription;
    this.item = data.item;
    this.itemType = data.itemType;
    this.itemStatusBo = data.itemStatusBo;
    this.componentGroupBo = data.componentGroupBo;
    this.qty = data.qty;
    this.bomOperationBo = data.bomOperationBo;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getBomBo() {
    return this.bomBo;
  }

  public void setBomBo(String bomBo) {
    this.bomBo = bomBo;
  }

  public String getBomComponentBo() {
    return this.bomComponentBo;
  }

  public void setBomComponentBo(String bomComponentBo) {
    this.bomComponentBo = bomComponentBo;
  }

  public String getBomComponentItemBo() {
    return this.bomComponentItemBo;
  }

  public void setBomComponentItemBo(String bomComponentItemBo) {
    this.bomComponentItemBo = bomComponentItemBo;
  }

  public String getSite() {
    return this.site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getItemDescription() {
    return this.itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public String getBomDescription() {
    return this.bomDescription;
  }

  public void setBomDescription(String bomDescription) {
    this.bomDescription = bomDescription;
  }

  public String getItem() {
    return this.item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getItemType() {
    return this.itemType;
  }

  public void setItemType(String itemType) {
    this.itemType = itemType;
  }

  public String getItemStatusBo() {
    return this.itemStatusBo;
  }

  public void setItemStatusBo(String itemStatusBo) {
    this.itemStatusBo = itemStatusBo;
  }

  public String getComponentGroupBo() {
    return this.componentGroupBo;
  }

  public void setComponentGroupBo(String componentGroupBo) {
    this.componentGroupBo = componentGroupBo;
  }

  public BigDecimal getQty() {
    return this.qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public String getBomOperationBo() {
    return this.bomOperationBo;
  }

  public void setBomOperationBo(String bomOperationBo) {
    this.bomOperationBo = bomOperationBo;
  }

  @Override
  public ItemBomOperation clone() {
    return new ItemBomOperation(this);
  }

  @Override
  public String toString() {
    return this.bomComponentItemBo + "/" + this.itemBo + " @ " + this.operationBo + ", qty:"
        + this.qty;
  }
}
