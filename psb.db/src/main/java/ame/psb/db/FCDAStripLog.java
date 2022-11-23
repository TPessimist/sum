package ame.psb.db;

import java.util.Date;

public class FCDAStripLog {

  private String id;

  private String stripId;

  private String magazineId;

  private String resourceName;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public FCDAStripLog() {
  }

  public FCDAStripLog(FCDAStripLog data) {
    this.id = data.id;
    this.stripId = data.stripId;
    this.magazineId = data.magazineId;
    this.resourceName = data.resourceName;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStripId() {
    return stripId;
  }

  public void setStripId(String stripId) {
    this.stripId = stripId;
  }

  public String getMagazineId() {
    return magazineId;
  }

  public void setMagazineId(String magazineId) {
    this.magazineId = magazineId;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getReversedField1() {
    return reversedField1;
  }

  public void setReversedField1(String reversedField1) {
    this.reversedField1 = reversedField1;
  }

  public String getReversedField2() {
    return reversedField2;
  }

  public void setReversedField2(String reversedField2) {
    this.reversedField2 = reversedField2;
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

  @Override
  public FCDAStripLog clone() {
    return new FCDAStripLog(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
