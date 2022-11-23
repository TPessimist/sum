package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class OperationMapGenerate {

  private String id;

  private String type;

  private String operationBo;

  private String sfcBo;

  private String customerItemBo;

  private String fileName;

  private String updatedUser;

  private Date updatedDateTime;

  private String markFileName;

  private String changedDies;

  private String dieMarkModified;

  private Date markModifiedTime;

  private String markUser;

  private String repeatMapCheck;

  private String slotCheck;

  private String mapCheck;

  private String stdfCheck;

  private String resourceName;

  public OperationMapGenerate() {
    this.id = UUID.randomUUID().toString();
  }

  public OperationMapGenerate(OperationMapGenerate data) {
    this.id = data.id;
    this.type = data.type;
    this.operationBo = data.operationBo;
    this.sfcBo = data.sfcBo;
    this.customerItemBo = data.customerItemBo;
    this.fileName = data.fileName;
    this.updatedUser = data.updatedUser;
    this.updatedDateTime = data.updatedDateTime;
    this.markFileName = data.markFileName;
    this.changedDies = data.changedDies;
    this.dieMarkModified = data.dieMarkModified;
    this.markModifiedTime = data.markModifiedTime;
    this.markUser = data.markUser;
    this.repeatMapCheck = data.repeatMapCheck;
    this.slotCheck = data.slotCheck;
    this.mapCheck = data.mapCheck;
    this.stdfCheck = data.stdfCheck;
    this.resourceName = data.resourceName;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getFileName() {
    return this.fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedDateTime() {
    return this.updatedDateTime;
  }

  public void setUpdatedDateTime(Date updatedDateTime) {
    this.updatedDateTime = updatedDateTime;
  }

  public String getMarkFileName() {
    return markFileName;
  }

  public void setMarkFileName(String markFileName) {
    this.markFileName = markFileName;
  }

  public String getChangedDies() {
    return changedDies;
  }

  public void setChangedDies(String changedDies) {
    this.changedDies = changedDies;
  }

  public String getDieMarkModified() {
    return dieMarkModified;
  }

  public void setDieMarkModified(String dieMarkModified) {
    this.dieMarkModified = dieMarkModified;
  }

  public Date getMarkModifiedTime() {
    return markModifiedTime;
  }

  public void setMarkModifiedTime(Date markModifiedTime) {
    this.markModifiedTime = markModifiedTime;
  }

  public String getMarkUser() {
    return markUser;
  }

  public void setMarkUser(String markUser) {
    this.markUser = markUser;
  }

  public String getRepeatMapCheck() {
    return repeatMapCheck;
  }

  public void setRepeatMapCheck(String repeatMapCheck) {
    this.repeatMapCheck = repeatMapCheck;
  }


  public String getSlotCheck() {
    return slotCheck;
  }

  public void setSlotCheck(String slotCheck) {
    this.slotCheck = slotCheck;
  }

  public String getMapCheck() {
    return mapCheck;
  }

  public void setMapCheck(String mapCheck) {
    this.mapCheck = mapCheck;
  }

  public String getStdfCheck() {
    return stdfCheck;
  }

  public void setStdfCheck(String stdfCheck) {
    this.stdfCheck = stdfCheck;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  @Override
  public OperationMapGenerate clone() {
    return new OperationMapGenerate(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}