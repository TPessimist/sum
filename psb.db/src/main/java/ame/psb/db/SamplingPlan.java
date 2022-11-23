package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class SamplingPlan {

  private String id;

  private String customerBo;

  private String itemGroupBo;

  private String itemBo;

  private String lotType;

  private String measurementOperationBo;

  private Integer samplingRatioNmrtr;

  private Integer resetCardinality;

  private String samplingType;

  private Integer beginQty;

  private Integer centerQty;

  private Integer endQty;

  private String position;

  private Integer intervalQty;

  private String dcGroupBo;

  private String status;

  private Integer resetTotal;

  private String updatedUser;

  private Date updatedTime;

  public SamplingPlan() {
    this.id = UUID.randomUUID().toString();
    this.status = "Y";
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCustomerBo() {
    return this.customerBo;
  }

  public void setCustomerBo(String customerBo) {
    this.customerBo = customerBo;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getLotType() {
    return this.lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  public String getMeasurementOperationBo() {
    return this.measurementOperationBo;
  }

  public void setMeasurementOperationBo(String measurementOperationBo) {
    this.measurementOperationBo = measurementOperationBo;
  }

  public Integer getSamplingRatioNmrtr() {
    return this.samplingRatioNmrtr;
  }

  public void setSamplingRatioNmrtr(Integer samplingRatioNmrtr) {
    this.samplingRatioNmrtr = samplingRatioNmrtr;
  }

  public Integer getResetCardinality() {
    return this.resetCardinality;
  }

  public void setResetCardinality(Integer resetCardinality) {
    this.resetCardinality = resetCardinality;
  }

  public String getSamplingType() {
    return this.samplingType;
  }

  public void setSamplingType(String samplingType) {
    this.samplingType = samplingType;
  }

  public Integer getBeginQty() {
    return this.beginQty;
  }

  public void setBeginQty(Integer beginQty) {
    this.beginQty = beginQty;
  }

  public Integer getCenterQty() {
    return this.centerQty;
  }

  public void setCenterQty(Integer centerQty) {
    this.centerQty = centerQty;
  }

  public Integer getEndQty() {
    return this.endQty;
  }

  public void setEndQty(Integer endQty) {
    this.endQty = endQty;
  }

  public String getPosition() {
    return this.position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Integer getIntervalQty() {
    return this.intervalQty;
  }

  public void setIntervalQty(Integer intervalQty) {
    this.intervalQty = intervalQty;
  }

  public String getDcGroupBo() {
    return this.dcGroupBo;
  }

  public void setDcGroupBo(String dcGroupBo) {
    this.dcGroupBo = dcGroupBo;
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

  public Integer getResetTotal() {
    return this.resetTotal;
  }

  public void setResetTotal(Integer resetTotal) {
    this.resetTotal = resetTotal;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return this.id;
  }
}