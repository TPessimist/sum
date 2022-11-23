package ame.psb.db;

import java.util.UUID;

public class ContainerLabelRule {

  private String id;

  private String itemGroupBo;

  private String operationBo;

  private String packingType;

  private String packingPlan;

  private String customerOfCustomer;

  private int printQty;

  private String labelBo;

  public ContainerLabelRule() {
    this.id = UUID.randomUUID().toString();
  }

  public ContainerLabelRule(ContainerLabelRule data) {
    this.id = data.id;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.packingType = data.packingType;
    this.packingPlan = data.packingPlan;
    this.customerOfCustomer = data.customerOfCustomer;
    this.printQty = data.printQty;
    this.labelBo = data.labelBo;
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

  public int getPrintQty() {
    return this.printQty;
  }

  public void setPrintQty(int printQty) {
    this.printQty = printQty;
  }

  public String getLabelBo() {
    return this.labelBo;
  }

  public void setLabelBo(String labelBo) {
    this.labelBo = labelBo;
  }

  @Override
  public ContainerLabelRule clone() {
    return new ContainerLabelRule(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
