package ame.me.db;

import java.util.Date;

public class Operation {

  private String handle;

  private Integer changeStamp;

  private String site;

  private String operation;

  private String description;

  private String type;

  private String specialRouterBo;

  private String statusBo;

  private String resourceTypeBo;

  private String revision;

  private String currentRevision;

  private Date effStartDate;

  private Date effEndDate;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String pcaDashboardMode;

  private String defaultNcCodeBo;

  private String failureTrackingConfigBo;

  private String resourceBo;

  private Integer maxLoop;

  private Integer requiredTimeInProcess;

  private String reportingStep;

  private String prevSite;

  private String originalTransferKey;

  private String specialInstruction;

  private String reportingCenterBo;

  private String erpControlKeyBo;

  private String erpWorkCenterBo;

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public Integer getChangeStamp() {
    return this.changeStamp;
  }

  public void setChangeStamp(Integer changeStamp) {
    this.changeStamp = changeStamp;
  }

  public String getSite() {
    return this.site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getOperation() {
    return this.operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSpecialRouterBo() {
    return this.specialRouterBo;
  }

  public void setSpecialRouterBo(String specialRouterBo) {
    this.specialRouterBo = specialRouterBo;
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getResourceTypeBo() {
    return this.resourceTypeBo;
  }

  public void setResourceTypeBo(String resourceTypeBo) {
    this.resourceTypeBo = resourceTypeBo;
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

  public Date getEffStartDate() {
    return this.effStartDate;
  }

  public void setEffStartDate(Date effStartDate) {
    this.effStartDate = effStartDate;
  }

  public Date getEffEndDate() {
    return this.effEndDate;
  }

  public void setEffEndDate(Date effEndDate) {
    this.effEndDate = effEndDate;
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

  public String getPcaDashboardMode() {
    return this.pcaDashboardMode;
  }

  public void setPcaDashboardMode(String pcaDashboardMode) {
    this.pcaDashboardMode = pcaDashboardMode;
  }

  public String getDefaultNcCodeBo() {
    return this.defaultNcCodeBo;
  }

  public void setDefaultNcCodeBo(String defaultNcCodeBo) {
    this.defaultNcCodeBo = defaultNcCodeBo;
  }

  public String getFailureTrackingConfigBo() {
    return this.failureTrackingConfigBo;
  }

  public void setFailureTrackingConfigBo(String failureTrackingConfigBo) {
    this.failureTrackingConfigBo = failureTrackingConfigBo;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public Integer getMaxLoop() {
    return this.maxLoop;
  }

  public void setMaxLoop(Integer maxLoop) {
    this.maxLoop = maxLoop;
  }

  public Integer getRequiredTimeInProcess() {
    return this.requiredTimeInProcess;
  }

  public void setRequiredTimeInProcess(Integer requiredTimeInProcess) {
    this.requiredTimeInProcess = requiredTimeInProcess;
  }

  public String getReportingStep() {
    return this.reportingStep;
  }

  public void setReportingStep(String reportingStep) {
    this.reportingStep = reportingStep;
  }

  public String getPrevSite() {
    return this.prevSite;
  }

  public void setPrevSite(String prevSite) {
    this.prevSite = prevSite;
  }

  public String getOriginalTransferKey() {
    return this.originalTransferKey;
  }

  public void setOriginalTransferKey(String originalTransferKey) {
    this.originalTransferKey = originalTransferKey;
  }

  public String getSpecialInstruction() {
    return this.specialInstruction;
  }

  public void setSpecialInstruction(String specialInstruction) {
    this.specialInstruction = specialInstruction;
  }

  public String getReportingCenterBo() {
    return this.reportingCenterBo;
  }

  public void setReportingCenterBo(String reportingCenterBo) {
    this.reportingCenterBo = reportingCenterBo;
  }

  public String getErpControlKeyBo() {
    return this.erpControlKeyBo;
  }

  public void setErpControlKeyBo(String erpControlKeyBo) {
    this.erpControlKeyBo = erpControlKeyBo;
  }

  public String getErpWorkCenterBo() {
    return this.erpWorkCenterBo;
  }

  public void setErpWorkCenterBo(String erpWorkCenterBo) {
    this.erpWorkCenterBo = erpWorkCenterBo;
  }

  @Override
  public String toString() {
    return this.handle;
  }

}
