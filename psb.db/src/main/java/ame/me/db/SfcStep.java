package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class SfcStep {

  private String sfcStepBo;

  private String shopOrderBo;

  private String shopOrder;

  private String sfcBo;

  private String sfc;

  private String sfcRoutingBo;

  private String sfcRouterBo;

  private BigDecimal sfcRouterSeq;

  private BigDecimal sfcStepSeq;

  private String routerBo;

  private String operationBo;

  private String stepId;

  private String stepPulledInto;

  private String done;

  private String bypassed;

  private BigDecimal qtyInQueue;

  private BigDecimal qtyInWork;

  private BigDecimal qtyCompleted;

  private BigDecimal qtyCompletePending;

  private BigDecimal qtyRejected;

  private BigDecimal timesProcessed;

  private String useAsRework;

  private String localRework;

  private String previouslyStarted;

  private String previousResourceBo;

  private String previousStepId;

  private Date dateQueued;

  private String itemBo;

  private Date scheduledCompDate;

  private String resourceBo;

  private String workCenterBo;

  public SfcStep() {
  }

  public SfcStep(SfcStep data) {
    this.sfcStepBo = data.sfcStepBo;
    this.shopOrderBo = data.shopOrderBo;
    this.shopOrder = data.shopOrder;
    this.sfcBo = data.sfcBo;
    this.sfc = data.sfc;
    this.sfcRoutingBo = data.sfcRoutingBo;
    this.sfcRouterBo = data.sfcRouterBo;
    this.sfcRouterSeq = data.sfcRouterSeq;
    this.sfcStepSeq = data.sfcStepSeq;
    this.routerBo = data.routerBo;
    this.operationBo = data.operationBo;
    this.stepId = data.stepId;
    this.stepPulledInto = data.stepPulledInto;
    this.done = data.done;
    this.bypassed = data.bypassed;
    this.qtyInQueue = data.qtyInQueue;
    this.qtyInWork = data.qtyInWork;
    this.qtyCompleted = data.qtyCompleted;
    this.qtyCompletePending = data.qtyCompletePending;
    this.qtyRejected = data.qtyRejected;
    this.timesProcessed = data.timesProcessed;
    this.useAsRework = data.useAsRework;
    this.localRework = data.localRework;
    this.previouslyStarted = data.previouslyStarted;
    this.previousResourceBo = data.previousResourceBo;
    this.previousStepId = data.previousStepId;
    this.dateQueued = data.dateQueued;
    this.itemBo = data.itemBo;
    this.scheduledCompDate = data.scheduledCompDate;
    this.resourceBo = data.resourceBo;
    this.workCenterBo = data.workCenterBo;
  }

  public String getSfcStepBo() {
    return this.sfcStepBo;
  }

  public void setSfcStepBo(String sfcStepBo) {
    this.sfcStepBo = sfcStepBo;
  }

  public String getShopOrderBo() {
    return this.shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getShopOrder() {
    return this.shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSfc() {
    return this.sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getSfcRoutingBo() {
    return this.sfcRoutingBo;
  }

  public void setSfcRoutingBo(String sfcRoutingBo) {
    this.sfcRoutingBo = sfcRoutingBo;
  }

  public String getSfcRouterBo() {
    return this.sfcRouterBo;
  }

  public void setSfcRouterBo(String sfcRouterBo) {
    this.sfcRouterBo = sfcRouterBo;
  }

  public BigDecimal getSfcRouterSeq() {
    return this.sfcRouterSeq;
  }

  public void setSfcRouterSeq(BigDecimal sfcRouterSeq) {
    this.sfcRouterSeq = sfcRouterSeq;
  }

  public BigDecimal getSfcStepSeq() {
    return this.sfcStepSeq;
  }

  public void setSfcStepSeq(BigDecimal sfcStepSeq) {
    this.sfcStepSeq = sfcStepSeq;
  }

  public String getRouterBo() {
    return this.routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getStepId() {
    return this.stepId;
  }

  public void setStepId(String stepId) {
    this.stepId = stepId;
  }

  public String getStepPulledInto() {
    return this.stepPulledInto;
  }

  public void setStepPulledInto(String stepPulledInto) {
    this.stepPulledInto = stepPulledInto;
  }

  public String getDone() {
    return this.done;
  }

  public void setDone(String done) {
    this.done = done;
  }

  public String getBypassed() {
    return this.bypassed;
  }

  public void setBypassed(String bypassed) {
    this.bypassed = bypassed;
  }

  public BigDecimal getQtyInQueue() {
    return this.qtyInQueue;
  }

  public void setQtyInQueue(BigDecimal qtyInQueue) {
    this.qtyInQueue = qtyInQueue;
  }

  public BigDecimal getQtyInWork() {
    return this.qtyInWork;
  }

  public void setQtyInWork(BigDecimal qtyInWork) {
    this.qtyInWork = qtyInWork;
  }

  public BigDecimal getQtyCompleted() {
    return this.qtyCompleted;
  }

  public void setQtyCompleted(BigDecimal qtyCompleted) {
    this.qtyCompleted = qtyCompleted;
  }

  public BigDecimal getQtyCompletePending() {
    return this.qtyCompletePending;
  }

  public void setQtyCompletePending(BigDecimal qtyCompletePending) {
    this.qtyCompletePending = qtyCompletePending;
  }

  public BigDecimal getQtyRejected() {
    return this.qtyRejected;
  }

  public void setQtyRejected(BigDecimal qtyRejected) {
    this.qtyRejected = qtyRejected;
  }

  public BigDecimal getTimesProcessed() {
    return this.timesProcessed;
  }

  public void setTimesProcessed(BigDecimal timesProcessed) {
    this.timesProcessed = timesProcessed;
  }

  public String getUseAsRework() {
    return this.useAsRework;
  }

  public void setUseAsRework(String useAsRework) {
    this.useAsRework = useAsRework;
  }

  public String getLocalRework() {
    return this.localRework;
  }

  public void setLocalRework(String localRework) {
    this.localRework = localRework;
  }

  public String getPreviouslyStarted() {
    return this.previouslyStarted;
  }

  public void setPreviouslyStarted(String previouslyStarted) {
    this.previouslyStarted = previouslyStarted;
  }

  public String getPreviousResourceBo() {
    return this.previousResourceBo;
  }

  public void setPreviousResourceBo(String previousResourceBo) {
    this.previousResourceBo = previousResourceBo;
  }

  public String getPreviousStepId() {
    return this.previousStepId;
  }

  public void setPreviousStepId(String previousStepId) {
    this.previousStepId = previousStepId;
  }

  public Date getDateQueued() {
    return this.dateQueued;
  }

  public void setDateQueued(Date dateQueued) {
    this.dateQueued = dateQueued;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public Date getScheduledCompDate() {
    return this.scheduledCompDate;
  }

  public void setScheduledCompDate(Date scheduledCompDate) {
    this.scheduledCompDate = scheduledCompDate;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getWorkCenterBo() {
    return this.workCenterBo;
  }

  public void setWorkCenterBo(String workCenterBo) {
    this.workCenterBo = workCenterBo;
  }

  @Override
  public SfcStep clone() {
    return new SfcStep(this);
  }

  @Override
  public String toString() {
    return this.sfcStepBo;
  }
}
