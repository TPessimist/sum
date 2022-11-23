package ame.psb.db;

public class ViewManualHoldOcap {

  private String holdDetailBo;
  private String sfc;
  private String shopOrder;
  private String customer;
  private String itemsetName;
  private String department;
  private String item;
  private String value;
  private String carrierBo;
  private String itemGroup;
  private String stateName;
  private String operation;
  private String runUser;
  private String comments;
  private String flag;
  private String requestid;

  public ViewManualHoldOcap() {
  }

  public ViewManualHoldOcap(ViewManualHoldOcap data) {
    this.holdDetailBo = data.holdDetailBo;
    this.sfc = data.sfc;
    this.shopOrder = data.shopOrder;
    this.customer = data.customer;
    this.itemsetName = data.itemsetName;
    this.department = data.department;
    this.item = data.item;
    this.value = data.value;
    this.carrierBo = data.carrierBo;
    this.itemGroup = data.itemGroup;
    this.stateName = data.stateName;
    this.operation = data.operation;
    this.runUser = data.runUser;
    this.comments = data.comments;
    this.flag = data.flag;
    this.requestid = data.requestid;
  }

  public String getHoldDetailBo() {
    return holdDetailBo;
  }

  public void setHoldDetailBo(String holdDetailBo) {
    this.holdDetailBo = holdDetailBo;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getItemsetName() {
    return itemsetName;
  }

  public void setItemsetName(String itemsetName) {
    this.itemsetName = itemsetName;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getCarrierBo() {
    return carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getItemGroup() {
    return itemGroup;
  }

  public void setItemGroup(String itemGroup) {
    this.itemGroup = itemGroup;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getRunUser() {
    return runUser;
  }

  public void setRunUser(String runUser) {
    this.runUser = runUser;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getRequestid() {
    return requestid;
  }

  public void setRequestid(String requestid) {
    this.requestid = requestid;
  }

  @Override
  public ViewManualHoldOcap clone() {
    return new ViewManualHoldOcap(this);
  }

  @Override
  public String toString() {
    return this.holdDetailBo;
  }
}
