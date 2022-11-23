package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class PkgContainerLabelRule {

  private String id;

  private String itemGroupBo;

  private String operationBo;

  private String packingType;

  private String packingPlan;

  private String customerOfCustomer;

  private BigDecimal printQty;

  private String labelBo;

  private String updatedUser;

  private Date updatedTime;

  public PkgContainerLabelRule() {
  }

  public PkgContainerLabelRule(PkgContainerLabelRule data) {
    this.id = data.id;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.packingType = data.packingType;
    this.packingPlan = data.packingPlan;
    this.customerOfCustomer = data.customerOfCustomer;
    this.printQty = data.printQty;
    this.labelBo = data.labelBo;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getPackingType() {
    return this.packingType;
  }

  public void setPackingType(String packingType) {
    this.packingType = packingType;
  }

  public String getPackingPlan() {
    return this.packingPlan;
  }

  public void setPackingPlan(String packingPlan) {
    this.packingPlan = packingPlan;
  }

  public String getCustomerOfCustomer() {
    return this.customerOfCustomer;
  }

  public void setCustomerOfCustomer(String customerOfCustomer) {
    this.customerOfCustomer = customerOfCustomer;
  }

  public BigDecimal getPrintQty() {
    return this.printQty;
  }

  public void setPrintQty(BigDecimal printQty) {
    this.printQty = printQty;
  }

  public String getLabelBo() {
    return this.labelBo;
  }

  public void setLabelBo(String labelBo) {
    this.labelBo = labelBo;
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
  public PkgContainerLabelRule clone() {
    return new PkgContainerLabelRule(this);
  }

  @Override
  public String toString() {
    return this.id + "@" + this.itemGroupBo;
  }
}
