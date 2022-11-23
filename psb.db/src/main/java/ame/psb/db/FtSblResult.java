package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class FtSblResult {

  private String batchId;

  private String sfcBo;

  private String itemGroupBo;

  private String operationBo;

  private String sblParamBo;

  private String sblParamDesc;

  private String sblFileSourece;

  private String sblFileType;

  private String sblFormula;

  private BigDecimal sblUsl;

  private BigDecimal sblLsl;

  private String memo;

  private BigDecimal sblValue;

  private String updatedUser;

  private Date updatedTime;


  public FtSblResult() {
  }

  public FtSblResult(FtSblResult data) {
    this.batchId = data.batchId;
    this.sfcBo = data.sfcBo;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.sblParamBo = data.sblParamBo;
    this.sblParamDesc = data.sblParamDesc;
    this.sblFileSourece = data.sblFileSourece;
    this.sblFileType = data.sblFileType;
    this.sblFormula = data.sblFormula;
    this.sblUsl = data.sblUsl;
    this.sblLsl = data.sblLsl;
    this.memo = data.memo;
    this.sblValue = data.sblValue;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }


  public String getBatchId() {
    return batchId;
  }

  public void setBatchId(String batchId) {
    this.batchId = batchId;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getSblParamBo() {
    return sblParamBo;
  }

  public void setSblParamBo(String sblParamBo) {
    this.sblParamBo = sblParamBo;
  }

  public String getSblParamDesc() {
    return sblParamDesc;
  }

  public void setSblParamDesc(String sblParamDesc) {
    this.sblParamDesc = sblParamDesc;
  }

  public String getSblFileSourece() {
    return sblFileSourece;
  }

  public void setSblFileSourece(String sblFileSourece) {
    this.sblFileSourece = sblFileSourece;
  }

  public String getSblFileType() {
    return sblFileType;
  }

  public void setSblFileType(String sblFileType) {
    this.sblFileType = sblFileType;
  }

  public String getSblFormula() {
    return sblFormula;
  }

  public void setSblFormula(String sblFormula) {
    this.sblFormula = sblFormula;
  }

  public BigDecimal getSblUsl() {
    return sblUsl;
  }

  public void setSblUsl(BigDecimal sblUsl) {
    this.sblUsl = sblUsl;
  }

  public BigDecimal getSblLsl() {
    return sblLsl;
  }

  public void setSblLsl(BigDecimal sblLsl) {
    this.sblLsl = sblLsl;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public BigDecimal getSblValue() {
    return sblValue;
  }

  public void setSblValue(BigDecimal sblValue) {
    this.sblValue = sblValue;
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
  public FtSblResult clone() {
    return new FtSblResult(this);
  }

  @Override
  public String toString() {
    return this.batchId + ", " + this.itemGroupBo + ", " + this.operationBo + ", "
        + this.sblParamBo;
  }
}
