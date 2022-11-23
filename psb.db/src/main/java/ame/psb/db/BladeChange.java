package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class BladeChange {

  private String uuid;

  private String resourceId;

  private String zone;

  private BigDecimal systemZone;

  private BigDecimal actualZone;

  private String zoneFlag;

  private String ztwo;

  private BigDecimal systemZtwo;

  private BigDecimal actualZtwo;

  private String ztwoFlag;

  private String oldZone;

  private String oldZoneFlag;

  private String oldZtwo;

  private String oldZtwoFlag;

  private String idFlag;

  private String content1;

  private String content2;

  private String updatedUser;

  private Date updatedTime;

  public BladeChange() {
  }

  public BladeChange(BladeChange data) {
    this.uuid = data.uuid;
    this.resourceId = data.resourceId;
    this.zone = data.zone;
    this.systemZone = data.systemZone;
    this.actualZone = data.actualZone;
    this.zoneFlag = data.zoneFlag;
    this.ztwo = data.ztwo;
    this.systemZtwo = data.systemZtwo;
    this.actualZtwo = data.actualZtwo;
    this.ztwoFlag = data.ztwoFlag;
    this.oldZone = data.oldZone;
    this.oldZoneFlag = data.oldZoneFlag;
    this.oldZtwo = data.oldZtwo;
    this.oldZtwoFlag = data.oldZtwoFlag;
    this.idFlag = data.idFlag;
    this.content1 = data.content1;
    this.content2 = data.content2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public String getZone() {
    return zone;
  }

  public void setZone(String zone) {
    this.zone = zone;
  }

  public BigDecimal getSystemZone() {
    return systemZone;
  }

  public void setSystemZone(BigDecimal systemZone) {
    this.systemZone = systemZone;
  }

  public BigDecimal getActualZone() {
    return actualZone;
  }

  public void setActualZone(BigDecimal actualZone) {
    this.actualZone = actualZone;
  }

  public String getZoneFlag() {
    return zoneFlag;
  }

  public void setZoneFlag(String zoneFlag) {
    this.zoneFlag = zoneFlag;
  }

  public String getZtwo() {
    return ztwo;
  }

  public void setZtwo(String ztwo) {
    this.ztwo = ztwo;
  }

  public BigDecimal getSystemZtwo() {
    return systemZtwo;
  }

  public void setSystemZtwo(BigDecimal systemZtwo) {
    this.systemZtwo = systemZtwo;
  }

  public BigDecimal getActualZtwo() {
    return actualZtwo;
  }

  public void setActualZtwo(BigDecimal actualZtwo) {
    this.actualZtwo = actualZtwo;
  }

  public String getZtwoFlag() {
    return ztwoFlag;
  }

  public void setZtwoFlag(String ztwoFlag) {
    this.ztwoFlag = ztwoFlag;
  }

  public String getOldZone() {
    return oldZone;
  }

  public void setOldZone(String oldZone) {
    this.oldZone = oldZone;
  }

  public String getOldZoneFlag() {
    return oldZoneFlag;
  }

  public void setOldZoneFlag(String oldZoneFlag) {
    this.oldZoneFlag = oldZoneFlag;
  }

  public String getOldZtwo() {
    return oldZtwo;
  }

  public void setOldZtwo(String oldZtwo) {
    this.oldZtwo = oldZtwo;
  }

  public String getOldZtwoFlag() {
    return oldZtwoFlag;
  }

  public void setOldZtwoFlag(String oldZtwoFlag) {
    this.oldZtwoFlag = oldZtwoFlag;
  }

  public String getIdFlag() {
    return idFlag;
  }

  public void setIdFlag(String idFlag) {
    this.idFlag = idFlag;
  }

  public String getContent1() {
    return content1;
  }

  public void setContent1(String content1) {
    this.content1 = content1;
  }

  public String getContent2() {
    return content2;
  }

  public void setContent2(String content2) {
    this.content2 = content2;
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
  public BladeChange clone() {
    return new BladeChange(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }
}
