package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class FcResrcePlatingAnalysis {

  private String resourceNo;

  private String slotNo;

  private String slotName;

  private String platingName;

  private BigDecimal finalValue;

  private BigDecimal firstValue;

  private BigDecimal analysisValue;

  private BigDecimal suggestedDosage;

  private BigDecimal addTheoryConc;

  private String updatedUser;

  private Date updatedTime;

  private String workClass;

  private String printId;

  public FcResrcePlatingAnalysis() {
  }

  public FcResrcePlatingAnalysis(FcResrcePlatingAnalysis data) {
    this.resourceNo = data.resourceNo;
    this.slotNo = data.slotNo;
    this.slotName = data.slotName;
    this.platingName = data.platingName;
    this.finalValue = data.finalValue;
    this.firstValue = data.firstValue;
    this.analysisValue = data.analysisValue;
    this.suggestedDosage = data.suggestedDosage;
    this.addTheoryConc = data.addTheoryConc;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.workClass = data.workClass;
    this.printId = data.printId;
  }

  public String getResourceNo() {
    return resourceNo;
  }

  public void setResourceNo(String resourceNo) {
    this.resourceNo = resourceNo;
  }

  public String getSlotNo() {
    return slotNo;
  }

  public void setSlotNo(String slotNo) {
    this.slotNo = slotNo;
  }

  public String getSlotName() {
    return slotName;
  }

  public void setSlotName(String slotName) {
    this.slotName = slotName;
  }

  public String getPlatingName() {
    return platingName;
  }

  public void setPlatingName(String platingName) {
    this.platingName = platingName;
  }

  public BigDecimal getFinalValue() {
    return finalValue;
  }

  public void setFinalValue(BigDecimal finalValue) {
    this.finalValue = finalValue;
  }

  public BigDecimal getFirstValue() {
    return firstValue;
  }

  public void setFirstValue(BigDecimal firstValue) {
    this.firstValue = firstValue;
  }

  public BigDecimal getAnalysisValue() {
    return analysisValue;
  }

  public void setAnalysisValue(BigDecimal analysisValue) {
    this.analysisValue = analysisValue;
  }

  public BigDecimal getSuggestedDosage() {
    return suggestedDosage;
  }

  public void setSuggestedDosage(BigDecimal suggestedDosage) {
    this.suggestedDosage = suggestedDosage;
  }

  public BigDecimal getAddTheoryConc() {
    return addTheoryConc;
  }

  public void setAddTheoryConc(BigDecimal addTheoryConc) {
    this.addTheoryConc = addTheoryConc;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getWorkClass() {
    return workClass;
  }

  public void setWorkClass(String workClass) {
    this.workClass = workClass;
  }

  public String getPrintId() {
    return printId;
  }

  public void setPrintId(String printId) {
    this.printId = printId;
  }

  @Override
  public FcResrcePlatingAnalysis clone() {
    return new FcResrcePlatingAnalysis(this);
  }

  @Override
  public String toString() {
    return this.resourceNo + ", " + this.slotNo + ", " + this.platingName;
  }
}
