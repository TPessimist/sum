package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ViewToolingMask {

  private String handle;

  private String site;

  private String statusBo;

  private String description;

  private BigDecimal qty;

  private Date expDate;

  private String toolGroup;

  private String criteria1;

  private String criteria2;

  public ViewToolingMask() {
  }

  public ViewToolingMask(ViewToolingMask data) {
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

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getSite() {
    return this.site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getStatusBo() {
    return this.statusBo;
  }

  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getQty() {
    return this.qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public Date getExpDate() {
    return this.expDate;
  }

  public void setExpDate(Date expDate) {
    this.expDate = expDate;
  }

  public String getToolGroup() {
    return this.toolGroup;
  }

  public void setToolGroup(String toolGroup) {
    this.toolGroup = toolGroup;
  }

  public String getCriteria1() {
    return this.criteria1;
  }

  public void setCriteria1(String criteria1) {
    this.criteria1 = criteria1;
  }

  public String getCriteria2() {
    return this.criteria2;
  }

  public void setCriteria2(String criteria2) {
    this.criteria2 = criteria2;
  }

  @Override
  public ViewToolingMask clone() {
    return new ViewToolingMask(this);
  }

  @Override
  public String toString() {
    return this.handle + "," + this.toolGroup;
  }
}
