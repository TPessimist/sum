package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class ViewHoldReason {

  private String handle;

  private String site;

  private String reasonCode;

  private String description;

  private String category;

  private String statusBo;

  private String messageTypeBo;

  private Date modifiedDateTime;

  private Date createdDateTime;

  private String groupName;

  private String waferValidation;

  private String oa;

  private String holdLevel;

  private String releaseLevel;

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSite() {
    return this.site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getReasonCode() {
    return this.reasonCode;
  }

  public void setReasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getMessageTypeBo() {
    return this.messageTypeBo;
  }

  public void setMessageTypeBo(String messageTypeBo) {
    this.messageTypeBo = messageTypeBo;
  }

  public Date getModifiedDateTime() {
    return this.modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public Date getCreatedDateTime() {
    return this.createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public String getGroupName() {
    return this.groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getWaferValidation() {
    return this.waferValidation;
  }

  public void setWaferValidation(String waferValidation) {
    this.waferValidation = waferValidation;
  }

  public String getOa() {
    return this.oa;
  }

  public void setOa(String oa) {
    this.oa = oa;
  }

  public String getHoldLevel() {
    return holdLevel;
  }

  public void setHoldLevel(String holdLevel) {
    this.holdLevel = holdLevel;
  }

  public String getReleaseLevel() {
    return releaseLevel;
  }

  public void setReleaseLevel(String releaseLevel) {
    this.releaseLevel = releaseLevel;
  }

  @Override
  public String toString() {
    return this.reasonCode;
  }

}
