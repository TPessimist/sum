package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class PkgHoldLog {

  private String handle;

  private String site;

  private BigDecimal holdId;

  private String userBo;

  private String comments;

  private Date dateTime;

  private Date expectedReleaseDateTime;

  private Date createdDateTime;

  private Date modifiedDateTime;


  public PkgHoldLog() {
  }

  public PkgHoldLog(PkgHoldLog data) {
    this.handle = data.handle;
    this.site = data.site;
    this.holdId = data.holdId;
    this.userBo = data.userBo;
    this.comments = data.comments;
    this.dateTime = data.dateTime;
    this.expectedReleaseDateTime = data.expectedReleaseDateTime;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
  }

  @Override
  public PkgHoldLog clone() {
    return new PkgHoldLog(this);
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

  public BigDecimal getHoldId() {
    return holdId;
  }

  public void setHoldId(BigDecimal holdId) {
    this.holdId = holdId;
  }

  public String getUserBo() {
    return userBo;
  }

  public void setUserBo(String userBo) {
    this.userBo = userBo;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public Date getExpectedReleaseDateTime() {
    return expectedReleaseDateTime;
  }

  public void setExpectedReleaseDateTime(Date expectedReleaseDateTime) {
    this.expectedReleaseDateTime = expectedReleaseDateTime;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Date getModifiedDateTime() {
    return modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }
}
