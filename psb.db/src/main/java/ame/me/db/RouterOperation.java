package ame.me.db;

public class RouterOperation {

  private String routerOperationBo;

  private String routerBo;

  private String router;

  private String routerStepBo;

  private String operationParent;

  private String operationBo;

  private String operation;

  private String stepId;

  private String rework;

  private String queueDecisionType;

  private Integer sequence;

  private String routerType;

  private String revision;

  private String operationType;

  private String cycleTimeType;

  private String recipeType;

  public RouterOperation() {

  }

  public RouterOperation(RouterOperation routerOperation) {
    this.routerOperationBo = routerOperation.getRouterOperationBo();
    this.routerBo = routerOperation.getRouterBo();
    this.router = routerOperation.getRouter();
    this.routerStepBo = routerOperation.getRouterStepBo();
    this.operationParent = routerOperation.getOperationParent();
    this.operationBo = routerOperation.getOperationBo();
    this.operation = routerOperation.getOperation();
    this.stepId = routerOperation.getStepId();
    this.rework = routerOperation.getRework();
    this.queueDecisionType = routerOperation.getQueueDecisionType();
    this.sequence = routerOperation.getSequence();
    this.routerType = routerOperation.getRouterType();
    this.revision = routerOperation.getRevision();
    this.operationType = routerOperation.getOperationType();
    this.cycleTimeType = routerOperation.getCycleTimeType();
    this.recipeType = routerOperation.getRecipeType();
  }

  public String getRouterOperationBo() {
    return this.routerOperationBo;
  }

  public void setRouterOperationBo(String routerOperationBo) {
    this.routerOperationBo = routerOperationBo;
  }

  public String getRouterBo() {
    return this.routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getRouter() {
    return this.router;
  }

  public void setRouter(String router) {
    this.router = router;
  }

  public String getRouterStepBo() {
    return this.routerStepBo;
  }

  public void setRouterStepBo(String routerStepBo) {
    this.routerStepBo = routerStepBo;
  }

  public String getOperationParent() {
    return this.operationParent;
  }

  public void setOperationParent(String operationParent) {
    this.operationParent = operationParent;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getOperation() {
    return this.operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getStepId() {
    return this.stepId;
  }

  public void setStepId(String stepId) {
    this.stepId = stepId;
  }

  public String getRework() {
    return this.rework;
  }

  public void setRework(String rework) {
    this.rework = rework;
  }

  public String getQueueDecisionType() {
    return this.queueDecisionType;
  }

  public void setQueueDecisionType(String queueDecisionType) {
    this.queueDecisionType = queueDecisionType;
  }

  public Integer getSequence() {
    return this.sequence;
  }

  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  public String getRouterType() {
    return this.routerType;
  }

  public void setRouterType(String routerType) {
    this.routerType = routerType;
  }

  public String getRevision() {
    return this.revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public String getOperationType() {
    return this.operationType;
  }

  public void setOperationType(String operationType) {
    this.operationType = operationType;
  }

  public String getCycleTimeType() {
    return this.cycleTimeType;
  }

  public void setCycleTimeType(String cycleTimeType) {
    this.cycleTimeType = cycleTimeType;
  }

  public String getRecipeType() {
    return this.recipeType;
  }

  public void setRecipeType(String recipeType) {
    this.recipeType = recipeType;
  }

  @Override
  public String toString() {
    return this.router + "," + this.operation + "," + this.operationType + "," + this.cycleTimeType
        + "," + this.recipeType;
  }
}
