package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class FutureActionSamplingPlan {

  private String id;

  private String futureActionBo;

  private String itemsetName;

  private String shopOrderBo;

  private String sfcBo;

  private String itemName;

  private String lotType;

  private String measurementOperationBo;

  private BigDecimal samplingRatioNmrtr;

  private BigDecimal resetCardinality;

  private String samplingType;

  private BigDecimal beginQty;

  private BigDecimal centerQty;

  private BigDecimal endQty;

  private String position;

  private BigDecimal intervalQty;

  private String dcGroupBo;

  private String status;

  private BigDecimal resetTotal;

  private String updatedUser;

  private Date updatedTime;


  public FutureActionSamplingPlan() {
  }

  public FutureActionSamplingPlan(FutureActionSamplingPlan data) {
    this.id = data.id;
    this.futureActionBo = data.futureActionBo;
    this.itemsetName = data.itemsetName;
    this.shopOrderBo = data.shopOrderBo;
    this.sfcBo = data.sfcBo;
    this.itemName = data.itemName;
    this.lotType = data.lotType;
    this.measurementOperationBo = data.measurementOperationBo;
    this.samplingRatioNmrtr = data.samplingRatioNmrtr;
    this.resetCardinality = data.resetCardinality;
    this.samplingType = data.samplingType;
    this.beginQty = data.beginQty;
    this.centerQty = data.centerQty;
    this.endQty = data.endQty;
    this.position = data.position;
    this.intervalQty = data.intervalQty;
    this.dcGroupBo = data.dcGroupBo;
    this.status = data.status;
    this.resetTotal = data.resetTotal;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public FutureActionSamplingPlan clone() {
    return new FutureActionSamplingPlan(this);
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

  public String getFutureActionBo() {
    return futureActionBo;
  }

  public void setFutureActionBo(String futureActionBo) {
    this.futureActionBo = futureActionBo;
  }

  public String getItemsetName() {
    return itemsetName;
  }

  public void setItemsetName(String itemsetName) {
    this.itemsetName = itemsetName;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getLotType() {
    return lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  public String getMeasurementOperationBo() {
    return measurementOperationBo;
  }

  public void setMeasurementOperationBo(String measurementOperationBo) {
    this.measurementOperationBo = measurementOperationBo;
  }

  public BigDecimal getSamplingRatioNmrtr() {
    return samplingRatioNmrtr;
  }

  public void setSamplingRatioNmrtr(BigDecimal samplingRatioNmrtr) {
    this.samplingRatioNmrtr = samplingRatioNmrtr;
  }

  public BigDecimal getResetCardinality() {
    return resetCardinality;
  }

  public void setResetCardinality(BigDecimal resetCardinality) {
    this.resetCardinality = resetCardinality;
  }

  public String getSamplingType() {
    return samplingType;
  }

  public void setSamplingType(String samplingType) {
    this.samplingType = samplingType;
  }

  public BigDecimal getBeginQty() {
    return beginQty;
  }

  public void setBeginQty(BigDecimal beginQty) {
    this.beginQty = beginQty;
  }

  public BigDecimal getCenterQty() {
    return centerQty;
  }

  public void setCenterQty(BigDecimal centerQty) {
    this.centerQty = centerQty;
  }

  public BigDecimal getEndQty() {
    return endQty;
  }

  public void setEndQty(BigDecimal endQty) {
    this.endQty = endQty;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public BigDecimal getIntervalQty() {
    return intervalQty;
  }

  public void setIntervalQty(BigDecimal intervalQty) {
    this.intervalQty = intervalQty;
  }

  public String getDcGroupBo() {
    return dcGroupBo;
  }

  public void setDcGroupBo(String dcGroupBo) {
    this.dcGroupBo = dcGroupBo;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BigDecimal getResetTotal() {
    return resetTotal;
  }

  public void setResetTotal(BigDecimal resetTotal) {
    this.resetTotal = resetTotal;
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
