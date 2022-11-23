package ame.me.db;

import java.util.Date;

public class ToolTimeLog {

  private String handle;

  private String site;

  private String resourceBo;

  private String toolNumberBo;

  private String strt;

  private Date startDateTime;

  private Date endDateTime;

  private String activityBo;

  private String active;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private Date partitionDate;


  public ToolTimeLog() {
  }

  public ToolTimeLog(ToolTimeLog data) {
    this.handle = data.handle;
    this.site = data.site;
    this.resourceBo = data.resourceBo;
    this.toolNumberBo = data.toolNumberBo;
    this.strt = data.strt;
    this.startDateTime = data.startDateTime;
    this.endDateTime = data.endDateTime;
    this.activityBo = data.activityBo;
    this.active = data.active;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.partitionDate = data.partitionDate;
  }

  @Override
  public ToolTimeLog clone() {
    return new ToolTimeLog(this);
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

  public String getStrt() {
    return strt;
  }

  public void setStrt(String strt) {
    this.strt = strt;
  }

  public Date getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(Date startDateTime) {
    this.startDateTime = startDateTime;
  }

  public Date getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(Date endDateTime) {
    this.endDateTime = endDateTime;
  }

  public String getActivityBo() {
    return activityBo;
  }

  public void setActivityBo(String activityBo) {
    this.activityBo = activityBo;
  }

  public String getActive() {
    return active;
  }

  public void setActive(String active) {
    this.active = active;
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

  public Date getPartitionDate() {
    return partitionDate;
  }

  public void setPartitionDate(Date partitionDate) {
    this.partitionDate = partitionDate;
  }


}