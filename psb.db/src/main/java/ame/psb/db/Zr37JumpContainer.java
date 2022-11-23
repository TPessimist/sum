package ame.psb.db;

import java.util.Date;

public class Zr37JumpContainer {

  private String id; //容器编号

  private String stateName; //容器状态

  private String dn; //容器的DN号

  private String dept; //容器的部门

  private String currStep; //当前站点

  private Date insertTime; //记录插入时间

  private String insertUser; //记录插入人员

  private Date updateTime; //记录更新时间

  private String updateUser; //记录更新人员


  public Zr37JumpContainer() {
  }

  public Zr37JumpContainer(Zr37JumpContainer data) {
    this.id = data.id;
    this.stateName = data.stateName;
    this.dn = data.dn;
    this.dept = data.dept;
    this.currStep = data.currStep;
    this.insertTime = data.insertTime;
    this.insertUser = data.insertUser;
    this.updateTime = data.updateTime;
    this.updateUser = data.updateUser;
  }

  @Override
  public Zr37JumpContainer clone() {
    return new Zr37JumpContainer(this);
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

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getDn() {
    return dn;
  }

  public void setDn(String dn) {
    this.dn = dn;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public String getCurrStep() {
    return currStep;
  }

  public void setCurrStep(String currStep) {
    this.currStep = currStep;
  }

  public Date getInsertTime() {
    return insertTime;
  }

  public void setInsertTime(Date insertTime) {
    this.insertTime = insertTime;
  }

  public String getInsertUser() {
    return insertUser;
  }

  public void setInsertUser(String insertUser) {
    this.insertUser = insertUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }
}
