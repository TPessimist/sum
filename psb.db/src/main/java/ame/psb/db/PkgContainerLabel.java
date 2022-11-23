package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class PkgContainerLabel {

  private String containerBo;

  private String labelBo;

  private BigDecimal printQty;

  private String printContent;

  private String stateName;

  private String createdUser;

  private Date createdTime;

  public PkgContainerLabel() {
    this.createdTime = new Date();
  }

  public PkgContainerLabel(PkgContainerLabel data) {
    this.containerBo = data.containerBo;
    this.labelBo = data.labelBo;
    this.printQty = data.printQty;
    this.printContent = data.printContent;
    this.stateName = data.stateName;
    this.createdUser = data.createdUser;
    this.createdTime = data.createdTime;
    this.stateName = "DONE";
  }

  public String getContainerBo() {
    return this.containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getLabelBo() {
    return this.labelBo;
  }

  public void setLabelBo(String labelBo) {
    this.labelBo = labelBo;
  }

  public BigDecimal getPrintQty() {
    return this.printQty;
  }

  public void setPrintQty(BigDecimal printQty) {
    this.printQty = printQty;
  }

  public String getPrintContent() {
    return this.printContent;
  }

  public void setPrintContent(String printContent) {
    this.printContent = printContent;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCreatedUser() {
    return this.createdUser;
  }

  public void setCreatedUser(String createdUser) {
    this.createdUser = createdUser;
  }

  public Date getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  @Override
  public PkgContainerLabel clone() {
    return new PkgContainerLabel(this);
  }

  @Override
  public String toString() {
    return this.containerBo + ", " + this.labelBo;
  }
}
