package ame.me.db;

import java.math.BigDecimal;
import java.util.Date;

public class SfcRouter {

  private String handle;

  private String sfcRoutingBo;

  private String routerBo;

  private BigDecimal sequence;

  private String inUse;

  private String completed;

  private String subRouter;

  private BigDecimal qty;

  private String reworkedFromSfcStepBo;

  private String returnType;

  private String subType;

  private Date partitionDate;


  public SfcRouter() {
  }

  public SfcRouter(SfcRouter data) {
    this.handle = data.handle;
    this.sfcRoutingBo = data.sfcRoutingBo;
    this.routerBo = data.routerBo;
    this.sequence = data.sequence;
    this.inUse = data.inUse;
    this.completed = data.completed;
    this.subRouter = data.subRouter;
    this.qty = data.qty;
    this.reworkedFromSfcStepBo = data.reworkedFromSfcStepBo;
    this.returnType = data.returnType;
    this.subType = data.subType;
    this.partitionDate = data.partitionDate;
  }


  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSfcRoutingBo() {
    return sfcRoutingBo;
  }

  public void setSfcRoutingBo(String sfcRoutingBo) {
    this.sfcRoutingBo = sfcRoutingBo;
  }

  public String getRouterBo() {
    return routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public BigDecimal getSequence() {
    return sequence;
  }

  public void setSequence(BigDecimal sequence) {
    this.sequence = sequence;
  }

  public String getInUse() {
    return inUse;
  }

  public void setInUse(String inUse) {
    this.inUse = inUse;
  }

  public String getCompleted() {
    return completed;
  }

  public void setCompleted(String completed) {
    this.completed = completed;
  }

  public String getSubRouter() {
    return subRouter;
  }

  public void setSubRouter(String subRouter) {
    this.subRouter = subRouter;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public String getReworkedFromSfcStepBo() {
    return reworkedFromSfcStepBo;
  }

  public void setReworkedFromSfcStepBo(String reworkedFromSfcStepBo) {
    this.reworkedFromSfcStepBo = reworkedFromSfcStepBo;
  }

  public String getReturnType() {
    return returnType;
  }

  public void setReturnType(String returnType) {
    this.returnType = returnType;
  }

  public String getSubType() {
    return subType;
  }

  public void setSubType(String subType) {
    this.subType = subType;
  }

  public Date getPartitionDate() {
    return partitionDate;
  }

  public void setPartitionDate(Date partitionDate) {
    this.partitionDate = partitionDate;
  }

  @Override
  public SfcRouter clone() {
    return new SfcRouter(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
