package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ProductTypeOperationResource {

  private String productType;

  private String operationBo;

  private String resourceBo;

  private BigDecimal seq;

  private String itemGroupBo;

  private String updatedUser;

  private Date updatedTime;


  public ProductTypeOperationResource() {
  }

  public ProductTypeOperationResource(ProductTypeOperationResource data) {
    this.productType = data.productType;
    this.operationBo = data.operationBo;
    this.resourceBo = data.resourceBo;
    this.seq = data.seq;
    this.itemGroupBo = data.itemGroupBo;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public BigDecimal getSeq() {
    return seq;
  }

  public void setSeq(BigDecimal seq) {
    this.seq = seq;
  }

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
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
  public ProductTypeOperationResource clone() {
    return new ProductTypeOperationResource(this);
  }

  @Override
  public String toString() {
    return this.productType;
  }
}
