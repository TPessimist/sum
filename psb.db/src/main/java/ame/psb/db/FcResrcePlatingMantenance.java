package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class FcResrcePlatingMantenance {

  private String resourceNo;

  private String slotNo;

  private String slotName;

  private String platingName;

  private BigDecimal platingDensity;

  private BigDecimal slotVolume;

  private BigDecimal slotUsage;

  private BigDecimal pLowerLimit;

  private BigDecimal pUpperLimit;

  private BigDecimal platingConc;

  private String packageSpec;

  private BigDecimal offerValue;

  private BigDecimal replacementCycle;

  private BigDecimal realCycle;

  private BigDecimal cLowerLimit;

  private BigDecimal cUpperLimit;

  private BigDecimal cPoint;

  private BigDecimal stosteConc;

  private String updatedUser;

  private Date updatedTime;


  public FcResrcePlatingMantenance() {
  }

  public FcResrcePlatingMantenance(FcResrcePlatingMantenance data) {
    this.resourceNo = data.resourceNo;
    this.slotNo = data.slotNo;
    this.slotName = data.slotName;
    this.platingName = data.platingName;
    this.platingDensity = data.platingDensity;
    this.slotVolume = data.slotVolume;
    this.slotUsage = data.slotUsage;
    this.pLowerLimit = data.pLowerLimit;
    this.pUpperLimit = data.pUpperLimit;
    this.platingConc = data.platingConc;
    this.packageSpec = data.packageSpec;
    this.offerValue = data.offerValue;
    this.replacementCycle = data.replacementCycle;
    this.realCycle = data.realCycle;
    this.cLowerLimit = data.cLowerLimit;
    this.cUpperLimit = data.cUpperLimit;
    this.cPoint = data.cPoint;
    this.stosteConc = data.stosteConc;
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

  public BigDecimal getPlatingDensity() {
    return platingDensity;
  }

  public void setPlatingDensity(BigDecimal platingDensity) {
    this.platingDensity = platingDensity;
  }

  public BigDecimal getSlotVolume() {
    return slotVolume;
  }

  public void setSlotVolume(BigDecimal slotVolume) {
    this.slotVolume = slotVolume;
  }

  public BigDecimal getSlotUsage() {
    return slotUsage;
  }

  public void setSlotUsage(BigDecimal slotUsage) {
    this.slotUsage = slotUsage;
  }

  public BigDecimal getpLowerLimit() {
    return pLowerLimit;
  }

  public void setpLowerLimit(BigDecimal pLowerLimit) {
    this.pLowerLimit = pLowerLimit;
  }

  public BigDecimal getpUpperLimit() {
    return pUpperLimit;
  }

  public void setpUpperLimit(BigDecimal pUpperLimit) {
    this.pUpperLimit = pUpperLimit;
  }

  public BigDecimal getPlatingConc() {
    return platingConc;
  }

  public void setPlatingConc(BigDecimal platingConc) {
    this.platingConc = platingConc;
  }

  public String getPackageSpec() {
    return packageSpec;
  }

  public void setPackageSpec(String packageSpec) {
    this.packageSpec = packageSpec;
  }

  public BigDecimal getOfferValue() {
    return offerValue;
  }

  public void setOfferValue(BigDecimal offerValue) {
    this.offerValue = offerValue;
  }

  public BigDecimal getReplacementCycle() {
    return replacementCycle;
  }

  public void setReplacementCycle(BigDecimal replacementCycle) {
    this.replacementCycle = replacementCycle;
  }

  public BigDecimal getRealCycle() {
    return realCycle;
  }

  public void setRealCycle(BigDecimal realCycle) {
    this.realCycle = realCycle;
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

  public BigDecimal getStosteConc() {
    return stosteConc;
  }

  public void setStosteConc(BigDecimal stosteConc) {
    this.stosteConc = stosteConc;
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
  public FcResrcePlatingMantenance clone() {
    return new FcResrcePlatingMantenance(this);
  }

  @Override
  public String toString() {
    return this.resourceNo + ", " + this.slotNo + ", " + this.platingName;
  }
}
