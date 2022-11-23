package ame.psb.db;

public class ViewPkgContainer extends PkgContainer {

  private String itemName;

  private String operationName;

  private String checkWeightFlag;

  private String carrierName;

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getOperationName() {
    return this.operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  public String getCheckWeightFlag() {
    return checkWeightFlag;
  }

  public void setCheckWeightFlag(String checkWeightFlag) {
    this.checkWeightFlag = checkWeightFlag;
  }

  public String getCarrierName() {
    return carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }
}
