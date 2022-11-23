package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class Bom {

  private String handle;

  private BigDecimal changeStamp;

  private String site;

  private String bom;

  private String bomType;

  private String description;

  private String statusBo;

  private String tmpBom;

  private String copiedFromBomBo;

  private String revision;

  private String currentRevision;

  private String bomTemplate;

  private String hasBeenReleased;

  private Date effStartDate;

  private Date effEndDate;

  private String effectivityControl;

  private String prevSite;

  private String originalTransferKey;

  private String erpBillOfMaterial;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private Date partitionDate;


  public Bom() {
  }

  public Bom(Bom data) {
    this.handle = data.handle;
    this.changeStamp = data.changeStamp;
    this.site = data.site;
    this.bom = data.bom;
    this.bomType = data.bomType;
    this.description = data.description;
    this.statusBo = data.statusBo;
    this.tmpBom = data.tmpBom;
    this.copiedFromBomBo = data.copiedFromBomBo;
    this.revision = data.revision;
    this.currentRevision = data.currentRevision;
    this.bomTemplate = data.bomTemplate;
    this.hasBeenReleased = data.hasBeenReleased;
    this.effStartDate = data.effStartDate;
    this.effEndDate = data.effEndDate;
    this.effectivityControl = data.effectivityControl;
    this.prevSite = data.prevSite;
    this.originalTransferKey = data.originalTransferKey;
    this.erpBillOfMaterial = data.erpBillOfMaterial;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
    this.partitionDate = data.partitionDate;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public BigDecimal getChangeStamp() {
    return changeStamp;
  }

  public void setChangeStamp(BigDecimal changeStamp) {
    this.changeStamp = changeStamp;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getBom() {
    return bom;
  }

  public void setBom(String bom) {
    this.bom = bom;
  }

  public String getBomType() {
    return bomType;
  }

  public void setBomType(String bomType) {
    this.bomType = bomType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatusBo() {
    return statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getTmpBom() {
    return tmpBom;
  }

  public void setTmpBom(String tmpBom) {
    this.tmpBom = tmpBom;
  }

  public String getCopiedFromBomBo() {
    return copiedFromBomBo;
  }

  public void setCopiedFromBomBo(String copiedFromBomBo) {
    this.copiedFromBomBo = copiedFromBomBo;
  }

  public String getRevision() {
    return revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public String getCurrentRevision() {
    return currentRevision;
  }

  public void setCurrentRevision(String currentRevision) {
    this.currentRevision = currentRevision;
  }

  public String getBomTemplate() {
    return bomTemplate;
  }

  public void setBomTemplate(String bomTemplate) {
    this.bomTemplate = bomTemplate;
  }

  public String getHasBeenReleased() {
    return hasBeenReleased;
  }

  public void setHasBeenReleased(String hasBeenReleased) {
    this.hasBeenReleased = hasBeenReleased;
  }

  public Date getEffStartDate() {
    return effStartDate;
  }

  public void setEffStartDate(Date effStartDate) {
    this.effStartDate = effStartDate;
  }

  public Date getEffEndDate() {
    return effEndDate;
  }

  public void setEffEndDate(Date effEndDate) {
    this.effEndDate = effEndDate;
  }

  public String getEffectivityControl() {
    return effectivityControl;
  }

  public void setEffectivityControl(String effectivityControl) {
    this.effectivityControl = effectivityControl;
  }

  public String getPrevSite() {
    return prevSite;
  }

  public void setPrevSite(String prevSite) {
    this.prevSite = prevSite;
  }

  public String getOriginalTransferKey() {
    return originalTransferKey;
  }

  public void setOriginalTransferKey(String originalTransferKey) {
    this.originalTransferKey = originalTransferKey;
  }

  public String getErpBillOfMaterial() {
    return erpBillOfMaterial;
  }

  public void setErpBillOfMaterial(String erpBillOfMaterial) {
    this.erpBillOfMaterial = erpBillOfMaterial;
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

  public Date getPartitionDate() {
    return partitionDate;
  }

  public void setPartitionDate(Date partitionDate) {
    this.partitionDate = partitionDate;
  }

  @Override
  public Bom clone() {
    return new Bom(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
