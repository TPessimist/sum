package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class UserCert {

  private String handle;

  private String userBo;

  private String certificationBo;

  private Date expirationDate;

  private String certificationAuthorityBo;

  private Date certificationDate;

  private String warningAlarmSent;

  private String expirationAlarmSent;

  private String statusBo;

  private Date extensionExpirationDate;

  private String comments;

  private BigDecimal extensions;

  private String extensionAlarmSent;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String userId;

  private String employeeNumber;

  private String hireDate;

  private String terminationDate;

  private String certification;

  private String certDesc;

  private String certStatusBo;

  public UserCert() {
  }

  public UserCert(UserCert data) {
    this.handle = data.handle;
    this.userBo = data.userBo;
    this.certificationBo = data.certificationBo;
    this.expirationDate = data.expirationDate;
    this.certificationAuthorityBo = data.certificationAuthorityBo;
    this.certificationDate = data.certificationDate;
    this.warningAlarmSent = data.warningAlarmSent;
    this.expirationAlarmSent = data.expirationAlarmSent;
    this.statusBo = data.statusBo;
    this.extensionExpirationDate = data.extensionExpirationDate;
    this.comments = data.comments;
    this.extensions = data.extensions;
    this.extensionAlarmSent = data.extensionAlarmSent;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.userId = data.userId;
    this.employeeNumber = data.employeeNumber;
    this.hireDate = data.hireDate;
    this.terminationDate = data.terminationDate;
    this.certification = data.certification;
    this.certDesc = data.certDesc;
    this.certStatusBo = data.certStatusBo;
  }

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getUserBo() {
    return this.userBo;
  }

  public void setUserBo(String userBo) {
    this.userBo = userBo;
  }

  public String getCertificationBo() {
    return this.certificationBo;
  }

  public void setCertificationBo(String certificationBo) {
    this.certificationBo = certificationBo;
  }

  public Date getExpirationDate() {
    return this.expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  public String getCertificationAuthorityBo() {
    return this.certificationAuthorityBo;
  }

  public void setCertificationAuthorityBo(String certificationAuthorityBo) {
    this.certificationAuthorityBo = certificationAuthorityBo;
  }

  public Date getCertificationDate() {
    return this.certificationDate;
  }

  public void setCertificationDate(Date certificationDate) {
    this.certificationDate = certificationDate;
  }

  public String getWarningAlarmSent() {
    return this.warningAlarmSent;
  }

  public void setWarningAlarmSent(String warningAlarmSent) {
    this.warningAlarmSent = warningAlarmSent;
  }

  public String getExpirationAlarmSent() {
    return this.expirationAlarmSent;
  }

  public void setExpirationAlarmSent(String expirationAlarmSent) {
    this.expirationAlarmSent = expirationAlarmSent;
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public Date getExtensionExpirationDate() {
    return this.extensionExpirationDate;
  }

  public void setExtensionExpirationDate(Date extensionExpirationDate) {
    this.extensionExpirationDate = extensionExpirationDate;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public BigDecimal getExtensions() {
    return this.extensions;
  }

  public void setExtensions(BigDecimal extensions) {
    this.extensions = extensions;
  }

  public String getExtensionAlarmSent() {
    return this.extensionAlarmSent;
  }

  public void setExtensionAlarmSent(String extensionAlarmSent) {
    this.extensionAlarmSent = extensionAlarmSent;
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

  public String getHireDate() {
    return this.hireDate;
  }

  public void setHireDate(String hireDate) {
    this.hireDate = hireDate;
  }

  public String getTerminationDate() {
    return this.terminationDate;
  }

  public void setTerminationDate(String terminationDate) {
    this.terminationDate = terminationDate;
  }

  public String getCertification() {
    return this.certification;
  }

  public void setCertification(String certification) {
    this.certification = certification;
  }

  public String getCertDesc() {
    return this.certDesc;
  }

  public void setCertDesc(String certDesc) {
    this.certDesc = certDesc;
  }

  public String getCertStatusBo() {
    return this.certStatusBo;
  }

  public void setCertStatusBo(String certStatusBo) {
    this.certStatusBo = certStatusBo;
  }

  @Override
  public UserCert clone() {
    return new UserCert(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
