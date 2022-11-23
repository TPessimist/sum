package ame.psb.db;

import java.util.Date;

public class ZdPmsChecklist {

  private String checklist;

  private String description;

  private String remark;

  private String checkType;

  private String createUser;

  private Date createdDateTime;

  private String modifyUser;

  private Date modifiedDateTime;


  public ZdPmsChecklist() {
  }

  public ZdPmsChecklist(ZdPmsChecklist data) {
    this.checklist = data.checklist;
    this.description = data.description;
    this.remark = data.remark;
    this.checkType = data.checkType;
    this.createUser = data.createUser;
    this.createdDateTime = data.createdDateTime;
    this.modifyUser = data.modifyUser;
    this.modifiedDateTime = data.modifiedDateTime;
  }

  @Override
  public ZdPmsChecklist clone() {
    return new ZdPmsChecklist(this);
  }

  @Override
  public String toString() {
    return this.checklist;
  }

  public String getChecklist() {
    return this.checklist;
  }

  public void setChecklist(String checklist) {
    this.checklist = checklist;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getCheckType() {
    return this.checkType;
  }

  public void setCheckType(String checkType) {
    this.checkType = checkType;
  }

  public String getCreateUser() {
    return this.createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getCreatedDateTime() {
    return this.createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public String getModifyUser() {
    return this.modifyUser;
  }

  public void setModifyUser(String modifyUser) {
    this.modifyUser = modifyUser;
  }

  public Date getModifiedDateTime() {
    return this.modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }
}
