package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class ResourceRunBlock {

  private String id;

  private String customerBo;

  private String packageBo;

  private String itemGroupBo;

  private String itemBo;

  private String routerBo;

  private String operationBo;

  private String resourceBo;

  private String stateName;

  private Date beginTime;

  private Date endTime;

  private String actionComment;

  private String recipeName;

  private String updatedUser;

  private Date updatedTime;

  public ResourceRunBlock() {
    this.id = UUID.randomUUID().toString();
    this.stateName = "EDIT";
    this.beginTime = new Date();
    this.endTime = new Date();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCustomerBo() {
    return this.customerBo;
  }

  public void setCustomerBo(String customerBo) {
    this.customerBo = customerBo;
  }

  public String getPackageBo() {
    return this.packageBo;
  }

  public void setPackageBo(String packageBo) {
    this.packageBo = packageBo;
  }

  public String getActionComment() {
    return actionComment;
  }

  public void setActionComment(String actionComment) {
    this.actionComment = actionComment;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getRouterBo() {
    return this.routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public Date getBeginTime() {
    return this.beginTime;
  }

  public void setBeginTime(Date beginTime) {
    this.beginTime = beginTime;
  }

  public Date getEndTime() {
    return this.endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getRecipeName() {
    return this.recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public boolean isEditable() {
    return "EDIT".equalsIgnoreCase(this.stateName);
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

  public boolean isOnline() {
    return !"EDIT".equalsIgnoreCase(this.stateName) && !"CANCEL".equalsIgnoreCase(this.stateName);
  }

  @Override
  public String toString() {
    return this.id + "," + this.resourceBo;
  }
}
