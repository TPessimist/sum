package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class Run implements Cloneable {

  private String category;

  private String id;

  private String run;

  private String stateName;

  private Date beginTime;

  private Date endTime;

  private String resourceBo;

  private String operationBo;

  private String routerBo;

  private String recipeName;

  private String lotType;

  private String remark;

  private String runUser;

  public Run(String category) {
    this.category = category;
    this.id = UUID.randomUUID().toString();
    this.run = this.id;
    this.beginTime = new Date();
    this.lotType = "E";
  }

  public Run(String category, Run data) {
    this.category = category;
    this.id = data.id;
    this.run = data.run;
    this.stateName = data.stateName;
    this.beginTime = data.beginTime;
    this.endTime = data.endTime;
    this.resourceBo = data.resourceBo;
    this.operationBo = data.operationBo;
    this.routerBo = data.routerBo;
    this.recipeName = data.recipeName;
    this.lotType = data.lotType;
    this.remark = data.remark;
    this.runUser = data.runUser;
  }

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRun() {
    return this.run;
  }

  public void setRun(String run) {
    this.run = run;
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

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getLotType() {
    return this.lotType;
  }

  public void setLotType(String lotType) {
    this.lotType = lotType;
  }

  public String getRouterBo() {
    return this.routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getRecipeName() {
    return this.recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getRunUser() {
    return this.runUser;
  }

  public void setRunUser(String runUser) {
    this.runUser = runUser;
  }

  @Override
  public String toString() {
    return String
        .format("%-7s> %-50s, run:%s, state:%s", this.category, this.id, this.run, this.stateName);
  }

  @Override
  public Run clone() throws CloneNotSupportedException {
    return (Run) super.clone();
  }

}
