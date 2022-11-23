package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Coffee
 */
public class ToolGroup {

  private String handle;

  private String site;

  private String toolGroup;

  private String description;

  private String statusBo;

  private String trackCtl;

  private BigDecimal qty;

  private String location;

  private String timeBased;

  private String erp;

  private String calibrationType;

  private BigDecimal calibrationPeriod;

  private String calibrationPeriodType;

  private Date expDate;

  private Date createdDateTime;

  private Date modifiedDateTime;


  public ToolGroup() {
  }

  public ToolGroup(ToolGroup data) {
    this.handle = data.handle;
    this.site = data.site;
    this.toolGroup = data.toolGroup;
    this.description = data.description;
    this.statusBo = data.statusBo;
    this.trackCtl = data.trackCtl;
    this.qty = data.qty;
    this.location = data.location;
    this.timeBased = data.timeBased;
    this.erp = data.erp;
    this.calibrationType = data.calibrationType;
    this.calibrationPeriod = data.calibrationPeriod;
    this.calibrationPeriodType = data.calibrationPeriodType;
    this.expDate = data.expDate;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
  }

  @Override
  public ToolGroup clone() {
    return new ToolGroup(this);
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

  public String getToolGroup() {
    return toolGroup;
  }

  public void setToolGroup(String toolGroup) {
    this.toolGroup = toolGroup;
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

  public String getTrackCtl() {
    return trackCtl;
  }

  public void setTrackCtl(String trackCtl) {
    this.trackCtl = trackCtl;
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

  public String getTimeBased() {
    return timeBased;
  }

  public void setTimeBased(String timeBased) {
    this.timeBased = timeBased;
  }

  public String getErp() {
    return erp;
  }

  public void setErp(String erp) {
    this.erp = erp;
  }

  public String getCalibrationType() {
    return calibrationType;
  }

  public void setCalibrationType(String calibrationType) {
    this.calibrationType = calibrationType;
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
}
