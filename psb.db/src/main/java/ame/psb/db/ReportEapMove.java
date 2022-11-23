package ame.psb.db;

public class ReportEapMove { //用于报工的存储工作

  private String id; //主键

  private String sfc; //生产批号

  private String sendDate; //日期

  private String shopOrder; //厂内工单

  private String sapOrder; //sap工单

  private String site; //站点

  private String dieQty; //总数

  private String vgw01; //耗时

  private String vge01; //单位

  private String itemList; //留空的物料list

  private String item; //留空的物料

  private String value; //状态 WAIT等待发送  ERROR发送失败  DONE发送成功  EXCEPTION代码发生异常

  private String comment; //返回码

  private String description; //返回内容


  public ReportEapMove() {
  }

  public ReportEapMove(ReportEapMove data) {
    this.id = data.id;
    this.sfc = data.sfc;
    this.sendDate = data.sendDate;
    this.shopOrder = data.shopOrder;
    this.sapOrder = data.sapOrder;
    this.site = data.site;
    this.dieQty = data.dieQty;
    this.vgw01 = data.vgw01;
    this.vge01 = data.vge01;
    this.itemList = data.itemList;
    this.item = data.item;
    this.value = data.value;
    this.comment = data.comment;
    this.description = data.description;
  }

  @Override
  public ReportEapMove clone() {
    return new ReportEapMove(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getSendDate() {
    return sendDate;
  }

  public void setSendDate(String sendDate) {
    this.sendDate = sendDate;
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

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getDieQty() {
    return dieQty;
  }

  public void setDieQty(String dieQty) {
    this.dieQty = dieQty;
  }

  public String getVgw01() {
    return vgw01;
  }

  public void setVgw01(String vgw01) {
    this.vgw01 = vgw01;
  }

  public String getVge01() {
    return vge01;
  }

  public void setVge01(String vge01) {
    this.vge01 = vge01;
  }

  public String getItemList() {
    return itemList;
  }

  public void setItemList(String itemList) {
    this.itemList = itemList;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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
}
