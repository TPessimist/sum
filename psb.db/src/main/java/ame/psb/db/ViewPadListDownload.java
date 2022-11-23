package ame.psb.db;

public class ViewPadListDownload {

  private String taskId;

  private String resourceType;

  private String taskStepId;

  private String taskStepDesc;

  private String upControl;

  private String downControl;

  private String upWarn;

  private String downWarn;

  private String format;

  private String unit;

  private String picLink;

  private String resource;

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

  public String getTaskStepId() {
    return taskStepId;
  }

  public void setTaskStepId(String taskStepId) {
    this.taskStepId = taskStepId;
  }

  public String getTaskStepDesc() {
    return taskStepDesc;
  }

  public void setTaskStepDesc(String taskStepDesc) {
    this.taskStepDesc = taskStepDesc;
  }

  public String getUpControl() {
    return upControl;
  }

  public void setUpControl(String upControl) {
    this.upControl = upControl;
  }

  public String getDownControl() {
    return downControl;
  }

  public void setDownControl(String downControl) {
    this.downControl = downControl;
  }

  public String getUpWarn() {
    return upWarn;
  }

  public void setUpWarn(String upWarn) {
    this.upWarn = upWarn;
  }

  public String getDownWarn() {
    return downWarn;
  }

  public void setDownWarn(String downWarn) {
    this.downWarn = downWarn;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getPicLink() {
    return picLink;
  }

  public void setPicLink(String picLink) {
    this.picLink = picLink;
  }

}
