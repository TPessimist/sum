package ame.psb.db;

import java.util.Date;

public class ResourceBalanceSetting {

  private String prefixResource;

  private String seq;

  private String fieldName;

  private String fieldValue;

  private String updatedUser;

  private Date updatedTime;


  public ResourceBalanceSetting() {
  }

  public ResourceBalanceSetting(ResourceBalanceSetting data) {
    this.prefixResource = data.prefixResource;
    this.seq = data.seq;
    this.fieldName = data.fieldName;
    this.fieldValue = data.fieldValue;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public ResourceBalanceSetting clone() {
    return new ResourceBalanceSetting(this);
  }

  @Override
  public String toString() {
    return this.prefixResource + ", " + this.seq + ", " + this.fieldName;
  }

  public String getPrefixResource() {
    return this.prefixResource;
  }

  public void setPrefixResource(String prefixResource) {
    this.prefixResource = prefixResource;
  }

  public String getSeq() {
    return this.seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }

  public String getFieldName() {
    return this.fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getFieldValue() {
    return this.fieldValue;
  }

  public void setFieldValue(String fieldValue) {
    this.fieldValue = fieldValue;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
