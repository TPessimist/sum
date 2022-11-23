package ame.psb.db;

import java.math.BigDecimal;

public class ViewBom {

  private String bomBo;

  private String componentGbo;

  private BigDecimal sequence;

  private BigDecimal qty;
  private String operationBo;
  private String description;
  private String sapProduct;

  public ViewBom() {
  }

  public ViewBom(ViewBom data) {
    this.bomBo = data.bomBo;
    this.componentGbo = data.componentGbo;
    this.sequence = data.sequence;
    this.qty = data.qty;
    this.operationBo = data.operationBo;
    this.description = data.description;
    this.sapProduct = data.sapProduct;

  }

  public String getSapProduct() {
    return sapProduct;
  }

  public void setSapProduct(String sapProduct) {
    this.sapProduct = sapProduct;
  }

  public String getBomBo() {
    return bomBo;
  }

  public void setBomBo(String bomBo) {
    this.bomBo = bomBo;
  }

  public String getComponentGbo() {
    return componentGbo;
  }

  public void setComponentGbo(String componentGbo) {
    this.componentGbo = componentGbo;
  }

  public BigDecimal getSequence() {
    return sequence;
  }

  public void setSequence(BigDecimal sequence) {
    this.sequence = sequence;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public ViewBom clone() {
    return new ViewBom(this);
  }

  @Override
  public String toString() {
    return this.bomBo;
  }
}
