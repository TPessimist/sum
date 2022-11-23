package ame.psb.db;

import java.util.Date;

public class ResourceSpecialOperation {

  private String resourceBo;

  private String operationBo;

  private String updatedUser;

  private Date updatedTime;

  private String stateName;


  public ResourceSpecialOperation() {
  }

  public ResourceSpecialOperation(ResourceSpecialOperation data) {
    this.resourceBo = data.resourceBo;
    this.operationBo = data.operationBo;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.stateName = data.stateName;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
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

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  @Override
  public ResourceSpecialOperation clone() {
    return new ResourceSpecialOperation(this);
  }

  @Override
  public String toString() {
    return this.resourceBo + ", " + this.operationBo;
  }
}
