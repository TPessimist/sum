package ame.me.db;

import java.math.BigDecimal;

public class RouterStepOrig {

  private String handle;

  private String routerBo;

  private String stepId;

  private String description;

  private String rework;

  private String queueDecisionType;

  private String routerCompGbo;

  private String reportingStep;

  private BigDecimal sequence;

  private String reportingCenterBo;

  private String tabularStepType;

  private String scrapReportingStep;

  private String isLastReportingStep;

  private String erpSequence;

  private String erpControlKeyBo;

  private String erpWorkCenterBo;

  private String erpInspectionComplete;


  public RouterStepOrig() {
  }

  public RouterStepOrig(RouterStepOrig data) {
    this.handle = data.handle;
    this.routerBo = data.routerBo;
    this.stepId = data.stepId;
    this.description = data.description;
    this.rework = data.rework;
    this.queueDecisionType = data.queueDecisionType;
    this.routerCompGbo = data.routerCompGbo;
    this.reportingStep = data.reportingStep;
    this.sequence = data.sequence;
    this.reportingCenterBo = data.reportingCenterBo;
    this.tabularStepType = data.tabularStepType;
    this.scrapReportingStep = data.scrapReportingStep;
    this.isLastReportingStep = data.isLastReportingStep;
    this.erpSequence = data.erpSequence;
    this.erpControlKeyBo = data.erpControlKeyBo;
    this.erpWorkCenterBo = data.erpWorkCenterBo;
    this.erpInspectionComplete = data.erpInspectionComplete;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getRouterBo() {
    return routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getStepId() {
    return stepId;
  }

  public void setStepId(String stepId) {
    this.stepId = stepId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRework() {
    return rework;
  }

  public void setRework(String rework) {
    this.rework = rework;
  }

  public String getQueueDecisionType() {
    return queueDecisionType;
  }

  public void setQueueDecisionType(String queueDecisionType) {
    this.queueDecisionType = queueDecisionType;
  }

  public String getRouterCompGbo() {
    return routerCompGbo;
  }

  public void setRouterCompGbo(String routerCompGbo) {
    this.routerCompGbo = routerCompGbo;
  }

  public String getReportingStep() {
    return reportingStep;
  }

  public void setReportingStep(String reportingStep) {
    this.reportingStep = reportingStep;
  }

  public BigDecimal getSequence() {
    return sequence;
  }

  public void setSequence(BigDecimal sequence) {
    this.sequence = sequence;
  }

  public String getReportingCenterBo() {
    return reportingCenterBo;
  }

  public void setReportingCenterBo(String reportingCenterBo) {
    this.reportingCenterBo = reportingCenterBo;
  }

  public String getTabularStepType() {
    return tabularStepType;
  }

  public void setTabularStepType(String tabularStepType) {
    this.tabularStepType = tabularStepType;
  }

  public String getScrapReportingStep() {
    return scrapReportingStep;
  }

  public void setScrapReportingStep(String scrapReportingStep) {
    this.scrapReportingStep = scrapReportingStep;
  }

  public String getIsLastReportingStep() {
    return isLastReportingStep;
  }

  public void setIsLastReportingStep(String isLastReportingStep) {
    this.isLastReportingStep = isLastReportingStep;
  }

  public String getErpSequence() {
    return erpSequence;
  }

  public void setErpSequence(String erpSequence) {
    this.erpSequence = erpSequence;
  }

  public String getErpControlKeyBo() {
    return erpControlKeyBo;
  }

  public void setErpControlKeyBo(String erpControlKeyBo) {
    this.erpControlKeyBo = erpControlKeyBo;
  }

  public String getErpWorkCenterBo() {
    return erpWorkCenterBo;
  }

  public void setErpWorkCenterBo(String erpWorkCenterBo) {
    this.erpWorkCenterBo = erpWorkCenterBo;
  }

  public String getErpInspectionComplete() {
    return erpInspectionComplete;
  }

  public void setErpInspectionComplete(String erpInspectionComplete) {
    this.erpInspectionComplete = erpInspectionComplete;
  }

  @Override
  public RouterStepOrig clone() {
    return new RouterStepOrig(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
