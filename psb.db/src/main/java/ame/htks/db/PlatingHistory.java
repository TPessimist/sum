package ame.htks.db;

import ame.psb.commons.Env;
import java.math.BigDecimal;
import java.util.Date;

public class PlatingHistory {

  private String id;

  private String inventoryBo;

  private String resourceBo;

  private String itemBo;

  private String inventoryId;

  private String resourceName;

  private String itemName;

  private BigDecimal qty;

  private String action;

  private Date actionTime;

  private String actionUser;

  private String demo;

  private BigDecimal outWeight;

  private BigDecimal realWeight;

  public PlatingHistory() {
  }

  public PlatingHistory(PlatingHistory data) {
    this.id = data.id;
    this.inventoryBo = data.inventoryBo;
    this.resourceBo = data.resourceBo;
    this.itemBo = data.itemBo;
    this.inventoryId = Env.trimHandle(data.inventoryBo);
    this.resourceName = Env.trimHandle(data.resourceBo);
    this.itemName = Env.trimHandle(data.itemBo);
    this.qty = data.qty;
    this.action = data.action;
    this.actionTime = data.actionTime;
    this.actionUser = data.actionUser;
    this.demo = data.demo;
    this.outWeight = data.outWeight;
    this.realWeight = data.realWeight;
  }

  @Override
  public PlatingHistory clone() {
    return new PlatingHistory(this);
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

  public String getInventoryBo() {
    return inventoryBo;
  }

  public void setInventoryBo(String inventoryBo) {
    this.inventoryBo = inventoryBo;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public Date getActionTime() {
    return actionTime;
  }

  public void setActionTime(Date actionTime) {
    this.actionTime = actionTime;
  }

  public String getActionUser() {
    return actionUser;
  }

  public void setActionUser(String actionUser) {
    this.actionUser = actionUser;
  }

  public String getDemo() {
    return demo;
  }

  public void setDemo(String demo) {
    this.demo = demo;
  }

  public String getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public BigDecimal getOutWeight() {
    return outWeight;
  }

  public void setOutWeight(BigDecimal outWeight) {
    this.outWeight = outWeight;
  }

  public BigDecimal getRealWeight() {
    return realWeight;
  }

  public void setRealWeight(BigDecimal realWeight) {
    this.realWeight = realWeight;
  }

}
