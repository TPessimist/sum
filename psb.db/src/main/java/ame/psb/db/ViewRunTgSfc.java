package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ViewRunTgSfc {

  private String resourceBo;

  private String toolNumberBo;

  private Date eventDatetime;

  private String toolGroupBo;

  private BigDecimal qtyLimit;

  private BigDecimal qtyCurrent;

  private String sfcBo;

  private String itemBo;

  private String operationBo;

  private String resourceName;

  private String sfcName;

  private String toolNumber;

  public ViewRunTgSfc() {
  }

  public ViewRunTgSfc(ViewRunTgSfc data) {
    this.resourceBo = data.resourceBo;
    this.toolNumberBo = data.toolNumberBo;
    this.eventDatetime = data.eventDatetime;
    this.toolGroupBo = data.toolGroupBo;
    this.qtyLimit = data.qtyLimit;
    this.qtyCurrent = data.qtyCurrent;
    this.sfcBo = data.sfcBo;
    this.itemBo = data.itemBo;
    this.operationBo = data.operationBo;
    this.resourceName = data.resourceName;
    this.sfcName = data.sfcName;
    this.toolNumber = data.toolNumber;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getToolNumberBo() {
    return this.toolNumberBo;
  }

  public void setToolNumberBo(String toolNumberBo) {
    this.toolNumberBo = toolNumberBo;
  }

  public Date getEventDatetime() {
    return this.eventDatetime;
  }

  public void setEventDatetime(Date eventDatetime) {
    this.eventDatetime = eventDatetime;
  }

  public String getToolGroupBo() {
    return this.toolGroupBo;
  }

  public void setToolGroupBo(String toolGroupBo) {
    this.toolGroupBo = toolGroupBo;
  }

  public BigDecimal getQtyLimit() {
    return this.qtyLimit;
  }

  public void setQtyLimit(BigDecimal qtyLimit) {
    this.qtyLimit = qtyLimit;
  }

  public BigDecimal getQtyCurrent() {
    return this.qtyCurrent;
  }

  public void setQtyCurrent(BigDecimal qtyCurrent) {
    this.qtyCurrent = qtyCurrent;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
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

  public String getResourceName() {
    return this.resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getSfcName() {
    return this.sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getToolNumber() {
    return this.toolNumber;
  }

  public void setToolNumber(String toolNumber) {
    this.toolNumber = toolNumber;
  }

  @Override
  public ViewRunTgSfc clone() {
    return new ViewRunTgSfc(this);
  }

  @Override
  public String toString() {
    return this.resourceBo;
  }
}
