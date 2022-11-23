package ame.htks.db;

import java.util.Date;

public class CpResultDetail {

  private String resultId;

  private String binCode;

  private int binQty;

  private Date updatedTime;

  private String operationBo;

  public CpResultDetail() {
  }

  public CpResultDetail(CpResultDetail data) {
    this.resultId = data.resultId;
    this.binCode = data.binCode;
    this.binQty = data.binQty;
    this.updatedTime = data.updatedTime;
    this.operationBo = data.operationBo;
  }

  @Override
  public CpResultDetail clone() {
    return new CpResultDetail(this);
  }

  @Override
  public String toString() {
    return this.resultId;
  }

  public String getResultId() {
    return resultId;
  }

  public void setResultId(String resultId) {
    this.resultId = resultId;
  }

  public String getBinCode() {
    return binCode;
  }

  public void setBinCode(String binCode) {
    this.binCode = binCode;
  }

  public int getBinQty() {
    return binQty;
  }

  public void setBinQty(int binQty) {
    this.binQty = binQty;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

}
