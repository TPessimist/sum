package ame.psb.db;

import java.util.Date;

public class InstrumentDepartment { //CAL仪校事业部表

  private String devision; //所属事业部

  private String department; //部门区域

  private String description; //备用列1

  private String value; //备用列2

  private Date updateTime; //更新时间

  private String updateUser; //更新人员


  public InstrumentDepartment() {
  }

  public InstrumentDepartment(InstrumentDepartment data) {
    this.devision = data.devision;
    this.department = data.department;
    this.description = data.description;
    this.value = data.value;
    this.updateTime = data.updateTime;
    this.updateUser = data.updateUser;
  }

  @Override
  public InstrumentDepartment clone() {
    return new InstrumentDepartment(this);
  }

  @Override
  public String toString() {
    return this.devision + ", " + this.department;
  }

  public String getDevision() {
    return devision;
  }

  public void setDevision(String devision) {
    this.devision = devision;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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
