package ame.sap.db;

import java.math.BigDecimal;
import java.util.Date;

public class Picture68PlatGroup {

  private String groupId;

  private BigDecimal groupSeq;

  private String deviceName;

  private String stateName;

  private String rootSfc;

  private String sfcBo;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public Picture68PlatGroup() {
  }

  public Picture68PlatGroup(Picture68PlatGroup data) {
    this.groupId = data.groupId;
    this.groupSeq = data.groupSeq;
    this.deviceName = data.deviceName;
    this.stateName = data.stateName;
    this.rootSfc = data.rootSfc;
    this.sfcBo = data.sfcBo;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public BigDecimal getGroupSeq() {
    return groupSeq;
  }

  public void setGroupSeq(BigDecimal groupSeq) {
    this.groupSeq = groupSeq;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getRootSfc() {
    return rootSfc;
  }

  public void setRootSfc(String rootSfc) {
    this.rootSfc = rootSfc;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getReversedField1() {
    return reversedField1;
  }

  public void setReversedField1(String reversedField1) {
    this.reversedField1 = reversedField1;
  }

  public String getReversedField2() {
    return reversedField2;
  }

  public void setReversedField2(String reversedField2) {
    this.reversedField2 = reversedField2;
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

  @Override
  public Picture68PlatGroup clone() {
    return new Picture68PlatGroup(this);
  }

  @Override
  public String toString() {
    return this.groupId + ", " + this.groupSeq;
  }
}
