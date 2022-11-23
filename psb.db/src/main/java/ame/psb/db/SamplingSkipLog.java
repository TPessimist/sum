package ame.psb.db;

import java.util.Date;

public class SamplingSkipLog {

  private String samplingPlanGroup;

  private String samplingPlanGroupSeq;

  private String resourceBo;

  private String sfcBo;

  private String samplingPlanId;

  private String updatedUser;

  private Date updatedTime;


  public SamplingSkipLog() {
  }

  public SamplingSkipLog(SamplingSkipLog data) {
    this.samplingPlanGroup = data.samplingPlanGroup;
    this.samplingPlanGroupSeq = data.samplingPlanGroupSeq;
    this.resourceBo = data.resourceBo;
    this.sfcBo = data.sfcBo;
    this.samplingPlanId = data.samplingPlanId;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }


  public String getSamplingPlanGroup() {
    return samplingPlanGroup;
  }

  public void setSamplingPlanGroup(String samplingPlanGroup) {
    this.samplingPlanGroup = samplingPlanGroup;
  }

  public String getSamplingPlanGroupSeq() {
    return samplingPlanGroupSeq;
  }

  public void setSamplingPlanGroupSeq(String samplingPlanGroupSeq) {
    this.samplingPlanGroupSeq = samplingPlanGroupSeq;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSamplingPlanId() {
    return samplingPlanId;
  }

  public void setSamplingPlanId(String samplingPlanId) {
    this.samplingPlanId = samplingPlanId;
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
  public SamplingSkipLog clone() {
    return new SamplingSkipLog(this);
  }

  @Override
  public String toString() {
    return this.samplingPlanGroup + ", " + this.samplingPlanGroupSeq;
  }
}
