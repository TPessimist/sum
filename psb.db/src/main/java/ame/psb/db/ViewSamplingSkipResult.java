package ame.psb.db;

import java.sql.Date;

public class ViewSamplingSkipResult {

  private String samplingPlanGroup;

  private String samplingPlanGroupSeq;

  private String resourceBo;

  private String sfcBo;

  private String samplingPlanId;

  private String updatedUser;

  private Date updatedTime;

  private String processOperationBo;

  private String inspOperationBo;

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

  public String getProcessOperationBo() {
    return processOperationBo;
  }

  public void setProcessOperationBo(String processOperationBo) {
    this.processOperationBo = processOperationBo;
  }

  public String getInspOperationBo() {
    return inspOperationBo;
  }

  public void setInspOperationBo(String inspOperationBo) {
    this.inspOperationBo = inspOperationBo;
  }
}
