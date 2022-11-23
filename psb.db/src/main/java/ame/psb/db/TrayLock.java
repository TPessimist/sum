package ame.psb.db;

import java.util.Date;

public class TrayLock {

  private String containerBo;

  private String stateName;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public TrayLock() {
  }

  public TrayLock(String containerBo, String updatedUser) {
    this.containerBo = containerBo;
    this.stateName = "LOCKED";
    this.reversedField1 = "";
    this.reversedField2 = "";
    this.updatedUser = updatedUser;
    this.updatedTime = new Date();
  }

  public TrayLock(TrayLock data) {
    this.containerBo = data.containerBo;
    this.stateName = data.stateName;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getContainerBo() {
    return containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getReversedField1() {
    return reversedField1;
  }

  public void setReversedField1(String reversedField1) {
    this.reversedField1 = reversedField1;
  }

  public String getReversedField2() {
    return reversedField2;
  }

  public void setReversedField2(String reversedField2) {
    this.reversedField2 = reversedField2;
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
  public TrayLock clone() {
    return new TrayLock(this);
  }

  @Override
  public String toString() {
    return this.containerBo;
  }
}
