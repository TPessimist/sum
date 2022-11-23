package ame.psb.db;

public class ViewOperationCfs {

  private String operationBo;

  private String site;

  private String operation;

  private String operationParent;

  private String description;

  private String type;

  private String specialRouterBo;

  private String statusBo;

  private String resourceTypeBo;

  private String revision;

  private String operationType;

  private String cycleTimeType;

  private String recipeType;

  private String stage;

  private String packingSource;

  private String currentRevision;

  private String precheckToolOperation;

  public ViewOperationCfs() {
  }

  public ViewOperationCfs(ViewOperationCfs data) {
    this.operationBo = data.operationBo;
    this.site = data.site;
    this.operation = data.operation;
    this.operationParent = data.operationParent;
    this.description = data.description;
    this.type = data.type;
    this.specialRouterBo = data.specialRouterBo;
    this.statusBo = data.statusBo;
    this.resourceTypeBo = data.resourceTypeBo;
    this.revision = data.revision;
    this.operationType = data.operationType;
    this.cycleTimeType = data.cycleTimeType;
    this.recipeType = data.recipeType;
    this.stage = data.stage;
    this.packingSource = data.packingSource;
    this.precheckToolOperation = data.precheckToolOperation;
    this.currentRevision = data.currentRevision;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
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

  public String getOperationParent() {
    return this.operationParent;
  }

  public void setOperationParent(String operationParent) {
    this.operationParent = operationParent;
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

  public String getStage() {
    return this.stage;
  }

  public void setStage(String stage) {
    this.stage = stage;
  }

  public String getPackingSource() {
    return this.packingSource;
  }

  public void setPackingSource(String packingSource) {
    this.packingSource = packingSource;
  }

  public String getPrecheckToolOperation() {
    return precheckToolOperation;
  }

  public void setPrecheckToolOperation(String precheckToolOperation) {
    this.precheckToolOperation = precheckToolOperation;
  }

  public String getCurrentRevision() {
    return this.currentRevision;
  }

  public void setCurrentRevision(String currentRevision) {
    this.currentRevision = currentRevision;
  }

  @Override
  public ViewOperationCfs clone() {
    return new ViewOperationCfs(this);
  }

  @Override
  public String toString() {
    return this.operationBo;
  }
}
