package ame.psb.db;

import java.util.Date;

public class SorterMcsReserve {

  private String id;

  private String carrierBo;

  private String carrierName;

  private String sfcBo;

  private String sfcName;

  private String jobId;

  private String jobType;

  private String state;

  private String updateUser;

  private Date updateTime;


  public SorterMcsReserve() {
  }

  public SorterMcsReserve(SorterMcsReserve data) {
    this.id = data.id;
    this.carrierBo = data.carrierBo;
    this.carrierName = data.carrierName;
    this.sfcBo = data.sfcBo;
    this.sfcName = data.sfcName;
    this.jobId = data.jobId;
    this.jobType = data.jobType;
    this.state = data.state;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCarrierBo() {
    return carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getCarrierName() {
    return carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public String getJobType() {
    return jobType;
  }

  public void setJobType(String jobType) {
    this.jobType = jobType;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public SorterMcsReserve clone() {
    return new SorterMcsReserve(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
