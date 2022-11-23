package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ZhToolHistory {

  private String resourceBo;

  private String toolNumberBo;

  private Date eventDatetime;

  private String toolGroupBo;

  private BigDecimal qtyLimit;

  private BigDecimal qtyCurrent;

  private String sfcBo;

  private BigDecimal sfcQty;

  private String itemBo;

  private String operationBo;


  public ZhToolHistory() {
  }

  public ZhToolHistory(ZhToolHistory data) {
    this.resourceBo = data.resourceBo;
    this.toolNumberBo = data.toolNumberBo;
    this.eventDatetime = data.eventDatetime;
    this.toolGroupBo = data.toolGroupBo;
    this.qtyLimit = data.qtyLimit;
    this.qtyCurrent = data.qtyCurrent;
    this.sfcBo = data.sfcBo;
    this.sfcQty = data.sfcQty;
    this.itemBo = data.itemBo;
    this.operationBo = data.operationBo;
  }

  @Override
  public ZhToolHistory clone() {
    return new ZhToolHistory(this);
  }

  @Override
  public String toString() {
    return this.resourceBo + ", " + this.toolNumberBo + ", " + this.eventDatetime;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getToolNumberBo() {
    return toolNumberBo;
  }

  public void setToolNumberBo(String toolNumberBo) {
    this.toolNumberBo = toolNumberBo;
  }

  public Date getEventDatetime() {
    return eventDatetime;
  }

  public void setEventDatetime(Date eventDatetime) {
    this.eventDatetime = eventDatetime;
  }

  public String getToolGroupBo() {
    return toolGroupBo;
  }

  public void setToolGroupBo(String toolGroupBo) {
    this.toolGroupBo = toolGroupBo;
  }

  public BigDecimal getQtyLimit() {
    return qtyLimit;
  }

  public void setQtyLimit(BigDecimal qtyLimit) {
    this.qtyLimit = qtyLimit;
  }

  public BigDecimal getQtyCurrent() {
    return qtyCurrent;
  }

  public void setQtyCurrent(BigDecimal qtyCurrent) {
    this.qtyCurrent = qtyCurrent;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public BigDecimal getSfcQty() {
    return sfcQty;
  }

  public void setSfcQty(BigDecimal sfcQty) {
    this.sfcQty = sfcQty;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

}