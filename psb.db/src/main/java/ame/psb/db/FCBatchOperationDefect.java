package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class FCBatchOperationDefect {

  private String batchId;

  private String operationBo;

  private String ncCodeBo;

  private BigDecimal ncValue;

  private String updatedUser;

  private Date updatedTime;


  public FCBatchOperationDefect() {
  }

  public FCBatchOperationDefect(String batchId, String operationBo, String ncCodeBo,
      BigDecimal ncValue, String updatedUser, Date updatedTime) {
    this.batchId = batchId;
    this.operationBo = operationBo;
    this.ncCodeBo = ncCodeBo;
    this.ncValue = ncValue;
    this.updatedUser = updatedUser;
    this.updatedTime = updatedTime;
  }

  public FCBatchOperationDefect(FCBatchOperationDefect data) {
    this.batchId = data.batchId;
    this.operationBo = data.operationBo;
    this.ncCodeBo = data.ncCodeBo;
    this.ncValue = data.ncValue;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getNcCodeBo() {
    return ncCodeBo;
  }

  public void setNcCodeBo(String ncCodeBo) {
    this.ncCodeBo = ncCodeBo;
  }

  public BigDecimal getNcValue() {
    return ncValue;
  }

  public void setNcValue(BigDecimal ncValue) {
    this.ncValue = ncValue;
  }

  public int getIntNcValue() {
    return ncValue.intValue();
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
  public FCBatchOperationDefect clone() {
    return new FCBatchOperationDefect(this);
  }

  @Override
  public String toString() {
    return this.batchId + ", " + this.operationBo + ", " + this.ncCodeBo;
  }
}
