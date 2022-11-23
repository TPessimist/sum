package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class RouteEvent {

  private String id;

  private Date eventTime;

  private String eventOwner;

  private String eventName;

  private String shopOrderBo;

  private String sfcBo;

  private String customerItemLotBo;

  private String customerItemBo;

  private String containerBo;

  private String stateName;

  private String carrierBo;

  private String customerBo;

  private String resourceBo;

  private String operationBo;

  private String runUser;

  private BigDecimal holdId;

  private String comment;

  public RouteEvent() {
    this.id = System.currentTimeMillis() + "::" + UUID.randomUUID().toString();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getEventTime() {
    return this.eventTime;
  }

  public void setEventTime(Date eventTime) {
    this.eventTime = eventTime;
  }

  public String getEventOwner() {
    return this.eventOwner;
  }

  public void setEventOwner(String eventOwner) {
    this.eventOwner = eventOwner;
  }

  public String getEventName() {
    return this.eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public String getShopOrderBo() {
    return this.shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
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

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCarrierBo() {
    return this.carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getCustomerBo() {
    return this.customerBo;
  }

  public void setCustomerBo(String customerBo) {
    this.customerBo = customerBo;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getRunUser() {
    return runUser;
  }

  public void setRunUser(String runUser) {
    this.runUser = runUser;
  }

  public String getContainerBo() {
    return containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public BigDecimal getHoldId() {
    return holdId;
  }

  public void setHoldId(BigDecimal holdId) {
    this.holdId = holdId;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
