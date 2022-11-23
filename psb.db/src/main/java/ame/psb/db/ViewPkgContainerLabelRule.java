package ame.psb.db;

import java.math.BigDecimal;

public class ViewPkgContainerLabelRule extends PkgContainerLabelRule {

  private String labelName;

  private String printerId;

  private String templateId;

  private String itemGroup;

  private String itemGroupDescription;

  private String operation;

  public ViewPkgContainerLabelRule() {
  }

  public ViewPkgContainerLabelRule(ViewPkgContainerLabelRule data) {
    super(data);
    this.labelName = data.labelName;
    this.printerId = data.printerId;
    this.templateId = data.templateId;
    this.itemGroup = data.itemGroup;
    this.itemGroupDescription = data.itemGroupDescription;
    this.operation = data.operation;
  }


  public ViewPkgContainerLabelRule(String labelBo, BigDecimal printQty) {
    this.setLabelBo(labelBo);
    this.setPrintQty(printQty);
  }


  public String getLabelName() {
    return this.labelName;
  }

  public void setLabelName(String labelName) {
    this.labelName = labelName;
  }

  public String getPrinterId() {
    return this.printerId;
  }

  public void setPrinterId(String printerId) {
    this.printerId = printerId;
  }

  public String getTemplateId() {
    return this.templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  public String getItemGroup() {
    return this.itemGroup;
  }

  public void setItemGroup(String itemGroup) {
    this.itemGroup = itemGroup;
  }

  public String getItemGroupDescription() {
    return this.itemGroupDescription;
  }

  public void setItemGroupDescription(String itemGroupDescription) {
    this.itemGroupDescription = itemGroupDescription;
  }

  public String getOperation() {
    return this.operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }


  public String value() {
    return "ViewPkgContainerLabelRule{" +
        "labelName='" + labelName + '\'' +
        ", printerId='" + printerId + '\'' +
        ", templateId='" + templateId + '\'' +
        // ", itemGroup='" + itemGroup + '\'' +
        ", operation='" + operation + '\'' +
        '}';
  }
}
