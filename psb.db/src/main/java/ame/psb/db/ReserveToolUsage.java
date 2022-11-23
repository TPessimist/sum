package ame.psb.db;

import java.util.Date;

public class ReserveToolUsage {

  private String id;

  private String customerItemBo;

  private String toolGroupBo;

  private String sfcBo;

  private String startOperationBo;

  private String endOperationBo;

  private int usage;

  private Date updatedTime;


  public ReserveToolUsage() {
  }

  public ReserveToolUsage(ReserveToolUsage data) {
    this.id = data.id;
    this.customerItemBo = data.customerItemBo;
    this.toolGroupBo = data.toolGroupBo;
    this.sfcBo = data.sfcBo;
    this.startOperationBo = data.startOperationBo;
    this.endOperationBo = data.endOperationBo;
    this.usage = data.usage;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public ReserveToolUsage clone() {
    return new ReserveToolUsage(this);
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

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getToolGroupBo() {
    return toolGroupBo;
  }

  public void setToolGroupBo(String toolGroupBo) {
    this.toolGroupBo = toolGroupBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getStartOperationBo() {
    return startOperationBo;
  }

  public void setStartOperationBo(String startOperationBo) {
    this.startOperationBo = startOperationBo;
  }

  public String getEndOperationBo() {
    return endOperationBo;
  }

  public void setEndOperationBo(String endOperationBo) {
    this.endOperationBo = endOperationBo;
  }

  public int getUsage() {
    return usage;
  }

  public void setUsage(int usage) {
    this.usage = usage;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

}
