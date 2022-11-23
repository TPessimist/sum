package ame.psb.db;

import java.util.Date;

public class ZrIssueRecipe {

  private String id;

  private String customerDevice;

  private String customerLot;

  private String operationBo;

  private String deviceName;

  private String sfcBo;

  private String itemName;

  private String toolNumberBo;

  private String recipeName;

  private String updatedUser;

  private Date updatedTime;

  private String requestId;


  public ZrIssueRecipe() {
  }

  public ZrIssueRecipe(ZrIssueRecipe data) {
    this.id = data.id;
    this.customerDevice = data.customerDevice;
    this.customerLot = data.customerLot;
    this.operationBo = data.operationBo;
    this.deviceName = data.deviceName;
    this.sfcBo = data.sfcBo;
    this.itemName = data.itemName;
    this.toolNumberBo = data.toolNumberBo;
    this.recipeName = data.recipeName;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.requestId = data.requestId;
  }

  @Override
  public ZrIssueRecipe clone() {
    return new ZrIssueRecipe(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCustomerDevice() {
    return this.customerDevice;
  }

  public void setCustomerDevice(String customerDevice) {
    this.customerDevice = customerDevice;
  }

  public String getCustomerLot() {
    return this.customerLot;
  }

  public void setCustomerLot(String customerLot) {
    this.customerLot = customerLot;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getDeviceName() {
    return this.deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getToolNumberBo() {
    return this.toolNumberBo;
  }

  public void setToolNumberBo(String toolNumberBo) {
    this.toolNumberBo = toolNumberBo;
  }

  public String getRecipeName() {
    return this.recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getRequestId() {
    return this.requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }
}