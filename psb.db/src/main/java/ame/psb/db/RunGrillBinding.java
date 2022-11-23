package ame.psb.db;

import java.util.Date;

public class RunGrillBinding {

  private String id;

  private String carrierId;

  private String grillId;

  private String sortJobId;

  private String flag;

  private String bindUser;

  private Date bindTime;

  private String unbindUser;

  private Date unbindTime;


  public RunGrillBinding() {
  }

  public RunGrillBinding(RunGrillBinding data) {
    this.id = data.id;
    this.carrierId = data.carrierId;
    this.grillId = data.grillId;
    this.sortJobId = data.sortJobId;
    this.flag = data.flag;
    this.bindUser = data.bindUser;
    this.bindTime = data.bindTime;
    this.unbindUser = data.unbindUser;
    this.unbindTime = data.unbindTime;
  }

  @Override
  public RunGrillBinding clone() {
    return new RunGrillBinding(this);
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

  public String getCarrierId() {
    return carrierId;
  }

  public void setCarrierId(String carrierId) {
    this.carrierId = carrierId;
  }

  public String getGrillId() {
    return grillId;
  }

  public void setGrillId(String grillId) {
    this.grillId = grillId;
  }

  public String getSortJobId() {
    return sortJobId;
  }

  public void setSortJobId(String sortJobId) {
    this.sortJobId = sortJobId;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getBindUser() {
    return bindUser;
  }

  public void setBindUser(String bindUser) {
    this.bindUser = bindUser;
  }

  public Date getBindTime() {
    return bindTime;
  }

  public void setBindTime(Date bindTime) {
    this.bindTime = bindTime;
  }

  public String getUnbindUser() {
    return unbindUser;
  }

  public void setUnbindUser(String unbindUser) {
    this.unbindUser = unbindUser;
  }

  public Date getUnbindTime() {
    return unbindTime;
  }

  public void setUnbindTime(Date unbindTime) {
    this.unbindTime = unbindTime;
  }
}
