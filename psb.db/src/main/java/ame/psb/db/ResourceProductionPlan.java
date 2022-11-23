package ame.psb.db;

import java.util.Date;

public class ResourceProductionPlan {

  private String id;

  private String resourceBo;

  private String loadport;

  private String stateName;

  private int sequence;

  private String carrierBo;

  private String sfcBo;

  private String sfcStepBo;

  private String operationBo;

  private String remark;

  private Date updatedTime;

  private Date createdTime;


  public ResourceProductionPlan() {
  }

  public ResourceProductionPlan(ResourceProductionPlan data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.loadport = data.loadport;
    this.stateName = data.stateName;
    this.sequence = data.sequence;
    this.carrierBo = data.carrierBo;
    this.sfcBo = data.sfcBo;
    this.sfcStepBo = data.sfcStepBo;
    this.operationBo = data.operationBo;
    this.remark = data.remark;
    this.updatedTime = data.updatedTime;
    this.createdTime = data.createdTime;
  }

  @Override
  public ResourceProductionPlan clone() {
    return new ResourceProductionPlan(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getLoadport() {
    return loadport;
  }

  public void setLoadport(String loadport) {
    this.loadport = loadport;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public int getSequence() {
    return sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }

  public String getCarrierBo() {
    return carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSfcStepBo() {
    return sfcStepBo;
  }

  public void setSfcStepBo(String sfcStepBo) {
    this.sfcStepBo = sfcStepBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }
}
