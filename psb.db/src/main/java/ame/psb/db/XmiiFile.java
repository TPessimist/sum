package ame.psb.db;

import java.util.Date;


public class XmiiFile {

  private String id;

  private String name;

  private String description;

  private String pathid;

  private Date modified;

  private String modifiedby;

  private Date created;

  private String createdby;

  private String text;

  private String remotepath;

  private String checkedoutby;

  private String version;

  private String status;

  private String resourceid;

  private String filesize;


  public XmiiFile() {
  }

  public XmiiFile(XmiiFile data) {
    this.id = data.id;
    this.name = data.name;
    this.description = data.description;
    this.pathid = data.pathid;
    this.modified = data.modified;
    this.modifiedby = data.modifiedby;
    this.created = data.created;
    this.createdby = data.createdby;
    this.text = data.text;
    this.remotepath = data.remotepath;
    this.checkedoutby = data.checkedoutby;
    this.version = data.version;
    this.status = data.status;
    this.resourceid = data.resourceid;
    this.filesize = data.filesize;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public String getPathid() {
    return pathid;
  }

  public void setPathid(String pathid) {
    this.pathid = pathid;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public String getModifiedby() {
    return modifiedby;
  }

  public void setModifiedby(String modifiedby) {
    this.modifiedby = modifiedby;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public String getCreatedby() {
    return createdby;
  }

  public void setCreatedby(String createdby) {
    this.createdby = createdby;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getRemotepath() {
    return remotepath;
  }

  public void setRemotepath(String remotepath) {
    this.remotepath = remotepath;
  }

  public String getCheckedoutby() {
    return checkedoutby;
  }

  public void setCheckedoutby(String checkedoutby) {
    this.checkedoutby = checkedoutby;
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

  public String getResourceid() {
    return resourceid;
  }

  public void setResourceid(String resourceid) {
    this.resourceid = resourceid;
  }

  public String getFilesize() {
    return filesize;
  }

  public void setFilesize(String filesize) {
    this.filesize = filesize;
  }

  @Override
  public XmiiFile clone() {
    return new XmiiFile(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
