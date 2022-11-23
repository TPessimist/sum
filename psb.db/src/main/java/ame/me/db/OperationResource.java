package ame.me.db;

public class OperationResource {

  private String operationBo;

  private String resourceBo;

  private String operation;

  private String resrce;

  private String description;

  private String type;

  private String specialRouterBo;

  private String operationStatusBo;

  private String resrceStatusBo;

  private String operationParent;

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getOperation() {
    return this.operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getResrce() {
    return this.resrce;
  }

  public void setResrce(String resrce) {
    this.resrce = resrce;
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

  public String getOperationStatusBo() {
    return this.operationStatusBo;
  }

  public void setOperationStatusBo(String operationStatusBo) {
    this.operationStatusBo = operationStatusBo;
  }

  public String getResrceStatusBo() {
    return this.resrceStatusBo;
  }

  public void setResrceStatusBo(String resrceStatusBo) {
    this.resrceStatusBo = resrceStatusBo;
  }

  public String getOperationParent() {
    return this.operationParent;
  }

  public void setOperationParent(String operationParent) {
    this.operationParent = operationParent;
  }

  @Override
  public String toString() {
    return String.format("%-10s @ %s", this.resrce, this.operation);
  }

}
