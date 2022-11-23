package ame.psb.db;

import java.util.Date;

public class ViewPadTaskList {

  private String resource;

  private String taskId;

  private String taskDesc;

  private String resourceDesc;

  private Date startTime;

  private Date nextTime;

  private int toleranceTime;

  private String toleranceUnit;

  private String resourceType;

  public Date getNextTime() {
    return nextTime;
  }

  public void setNextTime(Date nextTime) {
    this.nextTime = nextTime;
  }

  public int getToleranceTime() {
    return toleranceTime;
  }

  public void setToleranceTime(int toleranceTime) {
    this.toleranceTime = toleranceTime;
  }

  public String getToleranceUnit() {
    return toleranceUnit;
  }

  public void setToleranceUnit(String toleranceUnit) {
    this.toleranceUnit = toleranceUnit;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public String getTaskDesc() {
    return taskDesc;
  }

  public void setTaskDesc(String taskDesc) {
    this.taskDesc = taskDesc;
  }

  public String getResourceDesc() {
    return resourceDesc;
  }

  public void setResourceDesc(String resourceDesc) {
    this.resourceDesc = resourceDesc;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

}
