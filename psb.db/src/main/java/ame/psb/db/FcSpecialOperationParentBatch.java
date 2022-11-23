package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class FcSpecialOperationParentBatch {

  private String sfcBo;

  private String batchId;

  private String operation;

  private BigDecimal batchQty;

  private BigDecimal defectQty;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public FcSpecialOperationParentBatch() {
  }

  public FcSpecialOperationParentBatch(FcSpecialOperationParentBatch data) {
    this.sfcBo = data.sfcBo;
    this.batchId = data.batchId;
    this.operation = data.operation;
    this.batchQty = data.batchQty;
    this.defectQty = data.defectQty;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public BigDecimal getBatchQty() {
    return batchQty;
  }

  public void setBatchQty(BigDecimal batchQty) {
    this.batchQty = batchQty;
  }

  public BigDecimal getDefectQty() {
    return defectQty;
  }

  public void setDefectQty(BigDecimal defectQty) {
    this.defectQty = defectQty;
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

  @Override
  public FcSpecialOperationParentBatch clone() {
    return new FcSpecialOperationParentBatch(this);
  }

  @Override
  public String toString() {
    return this.sfcBo + ", " + this.batchId;
  }
}
