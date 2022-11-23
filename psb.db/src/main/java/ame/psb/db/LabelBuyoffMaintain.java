package ame.psb.db;

import java.util.Date;

public class LabelBuyoffMaintain {

  private String uuid;

  private String labelId;

  private String subid;

  private String codeType;

  private int beginIndex;

  private int endIndex;

  private String codeValue;

  private String description;

  private String comment;

  private String note;

  private String updatedUser;

  private Date updatedTime;


  public LabelBuyoffMaintain() {
  }

  public LabelBuyoffMaintain(LabelBuyoffMaintain data) {
    this.uuid = data.uuid;
    this.labelId = data.labelId;
    this.subid = data.subid;
    this.codeType = data.codeType;
    this.beginIndex = data.beginIndex;
    this.endIndex = data.endIndex;
    this.codeValue = data.codeValue;
    this.description = data.description;
    this.comment = data.comment;
    this.note = data.note;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public LabelBuyoffMaintain clone() {
    return new LabelBuyoffMaintain(this);
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

  public String getLabelId() {
    return labelId;
  }

  public void setLabelId(String labelId) {
    this.labelId = labelId;
  }

  public String getSubid() {
    return subid;
  }

  public void setSubid(String subid) {
    this.subid = subid;
  }

  public String getCodeType() {
    return codeType;
  }

  public void setCodeType(String codeType) {
    this.codeType = codeType;
  }

  public int getBeginIndex() {
    return beginIndex;
  }

  public void setBeginIndex(int beginIndex) {
    this.beginIndex = beginIndex;
  }

  public int getEndIndex() {
    return endIndex;
  }

  public void setEndIndex(int endIndex) {
    this.endIndex = endIndex;
  }

  public String getCodeValue() {
    return codeValue;
  }

  public void setCodeValue(String codeValue) {
    this.codeValue = codeValue;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
