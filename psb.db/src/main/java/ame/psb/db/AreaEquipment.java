package ame.psb.db;

import java.util.Date;

public class AreaEquipment {

  private String resource;

  private String area;

  private String handle;

  private String maintenancePeople;

  private String department;

  private String leader;

  private String updateUser;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String stateName;

  private String content2;


  public AreaEquipment() {
  }

  public AreaEquipment(AreaEquipment data) {
    this.resource = data.resource;
    this.area = data.area;
    this.handle = data.handle;
    this.maintenancePeople = data.maintenancePeople;
    this.department = data.department;
    this.leader = data.leader;
    this.updateUser = data.updateUser;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.stateName = data.stateName;
    this.content2 = data.content2;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getMaintenancePeople() {
    return maintenancePeople;
  }

  public void setMaintenancePeople(String maintenancePeople) {
    this.maintenancePeople = maintenancePeople;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getLeader() {
    return leader;
  }

  public void setLeader(String leader) {
    this.leader = leader;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Date getModifiedDateTime() {
    return modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getContent2() {
    return content2;
  }

  public void setContent2(String content2) {
    this.content2 = content2;
  }

  @Override
  public AreaEquipment clone() {
    return new AreaEquipment(this);
  }

  @Override
  public String toString() {
    return this.resource;
  }
}
