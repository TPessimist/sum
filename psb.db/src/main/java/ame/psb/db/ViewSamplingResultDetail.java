package ame.psb.db;

public class ViewSamplingResultDetail extends SamplingResultDetail {

  private String customerItem;

  private String carrierBo;

  private String sfcBo;

  public String getCustomerItem() {
    return this.customerItem;
  }

  public void setCustomerItem(String customerItem) {
    this.customerItem = customerItem;
  }

  public String getCarrierBo() {
    return this.carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

}
