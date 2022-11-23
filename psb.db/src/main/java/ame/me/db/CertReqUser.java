package ame.me.db;

import java.util.Date;

public class CertReqUser {

  private String handle;

  private String certificationBo;

  private String userGroupBo;

  private String certifiedObjectGbo;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String userBo;

  private String userId;

  private String employeeNumber;

  public CertReqUser() {
  }

  public CertReqUser(CertReqUser data) {
    this.handle = data.handle;
    this.certificationBo = data.certificationBo;
    this.userGroupBo = data.userGroupBo;
    this.certifiedObjectGbo = data.certifiedObjectGbo;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.userBo = data.userBo;
    this.userId = data.userId;
    this.employeeNumber = data.employeeNumber;
  }

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getCertificationBo() {
    return this.certificationBo;
  }

  public void setCertificationBo(String certificationBo) {
    this.certificationBo = certificationBo;
  }

  public String getUserGroupBo() {
    return this.userGroupBo;
  }

  public void setUserGroupBo(String userGroupBo) {
    this.userGroupBo = userGroupBo;
  }

  public String getCertifiedObjectGbo() {
    return this.certifiedObjectGbo;
  }

  public void setCertifiedObjectGbo(String certifiedObjectGbo) {
    this.certifiedObjectGbo = certifiedObjectGbo;
  }

  public Date getCreatedDateTime() {
    return this.createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Date getModifiedDateTime() {
    return this.modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  public String getUserBo() {
    return this.userBo;
  }

  public void setUserBo(String userBo) {
    this.userBo = userBo;
  }

  public String getUserId() {
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getEmployeeNumber() {
    return this.employeeNumber;
  }

  public void setEmployeeNumber(String employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  @Override
  public CertReqUser clone() {
    return new CertReqUser(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
