package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class NcOperationCodeSpec {

  private String ncCodeBo;

  private String itemGroupBo;

  private String operationBo;

  private BigDecimal waferUcl;

  private BigDecimal waferLcl;

  private BigDecimal lotUcl;

  private BigDecimal lotLcl;

  private String updatedUser;

  private Date updatedTime;

  private String remarks;

  private BigDecimal waferUclCount;

  private BigDecimal waferLclCount;

  private BigDecimal lotUclCount;

  private BigDecimal lotLclCount;

  public NcOperationCodeSpec() {
    this.updatedTime = new Date();
  }

  public NcOperationCodeSpec(NcOperationCodeSpec data) {
    this.ncCodeBo = data.ncCodeBo;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.waferUcl = data.waferUcl;
    this.waferLcl = data.waferLcl;
    this.lotUcl = data.lotUcl;
    this.lotLcl = data.lotLcl;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.remarks = data.remarks;
    this.waferUclCount = data.waferUclCount;
    this.waferLclCount = data.waferLclCount;
    this.lotUclCount = data.lotUclCount;
    this.lotLclCount = data.lotLclCount;
  }

  public BigDecimal getWaferUclCount() {
    return waferUclCount;
  }

  public void setWaferUclCount(BigDecimal waferUclCount) {
    this.waferUclCount = waferUclCount;
  }

  public BigDecimal getWaferLclCount() {
    return waferLclCount;
  }

  public void setWaferLclCount(BigDecimal waferLclCount) {
    this.waferLclCount = waferLclCount;
  }

  public BigDecimal getLotUclCount() {
    return lotUclCount;
  }

  public void setLotUclCount(BigDecimal lotUclCount) {
    this.lotUclCount = lotUclCount;
  }

  public BigDecimal getLotLclCount() {
    return lotLclCount;
  }

  public void setLotLclCount(BigDecimal lotLclCount) {
    this.lotLclCount = lotLclCount;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getNcCodeBo() {
    return this.ncCodeBo;
  }

  public void setNcCodeBo(String ncCodeBo) {
    this.ncCodeBo = ncCodeBo;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }


  public BigDecimal getWaferUcl() {
    return waferUcl;
  }

  public void setWaferUcl(BigDecimal waferUcl) {
    this.waferUcl = waferUcl;
  }

  public BigDecimal getWaferLcl() {
    return waferLcl;
  }

  public void setWaferLcl(BigDecimal waferLcl) {
    this.waferLcl = waferLcl;
  }

  public BigDecimal getLotUcl() {
    return lotUcl;
  }

  public void setLotUcl(BigDecimal lotUcl) {
    this.lotUcl = lotUcl;
  }

  public BigDecimal getLotLcl() {
    return lotLcl;
  }

  public void setLotLcl(BigDecimal lotLcl) {
    this.lotLcl = lotLcl;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  @Override
  public NcOperationCodeSpec clone() {
    return new NcOperationCodeSpec(this);
  }

  @Override
  public String toString() {
    return this.ncCodeBo + ", " + this.itemGroupBo + ", " + this.operationBo;
  }
}
