package ame.me.db;

import java.util.Date;

public class ShopOrderView {

  private String handle;

  private String site;

  private String shopOrder;

  private String statusBo;

  private int priority;

  private String plannedItemBo;

  private Date plannedStartDate;

  private Date plannedCompDate;

  private Date scheduledStartDate;

  private Date scheduledCompDate;

  private Date actualStartDate;

  private Date actualCompDate;

  private String lotName;

  private String dptNo;

  private String lotType;

  private String customer;

  private String itemGroupBo;

  private String device;

  private String advanceField;

  private String pkg;

  private String ct;

  private Date inTime;

  //非表中数据

  private String currentOperations;

  public String getHandle() {
    return handle;
  }


  public void setHandle(String handle) {
    this.handle = handle;
  }


  public String getCt() {
    return ct;
  }


  public void setCt(String ct) {
    this.ct = ct;
  }


  public String getDevice() {
    return device;
  }


  public void setDevice(String device) {
    this.device = device;
  }


  public String getSite() {
    return site;
  }


  public void setSite(String site) {
    this.site = site;
  }


  public String getShopOrder() {
    return shopOrder;
  }


  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }


  public String getStatusBo() {
    return statusBo;
  }


  public void setStatusBo(String statusBo) {
    this.statusBo = statusBo;
  }


  public int getPriority() {
    return priority;
  }


  public void setPriority(int priority) {
    this.priority = priority;
  }


  public String getPlannedItemBo() {
    return plannedItemBo;
  }


  public void setPlannedItemBo(String plannedItemBo) {
    this.plannedItemBo = plannedItemBo;
  }


  public Date getPlannedStartDate() {
    return plannedStartDate;
  }


  public void setPlannedStartDate(Date plannedStartDate) {
    this.plannedStartDate = plannedStartDate;
  }


  public Date getPlannedCompDate() {
    return plannedCompDate;
  }


  public void setPlannedCompDate(Date plannedCompDate) {
    this.plannedCompDate = plannedCompDate;
  }


  public Date getScheduledStartDate() {
    return scheduledStartDate;
  }


  public void setScheduledStartDate(Date scheduledStartDate) {
    this.scheduledStartDate = scheduledStartDate;
  }


  public Date getScheduledCompDate() {
    return scheduledCompDate;
  }


  public void setScheduledCompDate(Date scheduledCompDate) {
    this.scheduledCompDate = scheduledCompDate;
  }


  public Date getActualStartDate() {
    return actualStartDate;
  }


  public void setActualStartDate(Date actualStartDate) {
    this.actualStartDate = actualStartDate;
  }


  public Date getActualCompDate() {
    return actualCompDate;
  }


  public void setActualCompDate(Date actualCompDate) {
    this.actualCompDate = actualCompDate;
  }


  public String getLotName() {
    return lotName;
  }


  public void setLotName(String lotName) {
    this.lotName = lotName;
  }


  public String getDptNo() {
    return dptNo;
  }


  public void setDptNo(String dptNo) {
    this.dptNo = dptNo;
  }


  public String getLotType() {
    return lotType;
  }


  public void setLotType(String lotType) {
    this.lotType = lotType;
  }


  public String getCustomer() {
    return customer;
  }


  public void setCustomer(String customer) {
    this.customer = customer;
  }


  public String getAdvanceField() {
    return advanceField;
  }


  public void setAdvanceField(String advanceField) {
    this.advanceField = advanceField;
  }


  public String getItemGroupBo() {
    return itemGroupBo;
  }


  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }


  public String getPkg() {
    return pkg;
  }


  public void setPkg(String pkg) {
    this.pkg = pkg;
  }


  public Date getInTime() {
    return inTime;
  }


  public void setInTime(Date inTime) {
    this.inTime = inTime;
  }


  public String getCurrentOperations() {
    return currentOperations;
  }


  public void setCurrentOperations(String currentOperations) {
    this.currentOperations = currentOperations;
  }


  @Override
  public String toString() {
    return this.handle;
  }

}
