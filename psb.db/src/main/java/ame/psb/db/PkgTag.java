package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class PkgTag {

  private String id;

  private String valuePattern;

  private String valueScript;

  private String description;

  private String valueType;

  private String updatedUser;

  private Date updatedTime;


  // ADD TYPE
  private String tagType;

  public PkgTag() {
    this.id = UUID.randomUUID().toString();
  }

  public PkgTag(PkgTag data) {
    this.id = data.id;
    this.valuePattern = data.valuePattern;
    this.valueScript = data.valueScript;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getValuePattern() {
    return this.valuePattern;
  }

  public void setValuePattern(String valuePattern) {
    this.valuePattern = valuePattern;
  }

  public String getValueScript() {
    return this.valueScript;
  }

  public void setValueScript(String valueScript) {
    this.valueScript = valueScript;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getValueType() {
    return this.valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
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

  public String getTagType() {
    return tagType;
  }

  public void setTagType(String tagType) {
    this.tagType = tagType;
  }

  @Override
  public String toString() {
    return this.id;
  }
}
