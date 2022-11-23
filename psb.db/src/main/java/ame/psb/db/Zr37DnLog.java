package ame.psb.db;

import java.util.Date;

public class Zr37DnLog {

  private String uuid;

  private String dn;

  private String containerName;

  private String content;

  private String value;

  private String updatedUser;

  private Date updatedTime;


  public Zr37DnLog() {
  }

  public Zr37DnLog(Zr37DnLog data) {
    this.uuid = data.uuid;
    this.dn = data.dn;
    this.containerName = data.containerName;
    this.content = data.content;
    this.value = data.value;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public Zr37DnLog clone() {
    return new Zr37DnLog(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getDn() {
    return dn;
  }

  public void setDn(String dn) {
    this.dn = dn;
  }

  public String getContainerName() {
    return containerName;
  }

  public void setContainerName(String containerName) {
    this.containerName = containerName;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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
}
