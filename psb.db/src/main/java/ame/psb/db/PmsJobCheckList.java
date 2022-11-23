package ame.psb.db;

import java.util.Date;

public class PmsJobCheckList {

  private String handle;

  private String site;

  private String jobBo;

  private String resourceBo;

  private String resource;

  private String resourceType;

  private String resourceDesc;

  private String checklist;

  private String revision;

  private String description;

  private String createUser;

  private Date createdDateTime;


  public PmsJobCheckList() {
  }

  public PmsJobCheckList(PmsJobCheckList data) {
    this.handle = data.handle;
    this.site = data.site;
    this.jobBo = data.jobBo;
    this.resourceBo = data.resourceBo;
    this.resource = data.resource;
    this.resourceType = data.resourceType;
    this.resourceDesc = data.resourceDesc;
    this.checklist = data.checklist;
    this.revision = data.revision;
    this.description = data.description;
    this.createUser = data.createUser;
    this.createdDateTime = data.createdDateTime;
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

  public String getJobBo() {
    return jobBo;
  }

  public void setJobBo(String jobBo) {
    this.jobBo = jobBo;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  public String getResourceDesc() {
    return resourceDesc;
  }

  public void setResourceDesc(String resourceDesc) {
    this.resourceDesc = resourceDesc;
  }

  public String getChecklist() {
    return checklist;
  }

  public void setChecklist(String checklist) {
    this.checklist = checklist;
  }

  public String getRevision() {
    return revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  @Override
  public PmsJobCheckList clone() {
    return new PmsJobCheckList(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}