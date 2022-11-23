package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class NcCodeSpec {

  private String id;

  private String operationBo;

  private String ncCodeBo;

  private String itemGroupBo;

  private String shopOrderBo;

  private String customerItemsetName;

  private String waferId;

  private BigDecimal waferUcl;

  private BigDecimal waferLcl;

  private BigDecimal lotUcl;

  private BigDecimal lotLcl;

  private BigDecimal waferUclCount;

  private BigDecimal waferLclCount;

  private BigDecimal lotUclCount;

  private BigDecimal lotLclCount;

  private String ncCodeName;

  private String ncCodeDesc;

  private String remarks;

  private String updatedUser;

  private Date updatedTime;


  public NcCodeSpec() {
  }

  public NcCodeSpec(NcCodeSpec data) {
    this.id = data.id;
    this.operationBo = data.operationBo;
    this.ncCodeBo = data.ncCodeBo;
    this.itemGroupBo = data.itemGroupBo;
    this.shopOrderBo = data.shopOrderBo;
    this.customerItemsetName = data.customerItemsetName;
    this.waferId = data.waferId;
    this.waferUcl = data.waferUcl;
    this.waferLcl = data.waferLcl;
    this.lotUcl = data.lotUcl;
    this.lotLcl = data.lotLcl;
    this.waferUclCount = data.waferUclCount;
    this.waferLclCount = data.waferLclCount;
    this.lotUclCount = data.lotUclCount;
    this.lotLclCount = data.lotLclCount;
    this.ncCodeName = data.ncCodeName;
    this.ncCodeDesc = data.ncCodeDesc;
    this.remarks = data.remarks;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getCustomerItemsetName() {
    return customerItemsetName;
  }

  public void setCustomerItemsetName(String customerItemsetName) {
    this.customerItemsetName = customerItemsetName;
  }

  public String getWaferId() {
    return waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
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

  public String getNcCodeName() {
    return ncCodeName;
  }

  public void setNcCodeName(String ncCodeName) {
    this.ncCodeName = ncCodeName;
  }

  public String getNcCodeDesc() {
    return ncCodeDesc;
  }

  public void setNcCodeDesc(String ncCodeDesc) {
    this.ncCodeDesc = ncCodeDesc;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
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
  public NcCodeSpec clone() {
    return new NcCodeSpec(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
