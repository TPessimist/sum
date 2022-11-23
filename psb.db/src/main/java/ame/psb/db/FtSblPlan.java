package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class FtSblPlan {

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

  private String updatedUser;

  private Date updatedTime;

  private String resourceType;

  public FtSblPlan() {
  }

  public FtSblPlan(FtSblPlan data) {
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
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
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

  public String getResourceType() {
    return resourceType;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  @Override
  public FtSblPlan clone() {
    return new FtSblPlan(this);
  }

  @Override
  public String toString() {
    return this.itemGroupBo + ", " + this.operationBo + ", " + this.sblParamBo;
  }
}
