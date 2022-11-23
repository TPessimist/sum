package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class DummySfc {

  private String id;

  private String dummyPlanBo;

  private String resourceBo;

  private String itemBo;

  private String beginOperationBo;

  private String endOperationBo;

  private String sfcBo;

  private Date createTime;

  private Date completeTime;

  private String stateName;


  public DummySfc() {
    this.id = UUID.randomUUID().toString();
  }

  public DummySfc(DummySfc data) {
    this.id = data.id;
    this.dummyPlanBo = data.dummyPlanBo;
    this.resourceBo = data.resourceBo;
    this.itemBo = data.itemBo;
    this.beginOperationBo = data.beginOperationBo;
    this.endOperationBo = data.endOperationBo;
    this.sfcBo = data.sfcBo;
    this.createTime = data.createTime;
    this.completeTime = data.completeTime;
    this.stateName = data.stateName;
  }

  @Override
  public DummySfc clone() {
    return new DummySfc(this);
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

  public String getDummyPlanBo() {
    return dummyPlanBo;
  }

  public void setDummyPlanBo(String dummyPlanBo) {
    this.dummyPlanBo = dummyPlanBo;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getBeginOperationBo() {
    return beginOperationBo;
  }

  public void setBeginOperationBo(String beginOperationBo) {
    this.beginOperationBo = beginOperationBo;
  }

  public String getEndOperationBo() {
    return endOperationBo;
  }

  public void setEndOperationBo(String endOperationBo) {
    this.endOperationBo = endOperationBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getCompleteTime() {
    return completeTime;
  }

  public void setCompleteTime(Date completeTime) {
    this.completeTime = completeTime;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }
}
