package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class HoldHandlerManualInk {

  private String id;

  private String holdReleaseBo;

  private String inkType;

  private String customerAgreeFlag;

  private String customerCode;

  private String deviceName;

  private String sfcName;

  private String operationName;

  private String lotName;

  private String customerMailAddress;

  private String stateName;

  private String loadMapExcel;

  private String uploadInkExcel;

  private String reportExcel;

  private Date updatedTime;

  private String updatedUser;

  private Date applyTime;

  private String applyUser;


  public HoldHandlerManualInk() {
    this.id = UUID.randomUUID().toString();
  }

  public HoldHandlerManualInk(HoldHandlerManualInk data) {
    this.id = data.id;
    this.holdReleaseBo = data.holdReleaseBo;
    this.inkType = data.inkType;
    this.customerAgreeFlag = data.customerAgreeFlag;
    this.customerCode = data.customerCode;
    this.deviceName = data.deviceName;
    this.sfcName = data.sfcName;
    this.operationName = data.operationName;
    this.lotName = data.lotName;
    this.customerMailAddress = data.customerMailAddress;
    this.stateName = data.stateName;
    this.loadMapExcel = data.loadMapExcel;
    this.uploadInkExcel = data.uploadInkExcel;
    this.reportExcel = data.reportExcel;
    this.updatedTime = data.updatedTime;
    this.updatedUser = data.updatedUser;
    this.applyTime = data.applyTime;
    this.applyUser = data.applyUser;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getHoldReleaseBo() {
    return holdReleaseBo;
  }

  public void setHoldReleaseBo(String holdReleaseBo) {
    this.holdReleaseBo = holdReleaseBo;
  }

  public String getInkType() {
    return inkType;
  }

  public void setInkType(String inkType) {
    this.inkType = inkType;
  }

  public String getCustomerAgreeFlag() {
    return customerAgreeFlag;
  }

  public void setCustomerAgreeFlag(String customerAgreeFlag) {
    this.customerAgreeFlag = customerAgreeFlag;
  }

  public String getCustomerCode() {
    return customerCode;
  }

  public void setCustomerCode(String customerCode) {
    this.customerCode = customerCode;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getOperationName() {
    return operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  public String getLotName() {
    return lotName;
  }

  public void setLotName(String lotName) {
    this.lotName = lotName;
  }

  public String getCustomerMailAddress() {
    return customerMailAddress;
  }

  public void setCustomerMailAddress(String customerMailAddress) {
    this.customerMailAddress = customerMailAddress;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getLoadMapExcel() {
    return loadMapExcel;
  }

  public void setLoadMapExcel(String loadMapExcel) {
    this.loadMapExcel = loadMapExcel;
  }

  public String getUploadInkExcel() {
    return uploadInkExcel;
  }

  public void setUploadInkExcel(String uploadInkExcel) {
    this.uploadInkExcel = uploadInkExcel;
  }

  public String getReportExcel() {
    return reportExcel;
  }

  public void setReportExcel(String reportExcel) {
    this.reportExcel = reportExcel;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getApplyTime() {
    return applyTime;
  }

  public void setApplyTime(Date applyTime) {
    this.applyTime = applyTime;
  }

  public String getApplyUser() {
    return applyUser;
  }

  public void setApplyUser(String applyUser) {
    this.applyUser = applyUser;
  }

  @Override
  public HoldHandlerManualInk clone() {
    return new HoldHandlerManualInk(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
