package ame.psb.db;

import java.util.Date;

public class OperationReworkLog {

  private String itemGroupBo;

  private String operationBo;

  private String reworkRuleContent;

  private String updatedUser;

  private Date updatedTime;

  private String reworkSfcBo;

  private String resourceName;

  private String fcDcGroups;

  private String fcFiStatus;

  public String fcSplitDescription; //fc拆die首检时机


  public OperationReworkLog() {
  }

  public OperationReworkLog(OperationReworkLog data) {
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.reworkRuleContent = data.reworkRuleContent;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }


  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getReworkRuleContent() {
    return reworkRuleContent;
  }

  public void setReworkRuleContent(String reworkRuleContent) {
    this.reworkRuleContent = reworkRuleContent;
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

  public String getReworkSfcBo() {
    return reworkSfcBo;
  }

  public void setReworkSfcBo(String reworkSfcBo) {
    this.reworkSfcBo = reworkSfcBo;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getFcDcGroups() {
    return fcDcGroups;
  }

  public void setFcDcGroups(String fcDcGroups) {
    this.fcDcGroups = fcDcGroups;
  }

  public String getFcFiStatus() {
    return fcFiStatus;
  }

  public void setFcFiStatus(String fcFiStatus) {
    this.fcFiStatus = fcFiStatus;
  }

  public String getFcSplitDescription() {
    return fcSplitDescription;
  }

  public void setFcSplitDescription(String fcSplitDescription) {
    this.fcSplitDescription = fcSplitDescription;
  }

  @Override
  public OperationReworkLog clone() {
    return new OperationReworkLog(this);
  }

  @Override
  public String toString() {
    return this.itemGroupBo + ", " + this.operationBo + ", " + this.reworkRuleContent;
  }
}
