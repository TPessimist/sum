package ame.psb.db;

import java.util.Date;

public class RunOaWoChange {

  private String oaId;

  private String customerName;

  private String shopOrder;

  private String waferId;

  private String actionName;

  private String operationBo;

  private String labelPosition;

  private String beforeContent;

  private String afterContent;

  private String updatedUser;

  private Date updatedTime;

  private String stateName;


  public RunOaWoChange() {
  }

  public RunOaWoChange(RunOaWoChange data) {
    this.oaId = data.oaId;
    this.customerName = data.customerName;
    this.shopOrder = data.shopOrder;
    this.waferId = data.waferId;
    this.actionName = data.actionName;
    this.operationBo = data.operationBo;
    this.labelPosition = data.labelPosition;
    this.beforeContent = data.beforeContent;
    this.afterContent = data.afterContent;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.stateName = data.stateName;
  }

  @Override
  public RunOaWoChange clone() {
    return new RunOaWoChange(this);
  }

  @Override
  public String toString() {
    return this.oaId + ", " + this.customerName + ", " + this.shopOrder + ", " + this.waferId + ", "
        + this.actionName;
  }

  public String getOaId() {
    return oaId;
  }

  public void setOaId(String oaId) {
    this.oaId = oaId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getWaferId() {
    return waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getLabelPosition() {
    return labelPosition;
  }

  public void setLabelPosition(String labelPosition) {
    this.labelPosition = labelPosition;
  }

  public String getBeforeContent() {
    return beforeContent;
  }

  public void setBeforeContent(String beforeContent) {
    this.beforeContent = beforeContent;
  }

  public String getAfterContent() {
    return afterContent;
  }

  public void setAfterContent(String afterContent) {
    this.afterContent = afterContent;
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
}
