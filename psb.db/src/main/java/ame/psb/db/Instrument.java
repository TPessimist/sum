package ame.psb.db;

import java.util.Date;

public class Instrument { //zd_instrument表实体类

  private String uuid; //主键

  private String category; //类别

  private String name; //仪器名称

  private String code; //代码

  private String description; //描述

  private Date createdDateTime; //创建时间

  private Date modifiedDateTime; //更新时间

  private String value; //备用列1

  private String comment; //备用列2

  private String remarks; //备用列3

  private String note; //备用列4

  public Instrument() {
  }

  public Instrument(Instrument data) {
    this.uuid = data.uuid;
    this.category = data.category;
    this.name = data.name;
    this.code = data.code;
    this.description = data.description;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.value = data.value;
    this.comment = data.comment;
    this.remarks = data.remarks;
    this.note = data.note;
  }

  @Override
  public Instrument clone() {
    return new Instrument(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
