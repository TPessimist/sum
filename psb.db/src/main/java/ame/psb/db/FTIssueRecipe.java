package ame.psb.db;

import java.util.Date;

public class FTIssueRecipe {

  private String id;

  private String customerDevice;

  private String customerLot;

  private String operationBo;

  private String deviceName;

  private String equipment;

  private String process;

  private String sfcBo;

  private String recipeName;

  private String testProgram;

  private String updatedUser;

  private Date updatedTime;

  private String requestId;

  private String active;


  public FTIssueRecipe() {
  }

  public FTIssueRecipe(FTIssueRecipe data) {
    this.id = data.id;
    this.customerDevice = data.customerDevice;
    this.customerLot = data.customerLot;
    this.operationBo = data.operationBo;
    this.deviceName = data.deviceName;
    this.equipment = data.equipment;
    this.process = data.process;
    this.sfcBo = data.sfcBo;
    this.recipeName = data.recipeName;
    this.testProgram = data.testProgram;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.requestId = data.requestId;
    this.active = data.active;
  }

  @Override
  public FTIssueRecipe clone() {
    return new FTIssueRecipe(this);
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

  public String getEquipment() {
    return this.equipment;
  }

  public void setEquipment(String equipment) {
    this.equipment = equipment;
  }

  public String getProcess() {
    return this.process;
  }

  public void setProcess(String process) {
    this.process = process;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getRecipeName() {
    return this.recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public String getTestProgram() {
    return this.testProgram;
  }

  public void setTestProgram(String testProgram) {
    this.testProgram = testProgram;
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

  public String getActive() {
    return this.active;
  }

  public void setActive(String active) {
    this.active = active;
  }
}
