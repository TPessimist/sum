package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class PkgLabel {

  private String id;

  private String labelName;

  private String description;

  private String templateId;

  private String printerId;

  private String updatedUser;

  private Date updatedTime;

  private String labelType; //xf20201212add

  public PkgLabel() {
    this.id = UUID.randomUUID().toString();
  }

  public PkgLabel(PkgLabel data) {
    this.id = data.id;
    this.labelName = data.labelName;
    this.description = data.description;
    this.templateId = data.templateId;
    this.printerId = data.printerId;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.labelType = data.labelType;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLabelName() {
    return this.labelName;
  }

  public void setLabelName(String labelName) {
    this.labelName = labelName;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTemplateId() {
    return this.templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  public String getPrinterId() {
    return this.printerId;
  }

  public void setPrinterId(String printerId) {
    this.printerId = printerId;
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

  public String getLabelType() {
    return labelType;
  }

  public void setLabelType(String labelType) {
    this.labelType = labelType;
  }

  @Override
  public String toString() {
    return this.id;
  }
}
