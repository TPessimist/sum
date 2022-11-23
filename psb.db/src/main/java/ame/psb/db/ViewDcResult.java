package ame.psb.db;

public class ViewDcResult extends DcResult {

  private String customerItemsetBo;

  private String customerItemsetName;

  private String sfcName;

  public String getCustomerItemsetBo() {
    return this.customerItemsetBo;
  }

  public void setCustomerItemsetBo(String customerItemsetBo) {
    this.customerItemsetBo = customerItemsetBo;
  }

  public String getCustomerItemsetName() {
    return this.customerItemsetName;
  }

  public void setCustomerItemsetName(String customerItemsetName) {
    this.customerItemsetName = customerItemsetName;
  }

  public String getSfcName() {
    return this.sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

}
