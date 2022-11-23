package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class ViewQueueTime extends QueueTime {

  private String packageName;

  private String itemGroupName;

  private String itemName;

  private String beginOperation;

  private String endOperation;

  private String customerBo;

  private String customerName;

  public String getPackageName() {
    return this.packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getItemGroupName() {
    return this.itemGroupName;
  }

  public void setItemGroupName(String itemGroupName) {
    this.itemGroupName = itemGroupName;
  }

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getBeginOperation() {
    return this.beginOperation;
  }

  public void setBeginOperation(String beginOperation) {
    this.beginOperation = beginOperation;
  }

  public String getEndOperation() {
    return this.endOperation;
  }

  public void setEndOperation(String endOperation) {
    this.endOperation = endOperation;
  }

  public String getCustomerBo() {
    return this.customerBo;
  }

  public void setCustomerBo(String customerBo) {
    this.customerBo = customerBo;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

}
