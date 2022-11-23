package ame.psb.db;

public class ViewDcResultDetail extends DcResultDetail {

  private String sfcBo;

  private String dcPlanBo;

  private String dcopBo;

  private String dptNo;

  private String customerItemName;

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getDcPlanBo() {
    return this.dcPlanBo;
  }

  public void setDcPlanBo(String dcPlanBo) {
    this.dcPlanBo = dcPlanBo;
  }

  public String getDcopBo() {
    return this.dcopBo;
  }

  public void setDcopBo(String dcopBo) {
    this.dcopBo = dcopBo;
  }

  public String getDptNo() {
    return this.dptNo;
  }

  public void setDptNo(String dptNo) {
    this.dptNo = dptNo;
  }

  public String getCustomerItemName() {
    return this.customerItemName;
  }

  public void setCustomerItemName(String customerItemName) {
    this.customerItemName = customerItemName;
  }

}
