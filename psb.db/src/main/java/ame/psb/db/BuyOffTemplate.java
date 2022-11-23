package ame.psb.db;

import java.util.Date;

public class BuyOffTemplate {

  private String id;

  private String factorName;

  private String factorType;

  private String customProps;

  private String operationBo;

  private String validator;

  private String seq;

  private String buyoffType;

  private String roleType;

  private String byType;

  private String updatedUser;

  private Date updatedTime;


  public BuyOffTemplate() {
  }

  public BuyOffTemplate(BuyOffTemplate data) {
    this.id = data.id;
    this.factorName = data.factorName;
    this.factorType = data.factorType;
    this.customProps = data.customProps;
    this.operationBo = data.operationBo;
    this.validator = data.validator;
    this.seq = data.seq;
    this.buyoffType = data.buyoffType;
    this.roleType = data.roleType;
    this.byType = data.byType;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public BuyOffTemplate clone() {
    return new BuyOffTemplate(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFactorName() {
    return factorName;
  }

  public void setFactorName(String factorName) {
    this.factorName = factorName;
  }

  public String getFactorType() {
    return factorType;
  }

  public void setFactorType(String factorType) {
    this.factorType = factorType;
  }

  public String getCustomProps() {
    return customProps;
  }

  public void setCustomProps(String customProps) {
    this.customProps = customProps;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getValidator() {
    return validator;
  }

  public void setValidator(String validator) {
    this.validator = validator;
  }

  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }

  public String getBuyoffType() {
    return buyoffType;
  }

  public void setBuyoffType(String buyoffType) {
    this.buyoffType = buyoffType;
  }

  public String getRoleType() {
    return roleType;
  }

  public void setRoleType(String roleType) {
    this.roleType = roleType;
  }

  public String getByType() {
    return byType;
  }

  public void setByType(String byType) {
    this.byType = byType;
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
}
