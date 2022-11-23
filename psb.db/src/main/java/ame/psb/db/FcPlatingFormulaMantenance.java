package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class FcPlatingFormulaMantenance {

  private String resourceNo;

  private String slotNo;

  private String slotName;

  private String platingName;

  private BigDecimal modulus;

  private String solutionName;

  private BigDecimal platingConc;

  private boolean deoxidationFlag = false;

  private String formulaDesc;

  private String updatedUser;

  private Date updatedTime;


  public FcPlatingFormulaMantenance() {
  }

  public FcPlatingFormulaMantenance(FcPlatingFormulaMantenance data) {
    this.resourceNo = data.resourceNo;
    this.slotNo = data.slotNo;
    this.slotName = data.slotName;
    this.platingName = data.platingName;
    this.modulus = data.modulus;
    this.solutionName = data.solutionName;
    this.platingConc = data.platingConc;
    this.deoxidationFlag = data.deoxidationFlag;
    this.formulaDesc = data.formulaDesc;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
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

  public BigDecimal getModulus() {
    return modulus;
  }

  public void setModulus(BigDecimal modulus) {
    this.modulus = modulus;
  }

  public String getSolutionName() {
    return solutionName;
  }

  public void setSolutionName(String solutionName) {
    this.solutionName = solutionName;
  }

  public BigDecimal getPlatingConc() {
    return platingConc;
  }

  public void setPlatingConc(BigDecimal platingConc) {
    this.platingConc = platingConc;
  }

  public boolean isDeoxidationFlag() {
    return deoxidationFlag;
  }

  public void setDeoxidationFlag(boolean deoxidationFlag) {
    this.deoxidationFlag = deoxidationFlag;
  }

  public String getFormulaDesc() {
    return formulaDesc;
  }

  public void setFormulaDesc(String formulaDesc) {
    this.formulaDesc = formulaDesc;
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

  @Override
  public FcPlatingFormulaMantenance clone() {
    return new FcPlatingFormulaMantenance(this);
  }

  @Override
  public String toString() {
    return this.resourceNo + ", " + this.platingName;
  }
}
