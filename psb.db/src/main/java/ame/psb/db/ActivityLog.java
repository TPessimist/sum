package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ActivityLog {

  private String handle;

  private String site;

  private BigDecimal changeStamp;

  private String actionCode;

  private String actionDetail;

  private String actionDetailHandle;

  private String activity;

  private Date dateTime;

  private String crew;

  private String userId;

  private String sfc;

  private String processLot;

  private String operation;

  private String operationRevision;

  private String item;

  private String itemRevision;

  private String router;

  private String routerRevision;

  private String stepId;

  private String substep;

  private String substepId;

  private String resrce;

  private String workCenter;

  private BigDecimal qty;

  private String rework;

  private String reportingCenterBo;

  private String shopOrderBo;

  private Date partitionDate;

  private String lccBo;

  private BigDecimal actionSpan;

  private String prevSite;

  private String txnId;

  private Date createdDateTime;

  private Date modifiedDateTime;


  public ActivityLog() {
  }

  public ActivityLog(ActivityLog data) {
    this.handle = data.handle;
    this.site = data.site;
    this.changeStamp = data.changeStamp;
    this.actionCode = data.actionCode;
    this.actionDetail = data.actionDetail;
    this.actionDetailHandle = data.actionDetailHandle;
    this.activity = data.activity;
    this.dateTime = data.dateTime;
    this.crew = data.crew;
    this.userId = data.userId;
    this.sfc = data.sfc;
    this.processLot = data.processLot;
    this.operation = data.operation;
    this.operationRevision = data.operationRevision;
    this.item = data.item;
    this.itemRevision = data.itemRevision;
    this.router = data.router;
    this.routerRevision = data.routerRevision;
    this.stepId = data.stepId;
    this.substep = data.substep;
    this.substepId = data.substepId;
    this.resrce = data.resrce;
    this.workCenter = data.workCenter;
    this.qty = data.qty;
    this.rework = data.rework;
    this.reportingCenterBo = data.reportingCenterBo;
    this.shopOrderBo = data.shopOrderBo;
    this.partitionDate = data.partitionDate;
    this.lccBo = data.lccBo;
    this.actionSpan = data.actionSpan;
    this.prevSite = data.prevSite;
    this.txnId = data.txnId;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
  }

  @Override
  public ActivityLog clone() {
    return new ActivityLog(this);
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

  public BigDecimal getChangeStamp() {
    return changeStamp;
  }

  public void setChangeStamp(BigDecimal changeStamp) {
    this.changeStamp = changeStamp;
  }

  public String getActionCode() {
    return actionCode;
  }

  public void setActionCode(String actionCode) {
    this.actionCode = actionCode;
  }

  public String getActionDetail() {
    return actionDetail;
  }

  public void setActionDetail(String actionDetail) {
    this.actionDetail = actionDetail;
  }

  public String getActionDetailHandle() {
    return actionDetailHandle;
  }

  public void setActionDetailHandle(String actionDetailHandle) {
    this.actionDetailHandle = actionDetailHandle;
  }

  public String getActivity() {
    return activity;
  }

  public void setActivity(String activity) {
    this.activity = activity;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }

  public String getCrew() {
    return crew;
  }

  public void setCrew(String crew) {
    this.crew = crew;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getProcessLot() {
    return processLot;
  }

  public void setProcessLot(String processLot) {
    this.processLot = processLot;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getOperationRevision() {
    return operationRevision;
  }

  public void setOperationRevision(String operationRevision) {
    this.operationRevision = operationRevision;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getItemRevision() {
    return itemRevision;
  }

  public void setItemRevision(String itemRevision) {
    this.itemRevision = itemRevision;
  }

  public String getRouter() {
    return router;
  }

  public void setRouter(String router) {
    this.router = router;
  }

  public String getRouterRevision() {
    return routerRevision;
  }

  public void setRouterRevision(String routerRevision) {
    this.routerRevision = routerRevision;
  }

  public String getStepId() {
    return stepId;
  }

  public void setStepId(String stepId) {
    this.stepId = stepId;
  }

  public String getSubstep() {
    return substep;
  }

  public void setSubstep(String substep) {
    this.substep = substep;
  }

  public String getSubstepId() {
    return substepId;
  }

  public void setSubstepId(String substepId) {
    this.substepId = substepId;
  }

  public String getResrce() {
    return resrce;
  }

  public void setResrce(String resrce) {
    this.resrce = resrce;
  }

  public String getWorkCenter() {
    return workCenter;
  }

  public void setWorkCenter(String workCenter) {
    this.workCenter = workCenter;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public String getRework() {
    return rework;
  }

  public void setRework(String rework) {
    this.rework = rework;
  }

  public String getReportingCenterBo() {
    return reportingCenterBo;
  }

  public void setReportingCenterBo(String reportingCenterBo) {
    this.reportingCenterBo = reportingCenterBo;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public Date getPartitionDate() {
    return partitionDate;
  }

  public void setPartitionDate(Date partitionDate) {
    this.partitionDate = partitionDate;
  }

  public String getLccBo() {
    return lccBo;
  }

  public void setLccBo(String lccBo) {
    this.lccBo = lccBo;
  }

  public BigDecimal getActionSpan() {
    return actionSpan;
  }

  public void setActionSpan(BigDecimal actionSpan) {
    this.actionSpan = actionSpan;
  }

  public String getPrevSite() {
    return prevSite;
  }

  public void setPrevSite(String prevSite) {
    this.prevSite = prevSite;
  }

  public String getTxnId() {
    return txnId;
  }

  public void setTxnId(String txnId) {
    this.txnId = txnId;
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
