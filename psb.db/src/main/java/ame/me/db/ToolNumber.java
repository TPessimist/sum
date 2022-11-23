package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class ToolNumber {

  private String handle;

  private String site;

  private String toolNumber;

  private String toolGroupBo;

  private String description;

  private String statusBo;

  private BigDecimal qty;

  private String location;

  private String calibrationType;

  private Date calibrationDate;

  private BigDecimal calibrationPeriod;

  private String calibrationPeriodType;

  private Date expDate;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String erpPlantMaintOrder;

  private String erpEquipmentNumber;


  public ToolNumber() {
  }

  public ToolNumber(ToolNumber data) {
    this.handle = data.handle;
    this.site = data.site;
    this.toolNumber = data.toolNumber;
    this.toolGroupBo = data.toolGroupBo;
    this.description = data.description;
    this.statusBo = data.statusBo;
    this.qty = data.qty;
    this.location = data.location;
    this.calibrationType = data.calibrationType;
    this.calibrationDate = data.calibrationDate;
    this.calibrationPeriod = data.calibrationPeriod;
    this.calibrationPeriodType = data.calibrationPeriodType;
    this.expDate = data.expDate;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.erpPlantMaintOrder = data.erpPlantMaintOrder;
    this.erpEquipmentNumber = data.erpEquipmentNumber;
  }

  @Override
  public ToolNumber clone() {
    return new ToolNumber(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getToolNumber() {
    return toolNumber;
  }

  public void setToolNumber(String toolNumber) {
    this.toolNumber = toolNumber;
  }

  public String getToolGroupBo() {
    return toolGroupBo;
  }

  public void setToolGroupBo(String toolGroupBo) {
    this.toolGroupBo = toolGroupBo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatusBo() {
    return statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getCalibrationType() {
    return calibrationType;
  }

  public void setCalibrationType(String calibrationType) {
    this.calibrationType = calibrationType;
  }

  public Date getCalibrationDate() {
    return calibrationDate;
  }

  public void setCalibrationDate(Date calibrationDate) {
    this.calibrationDate = calibrationDate;
  }

  public BigDecimal getCalibrationPeriod() {
    return calibrationPeriod;
  }

  public void setCalibrationPeriod(BigDecimal calibrationPeriod) {
    this.calibrationPeriod = calibrationPeriod;
  }

  public String getCalibrationPeriodType() {
    return calibrationPeriodType;
  }

  public void setCalibrationPeriodType(String calibrationPeriodType) {
    this.calibrationPeriodType = calibrationPeriodType;
  }

  public Date getExpDate() {
    return expDate;
  }

  public void setExpDate(Date expDate) {
    this.expDate = expDate;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Date getModifiedDateTime() {
    return modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public String getErpPlantMaintOrder() {
    return erpPlantMaintOrder;
  }

  public void setErpPlantMaintOrder(String erpPlantMaintOrder) {
    this.erpPlantMaintOrder = erpPlantMaintOrder;
  }

  public String getErpEquipmentNumber() {
    return erpEquipmentNumber;
  }

  public void setErpEquipmentNumber(String erpEquipmentNumber) {
    this.erpEquipmentNumber = erpEquipmentNumber;
  }
}

