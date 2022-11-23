package ame.psb.db;

import java.util.Date;

public class WaferDeductionRecord {  //ZR_WAFER_DEDUCTION_RECORD的实体类

  private String uuid;  //随机主键

  private String shopOrder; //工单

  private String sapOrder; //sap工单

  private String issueBy; //操作员

  private String itemType; //组件类型

  private String wafer; //工单wafer

  private String waferLot; //晶圆lot

  private String waferId; //片号

  private String product; //厂内料号

  private String sapProduct; //SAP料号

  private String qty; //数量

  private String comment; //箱号

  private String description; //生产批号

  private String value; //good_bad_bin

  private Date sendtime; //发送时间

  private String code; //返回码

  private String message; //返回信息

  private String operation; //站点


  public WaferDeductionRecord() {
  }

  public WaferDeductionRecord(WaferDeductionRecord data) {
    this.uuid = data.uuid;
    this.shopOrder = data.shopOrder;
    this.sapOrder = data.sapOrder;
    this.issueBy = data.issueBy;
    this.itemType = data.itemType;
    this.wafer = data.wafer;
    this.waferLot = data.waferLot;
    this.waferId = data.waferId;
    this.product = data.product;
    this.sapProduct = data.sapProduct;
    this.qty = data.qty;
    this.comment = data.comment;
    this.description = data.description;
    this.value = data.value;
    this.sendtime = data.sendtime;
    this.code = data.code;
    this.message = data.message;
    this.operation = data.operation;
  }

  @Override
  public WaferDeductionRecord clone() {
    return new WaferDeductionRecord(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getSapOrder() {
    return sapOrder;
  }

  public void setSapOrder(String sapOrder) {
    this.sapOrder = sapOrder;
  }

  public String getIssueBy() {
    return issueBy;
  }

  public void setIssueBy(String issueBy) {
    this.issueBy = issueBy;
  }

  public String getItemType() {
    return itemType;
  }

  public void setItemType(String itemType) {
    this.itemType = itemType;
  }

  public String getWafer() {
    return wafer;
  }

  public void setWafer(String wafer) {
    this.wafer = wafer;
  }

  public String getWaferLot() {
    return waferLot;
  }

  public void setWaferLot(String waferLot) {
    this.waferLot = waferLot;
  }

  public String getWaferId() {
    return waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getSapProduct() {
    return sapProduct;
  }

  public void setSapProduct(String sapProduct) {
    this.sapProduct = sapProduct;
  }

  public String getQty() {
    return qty;
  }

  public void setQty(String qty) {
    this.qty = qty;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Date getSendtime() {
    return sendtime;
  }

  public void setSendtime(Date sendtime) {
    this.sendtime = sendtime;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }
}
