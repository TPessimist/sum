package ame.psb.db;

import java.util.Date;

public class ViewPkgMultiLabelDependTag {

  private String labelBo;
  private String tagBo;
  private String reserveField1;
  private String reserveField2;
  private String updatedUser;
  private Date updatedTime;
  private String valuePattern;
  private String valueScript;
  private String description;
  private String valueType;
  private String tagType;

  public ViewPkgMultiLabelDependTag() {
  }

  public ViewPkgMultiLabelDependTag(ViewPkgMultiLabelDependTag data) {
    this.labelBo = data.labelBo;
    this.tagBo = data.tagBo;
    this.reserveField1 = data.reserveField1;
    this.reserveField2 = data.reserveField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.valuePattern = data.valuePattern;
    this.valueScript = data.valueScript;
    this.description = data.description;
    this.valueType = data.valueType;
    this.tagType = data.tagType;
  }

  public String getLabelBo() {
    return labelBo;
  }

  public void setLabelBo(String labelBo) {
    this.labelBo = labelBo;
  }

  public String getTagBo() {
    return tagBo;
  }

  public void setTagBo(String tagBo) {
    this.tagBo = tagBo;
  }

  public String getReserveField1() {
    return reserveField1;
  }

  public void setReserveField1(String reserveField1) {
    this.reserveField1 = reserveField1;
  }

  public String getReserveField2() {
    return reserveField2;
  }

  public void setReserveField2(String reserveField2) {
    this.reserveField2 = reserveField2;
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

  public String getValuePattern() {
    return valuePattern;
  }

  public void setValuePattern(String valuePattern) {
    this.valuePattern = valuePattern;
  }

  public String getValueScript() {
    return valueScript;
  }

  public void setValueScript(String valueScript) {
    this.valueScript = valueScript;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  public String getTagType() {
    return tagType;
  }

  public void setTagType(String tagType) {
    this.tagType = tagType;
  }

  @Override
  public ViewPkgMultiLabelDependTag clone() {
    return new ViewPkgMultiLabelDependTag(this);
  }

  @Override
  public String toString() {
    return this.labelBo;
  }
}
