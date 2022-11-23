package ame.htks.db;

import java.util.Date;

public class CpResultDetailDaily {

  private String resultId;

  private String binCode;

  private String binQty;

  private Date updatedTime;

  private String operationBo;


  public CpResultDetailDaily() {
  }

  public CpResultDetailDaily(CpResultDetailDaily data) {
    this.resultId = data.resultId;
    this.binCode = data.binCode;
    this.binQty = data.binQty;
    this.updatedTime = data.updatedTime;
    this.operationBo = data.operationBo;
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

  public String getBinQty() {
    return binQty;
  }

  public void setBinQty(String binQty) {
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

  @Override
  public CpResultDetailDaily clone() {
    return new CpResultDetailDaily(this);
  }

  @Override
  public String toString() {
    return this.resultId;
  }
}
