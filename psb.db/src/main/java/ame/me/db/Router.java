package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class Router {

  private String handle;

  private BigDecimal changeStamp;

  private String site;

  private String router;

  private String routerType;

  private String description;

  private String temporaryRouter;

  private String statusBo;

  private String entryRouterStepBo;

  private String copiedFromRouterBo;

  private String revision;

  private String currentRevision;

  private String hasBeenReleased;

  private Date effStartDate;

  private Date effEndDate;

  private Date createdDateTime;

  private Date modifiedDateTime;

  private String guiRepresentation;

  private String originalStatusBo;

  private String dispositionGroupBo;

  private String prevSite;

  private String originalTransferKey;

  private String displayType;

  private BigDecimal holdId;

  private String sendAsShared;

  private String sentToErp;

  private String erpChangeNumber;

  private String relaxedFlow;

  private String bomBo;

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public BigDecimal getChangeStamp() {
    return this.changeStamp;
  }

  public void setChangeStamp(BigDecimal changeStamp) {
    this.changeStamp = changeStamp;
  }

  public String getSite() {
    return this.site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getRouter() {
    return this.router;
  }

  public void setRouter(String router) {
    this.router = router;
  }

  public String getRouterType() {
    return this.routerType;
  }

  public void setRouterType(String routerType) {
    this.routerType = routerType;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTemporaryRouter() {
    return this.temporaryRouter;
  }

  public void setTemporaryRouter(String temporaryRouter) {
    this.temporaryRouter = temporaryRouter;
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getEntryRouterStepBo() {
    return this.entryRouterStepBo;
  }

  public void setEntryRouterStepBo(String entryRouterStepBo) {
    this.entryRouterStepBo = entryRouterStepBo;
  }

  public String getCopiedFromRouterBo() {
    return this.copiedFromRouterBo;
  }

  public void setCopiedFromRouterBo(String copiedFromRouterBo) {
    this.copiedFromRouterBo = copiedFromRouterBo;
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

  public String getHasBeenReleased() {
    return this.hasBeenReleased;
  }

  public void setHasBeenReleased(String hasBeenReleased) {
    this.hasBeenReleased = hasBeenReleased;
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

  public String getGuiRepresentation() {
    return this.guiRepresentation;
  }

  public void setGuiRepresentation(String guiRepresentation) {
    this.guiRepresentation = guiRepresentation;
  }

  public String getOriginalStatusBo() {
    return this.originalStatusBo;
  }

  public void setOriginalStatusBo(String originalStatusBo) {
    this.originalStatusBo = originalStatusBo;
  }

  public String getDispositionGroupBo() {
    return this.dispositionGroupBo;
  }

  public void setDispositionGroupBo(String dispositionGroupBo) {
    this.dispositionGroupBo = dispositionGroupBo;
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

  public String getDisplayType() {
    return this.displayType;
  }

  public void setDisplayType(String displayType) {
    this.displayType = displayType;
  }

  public BigDecimal getHoldId() {
    return this.holdId;
  }

  public void setHoldId(BigDecimal holdId) {
    this.holdId = holdId;
  }

  public String getSendAsShared() {
    return this.sendAsShared;
  }

  public void setSendAsShared(String sendAsShared) {
    this.sendAsShared = sendAsShared;
  }

  public String getSentToErp() {
    return this.sentToErp;
  }

  public void setSentToErp(String sentToErp) {
    this.sentToErp = sentToErp;
  }

  public String getErpChangeNumber() {
    return this.erpChangeNumber;
  }

  public void setErpChangeNumber(String erpChangeNumber) {
    this.erpChangeNumber = erpChangeNumber;
  }

  public String getRelaxedFlow() {
    return this.relaxedFlow;
  }

  public void setRelaxedFlow(String relaxedFlow) {
    this.relaxedFlow = relaxedFlow;
  }

  public String getBomBo() {
    return this.bomBo;
  }

  public void setBomBo(String bomBo) {
    this.bomBo = bomBo;
  }

  @Override
  public String toString() {
    return this.handle + ", " + this.router;
  }

}