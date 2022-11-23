package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class SamplingSkipPlan {

  private String id;

  private String processOperationBo;

  private String inspOperationBo;

  private String groupSize;

  private String updatedUser;

  private Date updatedTime;

  private String checkRule;

  private String state;


  public SamplingSkipPlan() {
    this.id = UUID.randomUUID().toString();
    this.state = "Y";
  }

  public SamplingSkipPlan(SamplingSkipPlan data) {
    this.id = data.id;
    this.processOperationBo = data.processOperationBo;
    this.inspOperationBo = data.inspOperationBo;
    this.groupSize = data.groupSize;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.checkRule = data.checkRule;
    this.state = data.state;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getGroupSize() {
    return groupSize;
  }

  public void setGroupSize(String groupSize) {
    this.groupSize = groupSize;
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

  public String getCheckRule() {
    return checkRule;
  }

  public void setCheckRule(String checkRule) {
    this.checkRule = checkRule;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public SamplingSkipPlan clone() {
    return new SamplingSkipPlan(this);
  }

  @Override
  public String toString() {
    return this.processOperationBo + ", " + this.inspOperationBo;
  }
}
