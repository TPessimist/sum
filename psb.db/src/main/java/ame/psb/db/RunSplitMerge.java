package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class RunSplitMerge {

  private String id;

  private String actionName;

  private String functionName;

  private String befSourceSfcBo;

  private String befTargetSfcBo;

  private String befSourceCarrierBo;

  private String befTargetCarrierBo;

  private BigDecimal befSourceQty;

  private BigDecimal befTargetQty;

  private String aftSourceSfcBo;

  private String aftTargetSfcBo;

  private String aftSourceCarrierBo;

  private String aftTargetCarrierBo;

  private BigDecimal aftSourceQty;

  private BigDecimal aftTargetQty;

  private String operationBo;

  private Date runTime;

  private String runUser;


  public RunSplitMerge() {
    this.id = UUID.randomUUID().toString();
    this.runTime = new Date();
  }

  public RunSplitMerge(RunSplitMerge data) {
    this.id = data.id;
    this.actionName = data.actionName;
    this.functionName = data.functionName;
    this.befSourceSfcBo = data.befSourceSfcBo;
    this.befTargetSfcBo = data.befTargetSfcBo;
    this.befSourceCarrierBo = data.befSourceCarrierBo;
    this.befTargetCarrierBo = data.befTargetCarrierBo;
    this.befSourceQty = data.befSourceQty;
    this.befTargetQty = data.befTargetQty;
    this.aftSourceSfcBo = data.aftSourceSfcBo;
    this.aftTargetSfcBo = data.aftTargetSfcBo;
    this.aftSourceCarrierBo = data.aftSourceCarrierBo;
    this.aftTargetCarrierBo = data.aftTargetCarrierBo;
    this.aftSourceQty = data.aftSourceQty;
    this.aftTargetQty = data.aftTargetQty;
    this.operationBo = data.operationBo;
    this.runTime = data.runTime;
    this.runUser = data.runUser;
  }

  @Override
  public RunSplitMerge clone() {
    return new RunSplitMerge(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getActionName() {
    return actionName;
  }

  public void setActionName(String actionName) {
    this.actionName = actionName;
  }

  public String getFunctionName() {
    return functionName;
  }

  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }

  public String getBefSourceSfcBo() {
    return befSourceSfcBo;
  }

  public void setBefSourceSfcBo(String befSourceSfcBo) {
    this.befSourceSfcBo = befSourceSfcBo;
  }

  public String getBefTargetSfcBo() {
    return befTargetSfcBo;
  }

  public void setBefTargetSfcBo(String befTargetSfcBo) {
    this.befTargetSfcBo = befTargetSfcBo;
  }

  public String getBefSourceCarrierBo() {
    return befSourceCarrierBo;
  }

  public void setBefSourceCarrierBo(String befSourceCarrierBo) {
    this.befSourceCarrierBo = befSourceCarrierBo;
  }

  public String getBefTargetCarrierBo() {
    return befTargetCarrierBo;
  }

  public void setBefTargetCarrierBo(String befTargetCarrierBo) {
    this.befTargetCarrierBo = befTargetCarrierBo;
  }

  public BigDecimal getBefSourceQty() {
    return befSourceQty;
  }

  public void setBefSourceQty(BigDecimal befSourceQty) {
    this.befSourceQty = befSourceQty;
  }

  public BigDecimal getBefTargetQty() {
    return befTargetQty;
  }

  public void setBefTargetQty(BigDecimal befTargetQty) {
    this.befTargetQty = befTargetQty;
  }

  public String getAftSourceSfcBo() {
    return aftSourceSfcBo;
  }

  public void setAftSourceSfcBo(String aftSourceSfcBo) {
    this.aftSourceSfcBo = aftSourceSfcBo;
  }

  public String getAftTargetSfcBo() {
    return aftTargetSfcBo;
  }

  public void setAftTargetSfcBo(String aftTargetSfcBo) {
    this.aftTargetSfcBo = aftTargetSfcBo;
  }

  public String getAftSourceCarrierBo() {
    return aftSourceCarrierBo;
  }

  public void setAftSourceCarrierBo(String aftSourceCarrierBo) {
    this.aftSourceCarrierBo = aftSourceCarrierBo;
  }

  public String getAftTargetCarrierBo() {
    return aftTargetCarrierBo;
  }

  public void setAftTargetCarrierBo(String aftTargetCarrierBo) {
    this.aftTargetCarrierBo = aftTargetCarrierBo;
  }

  public BigDecimal getAftSourceQty() {
    return aftSourceQty;
  }

  public void setAftSourceQty(BigDecimal aftSourceQty) {
    this.aftSourceQty = aftSourceQty;
  }

  public BigDecimal getAftTargetQty() {
    return aftTargetQty;
  }

  public void setAftTargetQty(BigDecimal aftTargetQty) {
    this.aftTargetQty = aftTargetQty;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public Date getRunTime() {
    return runTime;
  }

  public void setRunTime(Date runTime) {
    this.runTime = runTime;
  }

  public String getRunUser() {
    return runUser;
  }

  public void setRunUser(String runUser) {
    this.runUser = runUser;
  }
}