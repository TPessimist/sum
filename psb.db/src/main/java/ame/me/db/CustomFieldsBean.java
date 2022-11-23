package ame.me.db;

import java.util.Date;

public class CustomFieldsBean {

  private String handle;

  private String attribute;

  private String value;

  private Date createdDateTime;

  private Date updatedDateTime;

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getAttribute() {
    return this.attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  public String getValue() {
    return this.value;
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

  public Date getUpdatedDateTime() {
    return updatedDateTime;
  }

  public void setUpdatedDateTime(Date updatedDateTime) {
    this.updatedDateTime = updatedDateTime;
  }

  @Override
  public String toString() {
    return this.attribute + "=" + this.value;
  }

}
