package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class HoldHandlerManualInkLog {

  private String id;

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


  public HoldHandlerManualInkLog() {
    this.id = UUID.randomUUID().toString();
  }

  public HoldHandlerManualInkLog(HoldHandlerManualInk data) {
    this.id = data.getId();
    this.inkType = data.getInkType();
    this.customerAgreeFlag = data.getCustomerAgreeFlag();
    this.customerCode = data.getCustomerCode();
    this.deviceName = data.getDeviceName();
    this.sfcName = data.getSfcName();
    this.operationName = data.getOperationName();
    this.lotName = data.getLotName();
    this.customerMailAddress = data.getCustomerMailAddress();
    this.stateName = data.getStateName();
    this.loadMapExcel = data.getLoadMapExcel();
    this.uploadInkExcel = data.getUploadInkExcel();
    this.reportExcel = data.getReportExcel();
    this.updatedTime = data.getUpdatedTime();
    this.updatedUser = data.getUpdatedUser();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  @Override
  public String toString() {
    return this.id;
  }
}
