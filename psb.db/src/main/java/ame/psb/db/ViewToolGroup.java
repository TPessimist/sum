package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ViewToolGroup {

  private String handle;

  private String site;

  private String statusBo;

  private String description;

  private BigDecimal qty;

  private Date expDate;

  private String toolGroup;

  private String criteria1;

  private String criteria2;

  private String criteria3;

  private String requiredQty;

  @Deprecated
  private int qtyReq;


  public ViewToolGroup() {
  }

  public ViewToolGroup(ViewToolGroup data) {
    this.handle = data.handle;
    this.site = data.site;
    this.statusBo = data.statusBo;
    this.description = data.description;
    this.qty = data.qty;
    this.expDate = data.expDate;
    this.toolGroup = data.toolGroup;
    this.criteria1 = data.criteria1;
    this.criteria2 = data.criteria2;
  }

  @Override
  public ViewToolGroup clone() {
    return new ViewToolGroup(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getStatusBo() {
    return statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public Date getExpDate() {
    return expDate;
  }

  public void setExpDate(Date expDate) {
    this.expDate = expDate;
  }

  public String getToolGroup() {
    return toolGroup;
  }

  public void setToolGroup(String toolGroup) {
    this.toolGroup = toolGroup;
  }

  public String getCriteria1() {
    return criteria1;
  }

  public void setCriteria1(String criteria1) {
    this.criteria1 = criteria1;
  }

  public String getCriteria2() {
    return criteria2;
  }

  public void setCriteria2(String criteria2) {
    this.criteria2 = criteria2;
  }


  public String getCriteria3() {
    return criteria3;
  }

  public void setCriteria3(String criteria3) {
    this.criteria3 = criteria3;
  }

  public String getRequiredQty() {
    return requiredQty;
  }

  public void setRequiredQty(String requiredQty) {
    this.requiredQty = requiredQty;
  }

  public int getQtyReq() {
    return qtyReq;
  }

  public void setQtyReq(int qtyReq) {
    this.qtyReq = qtyReq;
  }


}
