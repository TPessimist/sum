package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class DcGroup {

  private String handle;

  private String dcGroup;

  private String description;

  private String site;

  private String collectDataAt;

  private String passFailGroup;

  private String revision;

  private String currentRevision;

  private String statusBo;

  private String authenticationRequired;

  private String erp;

  private String collectMethod;

  private String collectionType;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String erpInspection;

  private String erpWholeGroupInspection;

  private String meEvalInspection;

  private BigDecimal passFailNumber;

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getDcGroup() {
    return this.dcGroup;
  }

  public void setDcGroup(String dcGroup) {
    this.dcGroup = dcGroup;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSite() {
    return this.site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getCollectDataAt() {
    return this.collectDataAt;
  }

  public void setCollectDataAt(String collectDataAt) {
    this.collectDataAt = collectDataAt;
  }

  public String getPassFailGroup() {
    return this.passFailGroup;
  }

  public void setPassFailGroup(String passFailGroup) {
    this.passFailGroup = passFailGroup;
  }

  public String getRevision() {
    return this.revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public String getCurrentRevision() {
    return this.currentRevision;
  }

  public void setCurrentRevision(String currentRevision) {
    this.currentRevision = currentRevision;
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getAuthenticationRequired() {
    return this.authenticationRequired;
  }

  public void setAuthenticationRequired(String authenticationRequired) {
    this.authenticationRequired = authenticationRequired;
  }

  public String getErp() {
    return this.erp;
  }

  public void setErp(String erp) {
    this.erp = erp;
  }

  public String getCollectMethod() {
    return this.collectMethod;
  }

  public void setCollectMethod(String collectMethod) {
    this.collectMethod = collectMethod;
  }

  public String getCollectionType() {
    return this.collectionType;
  }

  public void setCollectionType(String collectionType) {
    this.collectionType = collectionType;
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

  public String getErpInspection() {
    return this.erpInspection;
  }

  public void setErpInspection(String erpInspection) {
    this.erpInspection = erpInspection;
  }

  public String getErpWholeGroupInspection() {
    return this.erpWholeGroupInspection;
  }

  public void setErpWholeGroupInspection(String erpWholeGroupInspection) {
    this.erpWholeGroupInspection = erpWholeGroupInspection;
  }

  public String getMeEvalInspection() {
    return this.meEvalInspection;
  }

  public void setMeEvalInspection(String meEvalInspection) {
    this.meEvalInspection = meEvalInspection;
  }

  public BigDecimal getPassFailNumber() {
    return this.passFailNumber;
  }

  public void setPassFailNumber(BigDecimal passFailNumber) {
    this.passFailNumber = passFailNumber;
  }

  @Override
  public String toString() {
    return this.handle;
  }
}