package ame.psb.db;

import java.util.Date;

public class ViewMcsLayoutCfs {

  private String resourceBo;

  private String nextResourceBo;

  private String bayBo;

  private String comment;

  private Date updatedTime;

  private String updatedUser;

  private String attribute;

  private String value;

  private Date createdDateTime;

  private Date modifiedDateTime;


  public ViewMcsLayoutCfs() {
  }

  public ViewMcsLayoutCfs(ViewMcsLayoutCfs data) {
    this.resourceBo = data.resourceBo;
    this.nextResourceBo = data.nextResourceBo;
    this.bayBo = data.bayBo;
    this.comment = data.comment;
    this.updatedTime = data.updatedTime;
    this.updatedUser = data.updatedUser;
    this.attribute = data.attribute;
    this.value = data.value;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
  }


  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getNextResourceBo() {
    return nextResourceBo;
  }

  public void setNextResourceBo(String nextResourceBo) {
    this.nextResourceBo = nextResourceBo;
  }

  public String getBayBo() {
    return bayBo;
  }

  public void setBayBo(String bayBo) {
    this.bayBo = bayBo;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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
  public ViewMcsLayoutCfs clone() {
    return new ViewMcsLayoutCfs(this);
  }

  @Override
  public String toString() {
    return this.resourceBo;
  }
}
