package ame.psb.db;

import java.util.Date;

public class FcSamplingResult {

  private String id;

  private String batchId;

  private String splitOperationBo;

  private String ncCode;

  private String sfcName;

  private String samplingJob;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public FcSamplingResult() {
  }

  public FcSamplingResult(FcSamplingResult data) {
    this.id = data.id;
    this.batchId = data.batchId;
    this.splitOperationBo = data.splitOperationBo;
    this.ncCode = data.ncCode;
    this.sfcName = data.sfcName;
    this.samplingJob = data.samplingJob;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getSplitOperationBo() {
    return splitOperationBo;
  }

  public void setSplitOperationBo(String splitOperationBo) {
    this.splitOperationBo = splitOperationBo;
  }

  public String getNcCode() {
    return ncCode;
  }

  public void setNcCode(String ncCode) {
    this.ncCode = ncCode;
  }

  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getSamplingJob() {
    return samplingJob;
  }

  public void setSamplingJob(String samplingJob) {
    this.samplingJob = samplingJob;
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
  public FcSamplingResult clone() {
    return new FcSamplingResult(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
