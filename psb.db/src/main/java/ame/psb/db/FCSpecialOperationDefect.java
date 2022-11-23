package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class FCSpecialOperationDefect {

  private String batchId;

  private String currentOperation;

  private String latestSpecialOperation;

  private BigDecimal batchGoodDieQty;

  private BigDecimal batchBadDieQty;

  private BigDecimal batchStripQty;

  private BigDecimal batchGoodStripQty;

  private BigDecimal batchSfcQty;

  private String reversedField1;

  private String reversedField2;

  private String updatedUser;

  private Date updatedTime;


  public FCSpecialOperationDefect() {
  }

  public FCSpecialOperationDefect(FCSpecialOperationDefect data) {
    this.batchId = data.batchId;
    this.currentOperation = data.currentOperation;
    this.latestSpecialOperation = data.latestSpecialOperation;
    this.batchGoodDieQty = data.batchGoodDieQty;
    this.batchBadDieQty = data.batchBadDieQty;
    this.batchStripQty = data.batchStripQty;
    this.batchGoodStripQty = data.batchGoodStripQty;
    this.batchSfcQty = data.batchSfcQty;
    this.reversedField1 = data.reversedField1;
    this.reversedField2 = data.reversedField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getCurrentOperation() {
    return currentOperation;
  }

  public void setCurrentOperation(String currentOperation) {
    this.currentOperation = currentOperation;
  }

  public String getLatestSpecialOperation() {
    return latestSpecialOperation;
  }

  public void setLatestSpecialOperation(String latestSpecialOperation) {
    this.latestSpecialOperation = latestSpecialOperation;
  }

  public BigDecimal getBatchGoodDieQty() {
    return batchGoodDieQty;
  }

  public void setBatchGoodDieQty(BigDecimal batchGoodDieQty) {
    this.batchGoodDieQty = batchGoodDieQty;
  }

  public BigDecimal getBatchBadDieQty() {
    return batchBadDieQty;
  }

  public void setBatchBadDieQty(BigDecimal batchBadDieQty) {
    this.batchBadDieQty = batchBadDieQty;
  }

  public BigDecimal getBatchStripQty() {
    return batchStripQty;
  }

  public void setBatchStripQty(BigDecimal batchStripQty) {
    this.batchStripQty = batchStripQty;
  }

  public BigDecimal getBatchGoodStripQty() {
    return batchGoodStripQty;
  }

  public void setBatchGoodStripQty(BigDecimal batchGoodStripQty) {
    this.batchGoodStripQty = batchGoodStripQty;
  }

  public BigDecimal getBatchSfcQty() {
    return batchSfcQty;
  }

  public void setBatchSfcQty(BigDecimal batchSfcQty) {
    this.batchSfcQty = batchSfcQty;
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
  public FCSpecialOperationDefect clone() {
    return new FCSpecialOperationDefect(this);
  }

  @Override
  public String toString() {
    return this.batchId + ", " + this.latestSpecialOperation;
  }
}
