package ame.psb.db;

public class ViewSfcItemGrade extends SfcItemGrade {

  private String customerItemName;

  private String sfcName;

  public String getCustomerItemName() {
    return this.customerItemName;
  }

  public void setCustomerItemName(String customerItemName) {
    this.customerItemName = customerItemName;
  }

  public String getSfcName() {
    return this.sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

}
