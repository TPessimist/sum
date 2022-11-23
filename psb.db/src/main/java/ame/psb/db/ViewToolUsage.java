package ame.psb.db;

import java.util.Date;

public class ViewToolUsage {

  private String handle;

  private String toolNumberBo;

  private Integer toolLimitTimes;

  private Integer toolUsage;

  private Date eventDatetime;

  private String toolNumber;

  private String toolDescription;

  private String resourceBo;

  private Date startDateTime;

  private Date endDateTime;

  private String active;

  public ViewToolUsage() {
  }

  public ViewToolUsage(ViewToolUsage data) {
    this.handle = data.handle;
    this.toolNumberBo = data.toolNumberBo;
    this.toolLimitTimes = data.toolLimitTimes;
    this.toolUsage = data.toolUsage;
    this.eventDatetime = data.eventDatetime;
    this.toolNumber = data.toolNumber;
    this.toolDescription = data.toolDescription;
    this.resourceBo = data.resourceBo;
    this.startDateTime = data.startDateTime;
    this.endDateTime = data.endDateTime;
    this.active = data.active;
  }

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getToolNumberBo() {
    return this.toolNumberBo;
  }

  public void setToolNumberBo(String toolNumberBo) {
    this.toolNumberBo = toolNumberBo;
  }

  public Integer getToolLimitTimes() {
    return this.toolLimitTimes;
  }

  public void setToolLimitTimes(Integer toolLimitTimes) {
    this.toolLimitTimes = toolLimitTimes;
  }

  public Integer getToolUsage() {
    return this.toolUsage;
  }

  public void setToolUsage(Integer toolUsage) {
    this.toolUsage = toolUsage;
  }

  public Date getEventDatetime() {
    return this.eventDatetime;
  }

  public void setEventDatetime(Date eventDatetime) {
    this.eventDatetime = eventDatetime;
  }

  public String getToolNumber() {
    return this.toolNumber;
  }

  public void setToolNumber(String toolNumber) {
    this.toolNumber = toolNumber;
  }

  public String getToolDescription() {
    return this.toolDescription;
  }

  public void setToolDescription(String toolDescription) {
    this.toolDescription = toolDescription;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public Date getStartDateTime() {
    return this.startDateTime;
  }

  public void setStartDateTime(Date startDateTime) {
    this.startDateTime = startDateTime;
  }

  public Date getEndDateTime() {
    return this.endDateTime;
  }

  public void setEndDateTime(Date endDateTime) {
    this.endDateTime = endDateTime;
  }

  public String getActive() {
    return this.active;
  }

  public void setActive(String active) {
    this.active = active;
  }

  @Override
  public ViewToolUsage clone() {
    return new ViewToolUsage(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
