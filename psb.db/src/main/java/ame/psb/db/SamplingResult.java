package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class SamplingResult {

  private String id;

  private String samplingPlanBo;

  private String sourceOperationBo;

  private String measurementOperationBo;

  private String dcGroupBo;

  private String carrierBo;

  private String sfcBo;

  private String customerBo;

  private String itemGroupBo;

  private String itemBo;

  private String lotType;

  private String samplingType;

  private String position;

  private String dcPlanBo;

  private String status;

  private Date updatedTime;

  public SamplingResult() {
    this.id = UUID.randomUUID().toString();
  }

  public SamplingResult(SamplingResult data) {
    this.id = data.id;
    this.samplingPlanBo = data.samplingPlanBo;
    this.sourceOperationBo = data.sourceOperationBo;
    this.measurementOperationBo = data.measurementOperationBo;
    this.dcGroupBo = data.dcGroupBo;
    this.carrierBo = data.carrierBo;
    this.sfcBo = data.sfcBo;
    this.customerBo = data.customerBo;
    this.itemGroupBo = data.itemGroupBo;
    this.itemBo = data.itemBo;
    this.lotType = data.lotType;
    this.samplingType = data.samplingType;
    this.position = data.position;
    this.dcPlanBo = data.dcPlanBo;
    this.status = data.status;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSamplingPlanBo() {
    return this.samplingPlanBo;
  }

  public void setSamplingPlanBo(String samplingPlanBo) {
    this.samplingPlanBo = samplingPlanBo;
  }

  public String getSourceOperationBo() {
    return this.sourceOperationBo;
  }

  public void setSourceOperationBo(String sourceOperationBo) {
    this.sourceOperationBo = sourceOperationBo;
  }

  public String getMeasurementOperationBo() {
    return this.measurementOperationBo;
  }

  public void setMeasurementOperationBo(String measurementOperationBo) {
    this.measurementOperationBo = measurementOperationBo;
  }

  public String getDcGroupBo() {
    return this.dcGroupBo;
  }

  public void setDcGroupBo(String dcGroupBo) {
    this.dcGroupBo = dcGroupBo;
  }

  public String getCarrierBo() {
    return this.carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
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

  public String getSamplingType() {
    return this.samplingType;
  }

  public void setSamplingType(String samplingType) {
    this.samplingType = samplingType;
  }

  public String getPosition() {
    return this.position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDcPlanBo() {
    return this.dcPlanBo;
  }

  public void setDcPlanBo(String dcPlanBo) {
    this.dcPlanBo = dcPlanBo;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  @Override
  public SamplingResult clone() {
    return new SamplingResult(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}