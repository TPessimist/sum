package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * @author Coffee
 */
public class DummyPlan {

  private String id;

  private String resourceBo;

  private String itemBo;

  private String beginOperationBo;

  private String endOperationBo;

  private Date chkFrom;

  private Date chkTo;

  private BigDecimal timeValue;

  private BigDecimal timeAlw;

  private BigDecimal countValue;

  private BigDecimal countAlw;

  private String stateName;

  private String updatedUser;

  private Date updatedTime;

  private String sfcBo;

  private String deviceBo;


  public DummyPlan() {
    this.id = UUID.randomUUID().toString();
  }

  public DummyPlan(DummyPlan data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.itemBo = data.itemBo;
    this.beginOperationBo = data.beginOperationBo;
    this.endOperationBo = data.endOperationBo;
    this.chkFrom = data.chkFrom;
    this.chkTo = data.chkTo;
    this.timeValue = data.timeValue;
    this.timeAlw = data.timeAlw;
    this.countValue = data.countValue;
    this.countAlw = data.countAlw;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.sfcBo = data.sfcBo;
    this.deviceBo = data.deviceBo;
  }

  @Override
  public DummyPlan clone() {
    return new DummyPlan(this);
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getDeviceBo() {
    return deviceBo;
  }

  public void setDeviceBo(String deviceBo) {
    this.deviceBo = deviceBo;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getBeginOperationBo() {
    return beginOperationBo;
  }

  public void setBeginOperationBo(String beginOperationBo) {
    this.beginOperationBo = beginOperationBo;
  }

  public String getEndOperationBo() {
    return endOperationBo;
  }

  public void setEndOperationBo(String endOperationBo) {
    this.endOperationBo = endOperationBo;
  }

  public Date getChkFrom() {
    return chkFrom;
  }

  public void setChkFrom(Date chkFrom) {
    this.chkFrom = chkFrom;
  }

  public Date getChkTo() {
    return chkTo;
  }

  public void setChkTo(Date chkTo) {
    this.chkTo = chkTo;
  }

  public BigDecimal getTimeValue() {
    return timeValue;
  }

  public void setTimeValue(BigDecimal timeValue) {
    this.timeValue = timeValue;
  }

  public BigDecimal getTimeAlw() {
    return timeAlw;
  }

  public void setTimeAlw(BigDecimal timeAlw) {
    this.timeAlw = timeAlw;
  }

  public BigDecimal getCountValue() {
    return countValue;
  }

  public void setCountValue(BigDecimal countValue) {
    this.countValue = countValue;
  }

  public BigDecimal getCountAlw() {
    return countAlw;
  }

  public void setCountAlw(BigDecimal countAlw) {
    this.countAlw = countAlw;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
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