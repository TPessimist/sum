package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ProductUnitStock { //物料最小库存单位记录表

  private String product; //厂内物料

  private BigDecimal unitStock; //最小单位库存

  private Date updateTime; //更新时间

  private String updateUser; //更新人员

  private String description; //备用列1

  private String remarks; //备用列2

  private String note; //备用列3


  public ProductUnitStock() {
  }

  public ProductUnitStock(ProductUnitStock data) {
    this.product = data.product;
    this.unitStock = data.unitStock;
    this.updateTime = data.updateTime;
    this.updateUser = data.updateUser;
    this.description = data.description;
    this.remarks = data.remarks;
    this.note = data.note;
  }

  @Override
  public ProductUnitStock clone() {
    return new ProductUnitStock(this);
  }

  @Override
  public String toString() {
    return this.product;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public BigDecimal getUnitStock() {
    return unitStock;
  }

  public void setUnitStock(BigDecimal unitStock) {
    this.unitStock = unitStock;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
