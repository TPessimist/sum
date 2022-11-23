package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class SfcStepOrig {

  private String handle;

  private String sfcRouterBo;

  private String stepId;

  private String operationBo;

  private String done;

  private String bypassed;

  private BigDecimal qtyInQueue;

  private BigDecimal qtyInWork;

  private BigDecimal qtyCompleted;

  private BigDecimal qtyCompletePending;

  private BigDecimal qtyRejected;

  private BigDecimal timesProcessed;

  private BigDecimal maxLoop;

  private String useAsRework;

  private String previouslyStarted;

  private String lastWorkCenterBo;

  private String previousStepId;

  private Date dateQueued;

  private String reportingStep;

  private BigDecimal stepSequence;

  private String resourceOrCenterGbo;

  private String state;

  private String reportingCenterBo;

  private String previousResourceBo;

  private String multiQSignoffNeeded;

  private String stepPulledInto;

  private Date partitionDate;

  private String localRework;

  private String specialInstruction;

  private BigDecimal futureHoldCount;

  private String erpSent;

  private String scrapReportingStep;

  private String erpTbSent;


  public SfcStepOrig() {
  }

  public SfcStepOrig(SfcStepOrig data) {
    this.handle = data.handle;
    this.sfcRouterBo = data.sfcRouterBo;
    this.stepId = data.stepId;
    this.operationBo = data.operationBo;
    this.done = data.done;
    this.bypassed = data.bypassed;
    this.qtyInQueue = data.qtyInQueue;
    this.qtyInWork = data.qtyInWork;
    this.qtyCompleted = data.qtyCompleted;
    this.qtyCompletePending = data.qtyCompletePending;
    this.qtyRejected = data.qtyRejected;
    this.timesProcessed = data.timesProcessed;
    this.maxLoop = data.maxLoop;
    this.useAsRework = data.useAsRework;
    this.previouslyStarted = data.previouslyStarted;
    this.lastWorkCenterBo = data.lastWorkCenterBo;
    this.previousStepId = data.previousStepId;
    this.dateQueued = data.dateQueued;
    this.reportingStep = data.reportingStep;
    this.stepSequence = data.stepSequence;
    this.resourceOrCenterGbo = data.resourceOrCenterGbo;
    this.state = data.state;
    this.reportingCenterBo = data.reportingCenterBo;
    this.previousResourceBo = data.previousResourceBo;
    this.multiQSignoffNeeded = data.multiQSignoffNeeded;
    this.stepPulledInto = data.stepPulledInto;
    this.partitionDate = data.partitionDate;
    this.localRework = data.localRework;
    this.specialInstruction = data.specialInstruction;
    this.futureHoldCount = data.futureHoldCount;
    this.erpSent = data.erpSent;
    this.scrapReportingStep = data.scrapReportingStep;
    this.erpTbSent = data.erpTbSent;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSfcRouterBo() {
    return sfcRouterBo;
  }

  public void setSfcRouterBo(String sfcRouterBo) {
    this.sfcRouterBo = sfcRouterBo;
  }

  public String getStepId() {
    return stepId;
  }

  public void setStepId(String stepId) {
    this.stepId = stepId;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getDone() {
    return done;
  }

  public void setDone(String done) {
    this.done = done;
  }

  public String getBypassed() {
    return bypassed;
  }

  public void setBypassed(String bypassed) {
    this.bypassed = bypassed;
  }

  public BigDecimal getQtyInQueue() {
    return qtyInQueue;
  }

  public void setQtyInQueue(BigDecimal qtyInQueue) {
    this.qtyInQueue = qtyInQueue;
  }

  public BigDecimal getQtyInWork() {
    return qtyInWork;
  }

  public void setQtyInWork(BigDecimal qtyInWork) {
    this.qtyInWork = qtyInWork;
  }

  public BigDecimal getQtyCompleted() {
    return qtyCompleted;
  }

  public void setQtyCompleted(BigDecimal qtyCompleted) {
    this.qtyCompleted = qtyCompleted;
  }

  public BigDecimal getQtyCompletePending() {
    return qtyCompletePending;
  }

  public void setQtyCompletePending(BigDecimal qtyCompletePending) {
    this.qtyCompletePending = qtyCompletePending;
  }

  public BigDecimal getQtyRejected() {
    return qtyRejected;
  }

  public void setQtyRejected(BigDecimal qtyRejected) {
    this.qtyRejected = qtyRejected;
  }

  public BigDecimal getTimesProcessed() {
    return timesProcessed;
  }

  public void setTimesProcessed(BigDecimal timesProcessed) {
    this.timesProcessed = timesProcessed;
  }

  public BigDecimal getMaxLoop() {
    return maxLoop;
  }

  public void setMaxLoop(BigDecimal maxLoop) {
    this.maxLoop = maxLoop;
  }

  public String getUseAsRework() {
    return useAsRework;
  }

  public void setUseAsRework(String useAsRework) {
    this.useAsRework = useAsRework;
  }

  public String getPreviouslyStarted() {
    return previouslyStarted;
  }

  public void setPreviouslyStarted(String previouslyStarted) {
    this.previouslyStarted = previouslyStarted;
  }

  public String getLastWorkCenterBo() {
    return lastWorkCenterBo;
  }

  public void setLastWorkCenterBo(String lastWorkCenterBo) {
    this.lastWorkCenterBo = lastWorkCenterBo;
  }

  public String getPreviousStepId() {
    return previousStepId;
  }

  public void setPreviousStepId(String previousStepId) {
    this.previousStepId = previousStepId;
  }

  public Date getDateQueued() {
    return dateQueued;
  }

  public void setDateQueued(Date dateQueued) {
    this.dateQueued = dateQueued;
  }

  public String getReportingStep() {
    return reportingStep;
  }

  public void setReportingStep(String reportingStep) {
    this.reportingStep = reportingStep;
  }

  public BigDecimal getStepSequence() {
    return stepSequence;
  }

  public void setStepSequence(BigDecimal stepSequence) {
    this.stepSequence = stepSequence;
  }

  public String getResourceOrCenterGbo() {
    return resourceOrCenterGbo;
  }

  public void setResourceOrCenterGbo(String resourceOrCenterGbo) {
    this.resourceOrCenterGbo = resourceOrCenterGbo;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getReportingCenterBo() {
    return reportingCenterBo;
  }

  public void setReportingCenterBo(String reportingCenterBo) {
    this.reportingCenterBo = reportingCenterBo;
  }

  public String getPreviousResourceBo() {
    return previousResourceBo;
  }

  public void setPreviousResourceBo(String previousResourceBo) {
    this.previousResourceBo = previousResourceBo;
  }

  public String getMultiQSignoffNeeded() {
    return multiQSignoffNeeded;
  }

  public void setMultiQSignoffNeeded(String multiQSignoffNeeded) {
    this.multiQSignoffNeeded = multiQSignoffNeeded;
  }

  public String getStepPulledInto() {
    return stepPulledInto;
  }

  public void setStepPulledInto(String stepPulledInto) {
    this.stepPulledInto = stepPulledInto;
  }

  public Date getPartitionDate() {
    return partitionDate;
  }

  public void setPartitionDate(Date partitionDate) {
    this.partitionDate = partitionDate;
  }

  public String getLocalRework() {
    return localRework;
  }

  public void setLocalRework(String localRework) {
    this.localRework = localRework;
  }

  public String getSpecialInstruction() {
    return specialInstruction;
  }

  public void setSpecialInstruction(String specialInstruction) {
    this.specialInstruction = specialInstruction;
  }

  public BigDecimal getFutureHoldCount() {
    return futureHoldCount;
  }

  public void setFutureHoldCount(BigDecimal futureHoldCount) {
    this.futureHoldCount = futureHoldCount;
  }

  public String getErpSent() {
    return erpSent;
  }

  public void setErpSent(String erpSent) {
    this.erpSent = erpSent;
  }

  public String getScrapReportingStep() {
    return scrapReportingStep;
  }

  public void setScrapReportingStep(String scrapReportingStep) {
    this.scrapReportingStep = scrapReportingStep;
  }

  public String getErpTbSent() {
    return erpTbSent;
  }

  public void setErpTbSent(String erpTbSent) {
    this.erpTbSent = erpTbSent;
  }

  @Override
  public SfcStepOrig clone() {
    return new SfcStepOrig(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
