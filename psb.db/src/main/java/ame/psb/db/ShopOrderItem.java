package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class ShopOrderItem {

  private String shopOrderBo;

  private String customerItemLotBo;

  private String customerItemBo;

  private String customerBo;

  private String itemsetName;

  private String itemName;

  private String itemNameOrig;

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

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getCustomerBo() {
    return this.customerBo;
  }

  public void setCustomerBo(String customerBo) {
    this.customerBo = customerBo;
  }

  public String getItemsetName() {
    return this.itemsetName;
  }

  public void setItemsetName(String itemsetName) {
    this.itemsetName = itemsetName;
  }

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemNameOrig() {
    return this.itemNameOrig;
  }

  public void setItemNameOrig(String itemNameOrig) {
    this.itemNameOrig = itemNameOrig;
  }

}
