package ame.psb.db;

public class PmsCheckList {

  private String handle;

  private String site;

  private String checklist;

  private String description;

  private String statusBo;

  private String revision;

  private String remark;

  private String currentRevision;

  private String checkType;

  private String createUser;

  private String createdDateTime;

  private String modifyUser;

  private String modifiedDateTime;


  public PmsCheckList() {
  }

  public PmsCheckList(PmsCheckList data) {
    this.handle = data.handle;
    this.site = data.site;
    this.checklist = data.checklist;
    this.description = data.description;
    this.statusBo = data.statusBo;
    this.revision = data.revision;
    this.remark = data.remark;
    this.currentRevision = data.currentRevision;
    this.checkType = data.checkType;
    this.createUser = data.createUser;
    this.createdDateTime = data.createdDateTime;
    this.modifyUser = data.modifyUser;
    this.modifiedDateTime = data.modifiedDateTime;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getChecklist() {
    return checklist;
  }

  public void setChecklist(String checklist) {
    this.checklist = checklist;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatusBo() {
    return statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getRevision() {
    return revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getCurrentRevision() {
    return currentRevision;
  }

  public void setCurrentRevision(String currentRevision) {
    this.currentRevision = currentRevision;
  }

  public String getCheckType() {
    return checkType;
  }

  public void setCheckType(String checkType) {
    this.checkType = checkType;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public String getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(String createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public String getModifyUser() {
    return modifyUser;
  }

  public void setModifyUser(String modifyUser) {
    this.modifyUser = modifyUser;
  }

  public String getModifiedDateTime() {
    return modifiedDateTime;
  }

  public void setModifiedDateTime(String modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  @Override
  public PmsCheckList clone() {
    return new PmsCheckList(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
