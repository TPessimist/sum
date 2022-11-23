package ame.psb.db;

import java.util.Date;

public class ZhNpiLog {

  private String id;

  private String product;

  private String routerName;

  private String routerVersion;

  private Integer seq;

  private String packageName;

  private String commonInfo;

  private String finalStages;

  private String stageFactors;

  private String stageRuleResult;

  private String operationRuleResult;

  private String modleJsonString;

  private String originalOperations;

  private String finalOperations;

  private String autoContainOperaions;

  private String autoRemoveOperations;

  private String manualAddOperations;

  private String manualCutOperations;

  private String filename;

  private String importFalg;

  private String demo;

  private Date logTime;

  public ZhNpiLog() {
  }

  public ZhNpiLog(ZhNpiLog data) {
    this.id = data.id;
    this.product = data.product;
    this.routerName = data.routerName;
    this.routerVersion = data.routerVersion;
    this.seq = data.seq;
    this.packageName = data.packageName;
    this.commonInfo = data.commonInfo;
    this.finalStages = data.finalStages;
    this.stageFactors = data.stageFactors;
    this.stageRuleResult = data.stageRuleResult;
    this.operationRuleResult = data.operationRuleResult;
    this.modleJsonString = data.modleJsonString;
    this.originalOperations = data.originalOperations;
    this.finalOperations = data.finalOperations;
    this.autoContainOperaions = data.autoContainOperaions;
    this.autoRemoveOperations = data.autoRemoveOperations;
    this.manualAddOperations = data.manualAddOperations;
    this.manualCutOperations = data.manualCutOperations;
    this.filename = data.filename;
    this.importFalg = data.importFalg;
    this.demo = data.demo;
    this.logTime = data.logTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getRouterName() {
    return routerName;
  }

  public void setRouterName(String routerName) {
    this.routerName = routerName;
  }

  public String getRouterVersion() {
    return routerVersion;
  }

  public void setRouterVersion(String routerVersion) {
    this.routerVersion = routerVersion;
  }

  public Integer getSeq() {
    return seq;
  }

  public void setSeq(Integer seq) {
    this.seq = seq;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getCommonInfo() {
    return commonInfo;
  }

  public void setCommonInfo(String commonInfo) {
    this.commonInfo = commonInfo;
  }

  public String getFinalStages() {
    return finalStages;
  }

  public void setFinalStages(String finalStages) {
    this.finalStages = finalStages;
  }

  public String getStageFactors() {
    return stageFactors;
  }

  public void setStageFactors(String stageFactors) {
    this.stageFactors = stageFactors;
  }

  public String getStageRuleResult() {
    return stageRuleResult;
  }

  public void setStageRuleResult(String stageRuleResult) {
    this.stageRuleResult = stageRuleResult;
  }

  public String getOperationRuleResult() {
    return operationRuleResult;
  }

  public void setOperationRuleResult(String operationRuleResult) {
    this.operationRuleResult = operationRuleResult;
  }

  public String getModleJsonString() {
    return modleJsonString;
  }

  public void setModleJsonString(String modleJsonString) {
    this.modleJsonString = modleJsonString;
  }

  public String getOriginalOperations() {
    return originalOperations;
  }

  public void setOriginalOperations(String originalOperations) {
    this.originalOperations = originalOperations;
  }

  public String getFinalOperations() {
    return finalOperations;
  }

  public void setFinalOperations(String finalOperations) {
    this.finalOperations = finalOperations;
  }

  public String getAutoContainOperaions() {
    return autoContainOperaions;
  }

  public void setAutoContainOperaions(String autoContainOperaions) {
    this.autoContainOperaions = autoContainOperaions;
  }

  public String getAutoRemoveOperations() {
    return autoRemoveOperations;
  }

  public void setAutoRemoveOperations(String autoRemoveOperations) {
    this.autoRemoveOperations = autoRemoveOperations;
  }

  public String getManualAddOperations() {
    return manualAddOperations;
  }

  public void setManualAddOperations(String manualAddOperations) {
    this.manualAddOperations = manualAddOperations;
  }

  public String getManualCutOperations() {
    return manualCutOperations;
  }

  public void setManualCutOperations(String manualCutOperations) {
    this.manualCutOperations = manualCutOperations;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getImportFalg() {
    return importFalg;
  }

  public void setImportFalg(String importFalg) {
    this.importFalg = importFalg;
  }

  public String getDemo() {
    return demo;
  }

  public void setDemo(String demo) {
    this.demo = demo;
  }

  public Date getLogTime() {
    return logTime;
  }

  public void setLogTime(Date logTime) {
    this.logTime = logTime;
  }

  @Override
  public ZhNpiLog clone() {
    return new ZhNpiLog(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
