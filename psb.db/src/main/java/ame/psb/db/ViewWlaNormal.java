package ame.psb.db;

public class ViewWlaNormal extends ZrWlaNormal {

  private String sfcName;

  private String customerItemsetName;

  private int itemQty;

  private String operationName;

  public ViewWlaNormal() {
  }

  public ViewWlaNormal(ZrWlaNormal normal) {
    super(normal);
  }

  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getCustomerItemsetName() {
    return customerItemsetName;
  }

  public void setCustomerItemsetName(String customerItemsetName) {
    this.customerItemsetName = customerItemsetName;
  }

  public int getItemQty() {
    return itemQty;
  }

  public void setItemQty(int itemQty) {
    this.itemQty = itemQty;
  }

  public String getOperationName() {
    return operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }
}
