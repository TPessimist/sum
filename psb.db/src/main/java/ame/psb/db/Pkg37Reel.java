package ame.psb.db;


import java.math.BigDecimal;
import java.util.Date;

public class Pkg37Reel {

  private String reelId;

  private String sfcBo;

  private String stateName;

  private String jobId;

  private BigDecimal reelSeq;

  private BigDecimal dieQty;

  private String resourceBo;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;

  private String sfcName;

  private String stateNameChinese;

  private String resourceName;


  public Pkg37Reel() {
  }

  public Pkg37Reel(Pkg37Reel data) {
    this.reelId = data.reelId;
    this.sfcBo = data.sfcBo;
    this.stateName = data.stateName;
    this.jobId = data.jobId;
    this.reelSeq = data.reelSeq;
    this.dieQty = data.dieQty;
    this.resourceBo = data.resourceBo;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getReelId() {
    return reelId;
  }

  public void setReelId(String reelId) {
    this.reelId = reelId;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public BigDecimal getReelSeq() {
    return reelSeq;
  }

  public void setReelSeq(BigDecimal reelSeq) {
    this.reelSeq = reelSeq;
  }

  public BigDecimal getDieQty() {
    return dieQty;
  }

  public void setDieQty(BigDecimal dieQty) {
    this.dieQty = dieQty;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getReversedField1() {
    return reversedField1;
  }

  public void setReversedField1(String reversedField1) {
    this.reversedField1 = reversedField1;
  }

  public String getReversedField2() {
    return reversedField2;
  }

  public void setReversedField2(String reversedField2) {
    this.reversedField2 = reversedField2;
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

  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getStateNameChinese() {
    return stateNameChinese;
  }

  public void setStateNameChinese(String stateNameChinese) {
    this.stateNameChinese = stateNameChinese;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  @Override
  public Pkg37Reel clone() {
    return new Pkg37Reel(this);
  }

  @Override
  public String toString() {
    return this.reelId + ", " + this.sfcBo;
  }
}
