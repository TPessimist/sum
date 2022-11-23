package ame.psb.db;

public class ViewCpTestTime extends ZrCpTestTime {

  private String customerItemName;

  private String operationName;

  public ViewCpTestTime() {

  }

  public ViewCpTestTime(ZrCpTestTime testtime) {
    super(testtime);
  }

  public ViewCpTestTime(String sfcName, String customerItemName, String operationName) {
    setSfcName(sfcName);
    this.customerItemName = customerItemName;
    this.operationName = operationName;
  }

  public String getCustomerItemName() {
    return customerItemName;
  }

  public void setCustomerItemName(String customerItemName) {
    this.customerItemName = customerItemName;
  }

  public String getOperationName() {
    return operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }
}
