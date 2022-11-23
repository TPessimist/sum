package ame.psb.db;

import java.util.Date;

public class OaPassCheck {

  private String id;

  private String oaId;

  private String actionName;

  private String actionContent;

  private String operationBo;

  private String spareValue;

  private String spareValue2;

  private String updatedUser;

  private Date updatedTime;


  public OaPassCheck() {
  }

  public OaPassCheck(OaPassCheck data) {
    this.id = data.id;
    this.oaId = data.oaId;
    this.actionName = data.actionName;
    this.actionContent = data.actionContent;
    this.operationBo = data.operationBo;
    this.spareValue = data.spareValue;
    this.spareValue2 = data.spareValue2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOaId() {
    return oaId;
  }

  public void setOaId(String oaId) {
    this.oaId = oaId;
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

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getSpareValue() {
    return spareValue;
  }

  public void setSpareValue(String spareValue) {
    this.spareValue = spareValue;
  }

  public String getSpareValue2() {
    return spareValue2;
  }

  public void setSpareValue2(String spareValue2) {
    this.spareValue2 = spareValue2;
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
  public OaPassCheck clone() {
    return new OaPassCheck(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
