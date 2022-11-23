package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class CustomFieldDef {

  private String handle;

  private String tableName;

  private String fieldName;

  private String fieldLabel;

  private String required;

  private BigDecimal sequence;

  private String site;

  private Date createdDateTime;

  private Date modifiedDateTime;


  public CustomFieldDef() {
  }

  public CustomFieldDef(CustomFieldDef data) {
    this.handle = data.handle;
    this.tableName = data.tableName;
    this.fieldName = data.fieldName;
    this.fieldLabel = data.fieldLabel;
    this.required = data.required;
    this.sequence = data.sequence;
    this.site = data.site;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
  }


  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getFieldLabel() {
    return fieldLabel;
  }

  public void setFieldLabel(String fieldLabel) {
    this.fieldLabel = fieldLabel;
  }

  public String getRequired() {
    return required;
  }

  public void setRequired(String required) {
    this.required = required;
  }

  public BigDecimal getSequence() {
    return sequence;
  }

  public void setSequence(BigDecimal sequence) {
    this.sequence = sequence;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
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
  public CustomFieldDef clone() {
    return new CustomFieldDef(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
