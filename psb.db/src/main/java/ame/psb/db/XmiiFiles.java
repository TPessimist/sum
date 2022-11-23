package ame.psb.db;

import java.util.Date;

public class XmiiFiles {

  private long id;
  private String name;
  private String description;
  private long pathId;
  private Date modified;
  private String modifiedBy;
  private Date created;
  private String createdBy;
  private byte[] text;
  private String remotePath;
  private String checkedOutBy;
  private String version;
  private String status;
  private String resourceId;
  private long fileSize;

  public XmiiFiles() {
  }

  public XmiiFiles(XmiiFiles data) {
    this.id = data.id;
    this.name = data.name;
    this.description = data.description;
    this.pathId = data.pathId;
    this.modified = data.modified;
    this.modifiedBy = data.modifiedBy;
    this.created = data.created;
    this.createdBy = data.createdBy;
    this.text = data.text;
    this.remotePath = data.remotePath;
    this.checkedOutBy = data.checkedOutBy;
    this.version = data.version;
    this.status = data.status;
    this.resourceId = data.resourceId;
    this.fileSize = data.fileSize;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return new XmiiFiles(this);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getPathId() {
    return pathId;
  }

  public void setPathId(long pathId) {
    this.pathId = pathId;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public String getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public byte[] getText() {
    return text;
  }

  public void setText(byte[] text) {
    this.text = text;
  }

  public String getRemotePath() {
    return remotePath;
  }

  public void setRemotePath(String remotePath) {
    this.remotePath = remotePath;
  }

  public String getCheckedOutBy() {
    return checkedOutBy;
  }

  public void setCheckedOutBy(String checkedOutBy) {
    this.checkedOutBy = checkedOutBy;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public long getFileSize() {
    return fileSize;
  }

  public void setFileSize(long fileSize) {
    this.fileSize = fileSize;
  }

}
