package ame.me.db;

import java.util.Date;

public class ReasonCode {

  private String handle;

  private String site;

  private String reasonCode;

  private String description;

  private String category;

  private String statusBo;

  private String messageTypeBo;

  private Date modifiedDateTime;

  private Date createdDateTime;


  public ReasonCode() {
  }

  public ReasonCode(ReasonCode data) {
    this.handle = data.handle;
    this.site = data.site;
    this.reasonCode = data.reasonCode;
    this.description = data.description;
    this.category = data.category;
    this.statusBo = data.statusBo;
    this.messageTypeBo = data.messageTypeBo;
    this.modifiedDateTime = data.modifiedDateTime;
    this.createdDateTime = data.createdDateTime;
  }

  @Override
  public ReasonCode clone() {
    return new ReasonCode(this);
  }

  @Override
  public String toString() {
    return this.handle;
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

  public String getReasonCode() {
    return reasonCode;
  }

  public void setReasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getStatusBo() {
    return statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getMessageTypeBo() {
    return messageTypeBo;
  }

  public void setMessageTypeBo(String messageTypeBo) {
    this.messageTypeBo = messageTypeBo;
  }

  public Date getModifiedDateTime() {
    return modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }
}
