package ame.htks.db;

import java.util.Date;

public class OfficeAutomationApproval {

  private String requestId;

  private String formName;

  private String formStatus;

  private String customer;

  private String customerDevice;

  private String device;

  private String customerLot;

  private String waferList;

  private Date scheduledStartDate;

  private Date scheduledCompDate;

  private String remark;

  private Date createdDateTime;

  private String createUser;

  private Date updatedTime;


  public OfficeAutomationApproval() {
  }

  public OfficeAutomationApproval(OfficeAutomationApproval data) {
    this.requestId = data.requestId;
    this.formName = data.formName;
    this.formStatus = data.formStatus;
    this.customer = data.customer;
    this.customerDevice = data.customerDevice;
    this.device = data.device;
    this.customerLot = data.customerLot;
    this.waferList = data.waferList;
    this.scheduledStartDate = data.scheduledStartDate;
    this.scheduledCompDate = data.scheduledCompDate;
    this.remark = data.remark;
    this.createdDateTime = data.createdDateTime;
    this.createUser = data.createUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public OfficeAutomationApproval clone() {
    return new OfficeAutomationApproval(this);
  }

  @Override
  public String toString() {
    return this.requestId;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getFormName() {
    return formName;
  }

  public void setFormName(String formName) {
    this.formName = formName;
  }

  public String getFormStatus() {
    return formStatus;
  }

  public void setFormStatus(String formStatus) {
    this.formStatus = formStatus;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getCustomerDevice() {
    return customerDevice;
  }

  public void setCustomerDevice(String customerDevice) {
    this.customerDevice = customerDevice;
  }

  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public String getCustomerLot() {
    return customerLot;
  }

  public void setCustomerLot(String customerLot) {
    this.customerLot = customerLot;
  }

  public String getWaferList() {
    return waferList;
  }

  public void setWaferList(String waferList) {
    this.waferList = waferList;
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

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

}
