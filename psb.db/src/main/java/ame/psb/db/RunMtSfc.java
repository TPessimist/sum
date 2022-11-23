package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class RunMtSfc {

  private String id;

  private String stateName;

  private Date beginTime;

  private Date endTime;

  private String sfcStepBo;

  private String sfcBo;

  private String bomComponentBo;

  private String run;

  private String resourceBo;

  private String operationBo;

  private String routerBo;

  private String inventoryBo;

  private BigDecimal materialQty;

  private String runUser;

  private String bomComponentItemBo;

  private String slotName;

  private BigDecimal planQty;

  private String runSfcBo;

  public RunMtSfc() {
    this.id = System.currentTimeMillis() + "::" + UUID.randomUUID().toString();
  }

  public RunMtSfc(RunSfc run) {
    this.id = System.currentTimeMillis() + "::" + UUID.randomUUID().toString();
    this.stateName = "GOOD";
    this.beginTime = run.getBeginTime();
    this.endTime = run.getEndTime();
    this.sfcStepBo = run.getSfcStepBo();
    this.sfcBo = run.getSfcBo();
    // this.bomComponentBo;
    this.run = run.getRun();
    this.resourceBo = run.getResourceBo();
    this.operationBo = run.getOperationBo();
    this.routerBo = run.getRouterBo();
    // this.inventoryBo;
    // this.materialQty;
    this.runUser = run.getRunUser();
    // this.bomComponentItemBo;
    // this.slotName
    // this.planQty;
    this.runSfcBo = run.getId();
  }

  public RunMtSfc(RunMtSfc data) {
    this.id = data.id;
    this.stateName = data.stateName;
    this.beginTime = data.beginTime;
    this.endTime = data.endTime;
    this.sfcStepBo = data.sfcStepBo;
    this.sfcBo = data.sfcBo;
    this.bomComponentBo = data.bomComponentBo;
    this.run = data.run;
    this.resourceBo = data.resourceBo;
    this.operationBo = data.operationBo;
    this.routerBo = data.routerBo;
    this.inventoryBo = data.inventoryBo;
    this.materialQty = data.materialQty;
    this.runUser = data.runUser;
    this.bomComponentItemBo = data.bomComponentItemBo;
    this.slotName = data.slotName;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public Date getBeginTime() {
    return this.beginTime;
  }

  public void setBeginTime(Date beginTime) {
    this.beginTime = beginTime;
  }

  public Date getEndTime() {
    return this.endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getSfcStepBo() {
    return this.sfcStepBo;
  }

  public void setSfcStepBo(String sfcStepBo) {
    this.sfcStepBo = sfcStepBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getBomComponentBo() {
    return this.bomComponentBo;
  }

  public void setBomComponentBo(String bomComponentBo) {
    this.bomComponentBo = bomComponentBo;
  }

  public String getRun() {
    return this.run;
  }

  public void setRun(String run) {
    this.run = run;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getRouterBo() {
    return this.routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getInventoryBo() {
    return this.inventoryBo;
  }

  public void setInventoryBo(String inventoryBo) {
    this.inventoryBo = inventoryBo;
  }

  public BigDecimal getMaterialQty() {
    return this.materialQty;
  }

  public void setMaterialQty(BigDecimal materialQty) {
    this.materialQty = materialQty;
  }

  public String getRunUser() {
    return this.runUser;
  }

  public void setRunUser(String runUser) {
    this.runUser = runUser;
  }

  public String getBomComponentItemBo() {
    return this.bomComponentItemBo;
  }

  public void setBomComponentItemBo(String bomComponentItemBo) {
    this.bomComponentItemBo = bomComponentItemBo;
  }

  public String getSlotName() {
    return this.slotName;
  }

  public void setSlotName(String slotName) {
    this.slotName = slotName;
  }

  public BigDecimal getPlanQty() {
    return this.planQty;
  }

  public void setPlanQty(BigDecimal planQty) {
    this.planQty = planQty;
  }

  public String getRunSfcBo() {
    return this.runSfcBo;
  }

  public void setRunSfcBo(String runSfcBo) {
    this.runSfcBo = runSfcBo;
  }

  @Override
  public RunMtSfc clone() {
    return new RunMtSfc(this);
  }

  @Override
  public String toString() {
    return String.format("%-40s - %s in %s, qty:%s",
        this.id,
        this.bomComponentItemBo,
        this.inventoryBo,
        this.materialQty);
  }
}
