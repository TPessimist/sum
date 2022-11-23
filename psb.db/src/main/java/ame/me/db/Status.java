package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class Status {

  private String handle;

  private BigDecimal changeStamp;

  private String site;

  private String status;

  private String statusGroup;

  private String statusDescription;

  private String defaultStatus;

  private Date createdDateTime;

  private Date modifiedDateTime;


  public Status() {
  }

  public Status(Status data) {
    this.handle = data.handle;
    this.changeStamp = data.changeStamp;
    this.site = data.site;
    this.status = data.status;
    this.statusGroup = data.statusGroup;
    this.statusDescription = data.statusDescription;
    this.defaultStatus = data.defaultStatus;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public BigDecimal getChangeStamp() {
    return changeStamp;
  }

  public void setChangeStamp(BigDecimal changeStamp) {
    this.changeStamp = changeStamp;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatusGroup() {
    return statusGroup;
  }

  public void setStatusGroup(String statusGroup) {
    this.statusGroup = statusGroup;
  }

  public String getStatusDescription() {
    return statusDescription;
  }

  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }

  public String getDefaultStatus() {
    return defaultStatus;
  }

  public void setDefaultStatus(String defaultStatus) {
    this.defaultStatus = defaultStatus;
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

  @Override
  public Status clone() {
    return new Status(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}