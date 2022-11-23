package ame.me.db;

import java.math.BigDecimal;

public class RouterOrigOperation {

  private String handle;

  private String routerStepBo;

  private String operationBo;

  private BigDecimal maxLoop;

  private BigDecimal requiredTimeInProcess;

  private String stepType;

  private String specialInstruction;


  public RouterOrigOperation() {
  }

  public RouterOrigOperation(RouterOrigOperation data) {
    this.handle = data.handle;
    this.routerStepBo = data.routerStepBo;
    this.operationBo = data.operationBo;
    this.maxLoop = data.maxLoop;
    this.requiredTimeInProcess = data.requiredTimeInProcess;
    this.stepType = data.stepType;
    this.specialInstruction = data.specialInstruction;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getRouterStepBo() {
    return routerStepBo;
  }

  public void setRouterStepBo(String routerStepBo) {
    this.routerStepBo = routerStepBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public BigDecimal getMaxLoop() {
    return maxLoop;
  }

  public void setMaxLoop(BigDecimal maxLoop) {
    this.maxLoop = maxLoop;
  }

  public BigDecimal getRequiredTimeInProcess() {
    return requiredTimeInProcess;
  }

  public void setRequiredTimeInProcess(BigDecimal requiredTimeInProcess) {
    this.requiredTimeInProcess = requiredTimeInProcess;
  }

  public String getStepType() {
    return stepType;
  }

  public void setStepType(String stepType) {
    this.stepType = stepType;
  }

  public String getSpecialInstruction() {
    return specialInstruction;
  }

  public void setSpecialInstruction(String specialInstruction) {
    this.specialInstruction = specialInstruction;
  }

  @Override
  public RouterOrigOperation clone() {
    return new RouterOrigOperation(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
