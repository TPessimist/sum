package ame.psb.db;

import java.math.BigDecimal;

public class ViewFcResrcePlatingAnalysis
    extends FcResrcePlatingAnalysis {

  private BigDecimal cLowerLimit;

  private BigDecimal cUpperLimit;

  private BigDecimal cPoint;

  private BigDecimal slotVolume;

  private BigDecimal stosteConc;

  private boolean bathAcidFlag = false;

  private boolean bathTinFlag = false;

  private BigDecimal tinAnalysisValue;

  public ViewFcResrcePlatingAnalysis() {
  }

  public ViewFcResrcePlatingAnalysis(FcResrcePlatingAnalysis analysis) {
    super(analysis);
  }

  public BigDecimal getcLowerLimit() {
    return cLowerLimit;
  }

  public void setcLowerLimit(BigDecimal cLowerLimit) {
    this.cLowerLimit = cLowerLimit;
  }

  public BigDecimal getcUpperLimit() {
    return cUpperLimit;
  }

  public void setcUpperLimit(BigDecimal cUpperLimit) {
    this.cUpperLimit = cUpperLimit;
  }

  public BigDecimal getcPoint() {
    return cPoint;
  }

  public void setcPoint(BigDecimal cPoint) {
    this.cPoint = cPoint;
  }

  public BigDecimal getSlotVolume() {
    return slotVolume;
  }

  public void setSlotVolume(BigDecimal slotVolume) {
    this.slotVolume = slotVolume;
  }

  public BigDecimal getStosteConc() {
    return stosteConc;
  }

  public void setStosteConc(BigDecimal stosteConc) {
    this.stosteConc = stosteConc;
  }

  public boolean isBathAcidFlag() {
    return bathAcidFlag;
  }

  public void setBathAcidFlag(boolean bathAcidFlag) {
    this.bathAcidFlag = bathAcidFlag;
  }

  public boolean isBathTinFlag() {
    return bathTinFlag;
  }

  public void setBathTinFlag(boolean bathTinFlag) {
    this.bathTinFlag = bathTinFlag;
  }

  public BigDecimal getTinAnalysisValue() {
    return tinAnalysisValue;
  }

  public void setTinAnalysisValue(BigDecimal tinAnalysisValue) {
    this.tinAnalysisValue = tinAnalysisValue;
  }

}
