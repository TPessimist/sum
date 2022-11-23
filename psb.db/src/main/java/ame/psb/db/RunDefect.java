package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class RunDefect {

  private String id;

  private String sfcBo;

  private String resourceBo;

  private String operationBo;

  private String customerItemBo;

  private String ncCodeBo;

  private BigDecimal ncValue;

  private String runUser;

  private Date runTime;


  public RunDefect() {
    this.id = UUID.randomUUID().toString();
    this.runTime = new Date();
  }

  public RunDefect(RunDefect data) {
    this.id = data.id;
    this.sfcBo = data.sfcBo;
    this.resourceBo = data.resourceBo;
    this.operationBo = data.operationBo;
    this.customerItemBo = data.customerItemBo;
    this.ncCodeBo = data.ncCodeBo;
    this.ncValue = data.ncValue;
    this.runUser = data.runUser;
    this.runTime = data.runTime;
  }

  @Override
  public RunDefect clone() {
    return new RunDefect(this);
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

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getNcCodeBo() {
    return ncCodeBo;
  }

  public void setNcCodeBo(String ncCodeBo) {
    this.ncCodeBo = ncCodeBo;
  }

  public BigDecimal getNcValue() {
    return ncValue;
  }

  public void setNcValue(BigDecimal ncValue) {
    this.ncValue = ncValue;
  }

  public String getRunUser() {
    return runUser;
  }

  public void setRunUser(String runUser) {
    this.runUser = runUser;
  }

  public Date getRunTime() {
    return runTime;
  }

  public void setRunTime(Date runTime) {
    this.runTime = runTime;
  }
}