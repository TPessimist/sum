package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import java.util.function.Predicate;
import javax.persistence.Entity;

@Entity
public class CustomerItem implements Cloneable {

  private String id;

  private String customerItemLotBo;

  private String itemName;


  private String itemNameOrig;

  private String shopOrderBo;

  private int goodQty;

  private int grossQty;

  private String markCode;

  private String inputDefect;

  private String inputGrade;

  private String updatedUser;

  private Date updatedTime;

  public CustomerItem() {
    this.id = UUID.randomUUID().toString();
    this.inputDefect = "N";
    this.inputGrade = "N";
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCustomerItemLotBo() {
    return this.customerItemLotBo;
  }

  public void setCustomerItemLotBo(String customerItemLotBo) {
    this.customerItemLotBo = customerItemLotBo;
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

  public boolean validateWaferId(Predicate<String> validator) {
    return this.itemNameOrig != null && validator.test(this.itemNameOrig);
  }

  public String getShopOrderBo() {
    return this.shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public int getGoodQty() {
    return this.goodQty;
  }

  public void setGoodQty(int goodQty) {
    this.goodQty = goodQty;
  }

  public int getGrossQty() {
    return this.grossQty;
  }

  public void setGrossQty(int grossQty) {
    this.grossQty = grossQty;
  }

  public String getMarkCode() {
    return this.markCode;
  }

  public void setMarkCode(String markCode) {
    this.markCode = markCode;
  }

  public String getInputDefect() {
    return this.inputDefect;
  }

  public void setInputDefect(String inputDefect) {
    this.inputDefect = inputDefect;
  }

  public String getInputGrade() {
    return this.inputGrade;
  }

  public void setInputGrade(String inputGrade) {
    this.inputGrade = inputGrade;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  /**
   * if null, return customer waferId
   *
   * @return physical waferId
   */
  public String smartGetPhysicalWaferId() {
    return (this.getItemNameOrig() == null || this.getItemNameOrig().isEmpty()) ? this.itemName
        : this.itemNameOrig;
  }

  @Override
  public String toString() {
    return this.id;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
