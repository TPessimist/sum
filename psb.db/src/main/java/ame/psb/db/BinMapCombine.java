package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class BinMapCombine {

  private String id;

  private String prodMapDefBo;

  private String sfcBo;

  private String operationBo;

  private String customerItemBo;

  private String incomingMapRuleBo;

  private String goldenMapRuleBo;

  private String cpMapRuleBo;

  private String outGoingMapRuleBo;

  private String combined;

  private BigDecimal yield;

  private Integer dieQty;

  private Integer defectQty;

  private String dieGradeModified;

  private String goldenMapPath;

  private String outGoingMapPath;

  private String changedDies;

  private String updatedUser;

  private Date updatedDateTime;

  private boolean outputFlag;

  public BinMapCombine() {
    this.id = UUID.randomUUID().toString();
  }

  public BinMapCombine(BinMapCombine data) {
    this.id = data.id;
    this.customerItemBo = data.customerItemBo;
    this.incomingMapRuleBo = data.incomingMapRuleBo;
    this.goldenMapRuleBo = data.goldenMapRuleBo;
    this.cpMapRuleBo = data.cpMapRuleBo;
    this.outGoingMapRuleBo = data.outGoingMapRuleBo;
    this.combined = data.combined;
    this.yield = data.yield;
    this.dieQty = data.dieQty;
    this.defectQty = data.defectQty;
    this.dieGradeModified = data.dieGradeModified;
    this.goldenMapPath = data.goldenMapPath;
    this.outGoingMapPath = data.outGoingMapPath;
    this.changedDies = data.changedDies;
    this.updatedUser = data.updatedUser;
    this.updatedDateTime = data.updatedDateTime;
    this.outputFlag = data.outputFlag;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProdMapDefBo() {
    return this.prodMapDefBo;
  }

  public void setProdMapDefBo(String prodMapDefBo) {
    this.prodMapDefBo = prodMapDefBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getIncomingMapRuleBo() {
    return this.incomingMapRuleBo;
  }

  public void setIncomingMapRuleBo(String incomingMapRuleBo) {
    this.incomingMapRuleBo = incomingMapRuleBo;
  }

  public String getGoldenMapRuleBo() {
    return this.goldenMapRuleBo;
  }

  public void setGoldenMapRuleBo(String goldenMapRuleBo) {
    this.goldenMapRuleBo = goldenMapRuleBo;
  }

  public String getCpMapRuleBo() {
    return this.cpMapRuleBo;
  }

  public void setCpMapRuleBo(String cpMapRuleBo) {
    this.cpMapRuleBo = cpMapRuleBo;
  }

  public String getOutGoingMapRuleBo() {
    return this.outGoingMapRuleBo;
  }

  public void setOutGoingMapRuleBo(String outGoingMapRuleBo) {
    this.outGoingMapRuleBo = outGoingMapRuleBo;
  }

  public String getCombined() {
    return this.combined;
  }

  public void setCombined(String combined) {
    this.combined = combined;
  }

  public BigDecimal getYield() {
    return this.yield;
  }

  public void setYield(BigDecimal yield) {
    this.yield = yield;
  }

  public Integer getDieQty() {
    return this.dieQty;
  }

  public void setDieQty(Integer dieQty) {
    this.dieQty = dieQty;
  }

  public Integer getDefectQty() {
    return this.defectQty;
  }

  public void setDefectQty(Integer defectQty) {
    this.defectQty = defectQty;
  }

  public String getDieGradeModified() {
    return this.dieGradeModified;
  }

  public void setDieGradeModified(String dieGradeModified) {
    this.dieGradeModified = dieGradeModified;
  }

  public String getGoldenMapPath() {
    return this.goldenMapPath;
  }

  public void setGoldenMapPath(String goldenMapPath) {
    this.goldenMapPath = goldenMapPath;
  }

  public String getOutGoingMapPath() {
    return this.outGoingMapPath;
  }

  public void setOutGoingMapPath(String outGoingMapPath) {
    this.outGoingMapPath = outGoingMapPath;
  }

  public String getChangedDies() {
    return this.changedDies;
  }

  public void setChangedDies(String changedDies) {
    this.changedDies = changedDies;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedDateTime() {
    return this.updatedDateTime;
  }

  public void setUpdatedDateTime(Date updatedDateTime) {
    this.updatedDateTime = updatedDateTime;
  }


  public boolean getOutputFlag() {
    return outputFlag;
  }

  public void setOutputFlag(boolean outputFlag) {
    this.outputFlag = outputFlag;
  }

  @Override
  public BinMapCombine clone() {
    return new BinMapCombine(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}