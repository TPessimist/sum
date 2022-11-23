package ame.psb.db;

import java.util.Date;

public class BinMapSpecialAction {

  private String targetObject;

  private String targetLevel;

  private String stateName;

  private String operationBo;

  private String actionName;

  private String actionContent;

  private String actionComment;

  private String updatedUser;

  private Date updatedTime;


  public BinMapSpecialAction() {
  }

  public BinMapSpecialAction(BinMapSpecialAction data) {
    this.targetObject = data.targetObject;
    this.targetLevel = data.targetLevel;
    this.stateName = data.stateName;
    this.operationBo = data.operationBo;
    this.actionName = data.actionName;
    this.actionContent = data.actionContent;
    this.actionComment = data.actionComment;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public BinMapSpecialAction clone() {
    return new BinMapSpecialAction(this);
  }

  @Override
  public String toString() {
    return this.targetObject + ", " + this.targetLevel + ", " + this.operationBo + ", "
        + this.actionName;
  }

  public String getTargetObject() {
    return targetObject;
  }

  public void setTargetObject(String targetObject) {
    this.targetObject = targetObject;
  }

  public String getTargetLevel() {
    return targetLevel;
  }

  public void setTargetLevel(String targetLevel) {
    this.targetLevel = targetLevel;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getActionContent() {
    return actionContent;
  }

  public void setActionContent(String actionContent) {
    this.actionContent = actionContent;
  }

  public String getActionComment() {
    return actionComment;
  }

  public void setActionComment(String actionComment) {
    this.actionComment = actionComment;
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

  public static class Action {

    public static final String TSK_RAWDATA_COMPARE = "TSK_RAWDATA_COMPARE";

    public static final String PREPARE_E142_XML_DATA = "PREPARE_E142_XML_DATA";
  }

}
