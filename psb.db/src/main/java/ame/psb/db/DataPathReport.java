package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class DataPathReport {

  private String id;

  private String filePath;

  private String fileType;

  private String nums;

  private String operationBo;

  private String sfcBo;

  private String waferBo;

  private String stateName;

  private Date createdTime;

  private String createdUser;

  public DataPathReport() {
    this.id = UUID.randomUUID().toString();
  }

  public DataPathReport(DataPathReport data) {
    this.id = data.id;
    this.filePath = data.filePath;
    this.fileType = data.fileType;
    this.nums = data.nums;
    this.operationBo = data.operationBo;
    this.sfcBo = data.sfcBo;
    this.waferBo = data.waferBo;
    this.stateName = data.stateName;
    this.createdTime = data.createdTime;
    this.createdUser = data.createdUser;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public String getNums() {
    return nums;
  }

  public void setNums(String nums) {
    this.nums = nums;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getWaferBo() {
    return waferBo;
  }

  public void setWaferBo(String waferBo) {
    this.waferBo = waferBo;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public String getCreatedUser() {
    return createdUser;
  }

  public void setCreatedUser(String createdUser) {
    this.createdUser = createdUser;
  }

  @Override
  public DataPathReport clone() {
    return new DataPathReport(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
