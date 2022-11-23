package ame.psb.db;

import java.util.Date;

public class ShopOrderWodataConvert {

  private String shopOrderBo;

  private String convertType;

  private String stateName;

  private String message;

  private String description;

  private String remarks;

  private String note;

  private String updatedUser;

  private Date updatedTime;


  public ShopOrderWodataConvert() {
  }

  public ShopOrderWodataConvert(ShopOrderWodataConvert data) {
    this.shopOrderBo = data.shopOrderBo;
    this.convertType = data.convertType;
    this.stateName = data.stateName;
    this.message = data.message;
    this.description = data.description;
    this.remarks = data.remarks;
    this.note = data.note;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public ShopOrderWodataConvert clone() {
    return new ShopOrderWodataConvert(this);
  }

  @Override
  public String toString() {
    return this.shopOrderBo + ", " + this.convertType;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getConvertType() {
    return convertType;
  }

  public void setConvertType(String convertType) {
    this.convertType = convertType;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
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

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
