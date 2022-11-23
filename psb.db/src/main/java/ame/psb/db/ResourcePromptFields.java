package ame.psb.db;

import java.util.Date;

public class ResourcePromptFields {

  private String id;

  private String subid;

  private String groupId;

  private String value;

  private String groupName;

  private String promptUser;

  private Date promptTime;


  public ResourcePromptFields() {
  }

  public ResourcePromptFields(ResourcePromptFields data) {
    this.id = data.id;
    this.subid = data.subid;
    this.groupId = data.groupId;
    this.value = data.value;
    this.groupName = data.groupName;
    this.promptUser = data.promptUser;
    this.promptTime = data.promptTime;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSubid() {
    return subid;
  }

  public void setSubid(String subid) {
    this.subid = subid;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getPromptUser() {
    return promptUser;
  }

  public void setPromptUser(String promptUser) {
    this.promptUser = promptUser;
  }

  public Date getPromptTime() {
    return promptTime;
  }

  public void setPromptTime(Date promptTime) {
    this.promptTime = promptTime;
  }

  @Override
  public ResourcePromptFields clone() {
    return new ResourcePromptFields(this);
  }

  @Override
  public String toString() {
    return this.id + ", " + this.subid + ", " + this.groupId;
  }
}
