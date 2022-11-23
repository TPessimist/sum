package ame.psb.db;

import java.util.Date;

public class ZdResourceSwitch {

  private String resourceBo;

  private String resourceName;

  private String reserveId;

  private String stageName;

  private String stageDesc;

  private String switchDeviceBo;

  private String switchDeviceName;

  private String switchOperationBo;

  private String switchOperationName;

  private String switchSfcBo;

  private String switchSfcName;

  private String reserveSfcBo;

  private String reserveSfcName;

  private String reserveDeviceBo;

  private String reserveDeviceName;

  private String reserveOperationBo;

  private String reserveOperationName;

  private String buyoffSfcBo;

  private String buyoffSfcName;

  private String buyoffResourceBo;

  private String buyoffResourceName;

  private String buyoffOperationBo;

  private String buyoffOperationName;

  private String buyoffResult;

  private String beforeSfcBo;

  private String beforeSfcName;

  private String beforeDeviceBo;

  private String beforeDeviceName;

  private String beforeOperationBo;

  private String beforeOperationName;

  private String updateUser;

  private Date updateTime;


  public ZdResourceSwitch() {
  }

  public ZdResourceSwitch(ZdResourceSwitch data) {
    this.resourceBo = data.resourceBo;
    this.resourceName = data.resourceName;
    this.reserveId = data.reserveId;
    this.stageName = data.stageName;
    this.stageDesc = data.stageDesc;
    this.switchDeviceBo = data.switchDeviceBo;
    this.switchDeviceName = data.switchDeviceName;
    this.switchOperationBo = data.switchOperationBo;
    this.switchOperationName = data.switchOperationName;
    this.switchSfcBo = data.switchSfcBo;
    this.switchSfcName = data.switchSfcName;
    this.reserveSfcBo = data.reserveSfcBo;
    this.reserveSfcName = data.reserveSfcName;
    this.reserveDeviceBo = data.reserveDeviceBo;
    this.reserveDeviceName = data.reserveDeviceName;
    this.reserveOperationBo = data.reserveOperationBo;
    this.reserveOperationName = data.reserveOperationName;
    this.buyoffSfcBo = data.buyoffSfcBo;
    this.buyoffSfcName = data.buyoffSfcName;
    this.buyoffResourceBo = data.buyoffResourceBo;
    this.buyoffResourceName = data.buyoffResourceName;
    this.buyoffOperationBo = data.buyoffOperationBo;
    this.buyoffOperationName = data.buyoffOperationName;
    this.buyoffResult = data.buyoffResult;
    this.beforeSfcBo = data.beforeSfcBo;
    this.beforeSfcName = data.beforeSfcName;
    this.beforeDeviceBo = data.beforeDeviceBo;
    this.beforeDeviceName = data.beforeDeviceName;
    this.beforeOperationBo = data.beforeOperationBo;
    this.beforeOperationName = data.beforeOperationName;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getReserveId() {
    return reserveId;
  }

  public void setReserveId(String reserveId) {
    this.reserveId = reserveId;
  }

  public String getStageName() {
    return stageName;
  }

  public void setStageName(String stageName) {
    this.stageName = stageName;
  }

  public String getStageDesc() {
    return stageDesc;
  }

  public void setStageDesc(String stageDesc) {
    this.stageDesc = stageDesc;
  }

  public String getSwitchDeviceBo() {
    return switchDeviceBo;
  }

  public void setSwitchDeviceBo(String switchDeviceBo) {
    this.switchDeviceBo = switchDeviceBo;
  }

  public String getSwitchDeviceName() {
    return switchDeviceName;
  }

  public void setSwitchDeviceName(String switchDeviceName) {
    this.switchDeviceName = switchDeviceName;
  }

  public String getSwitchOperationBo() {
    return switchOperationBo;
  }

  public void setSwitchOperationBo(String switchOperationBo) {
    this.switchOperationBo = switchOperationBo;
  }

  public String getSwitchOperationName() {
    return switchOperationName;
  }

  public void setSwitchOperationName(String switchOperationName) {
    this.switchOperationName = switchOperationName;
  }

  public String getSwitchSfcBo() {
    return switchSfcBo;
  }

  public void setSwitchSfcBo(String switchSfcBo) {
    this.switchSfcBo = switchSfcBo;
  }

  public String getSwitchSfcName() {
    return switchSfcName;
  }

  public void setSwitchSfcName(String switchSfcName) {
    this.switchSfcName = switchSfcName;
  }

  public String getReserveSfcBo() {
    return reserveSfcBo;
  }

  public void setReserveSfcBo(String reserveSfcBo) {
    this.reserveSfcBo = reserveSfcBo;
  }

  public String getReserveSfcName() {
    return reserveSfcName;
  }

  public void setReserveSfcName(String reserveSfcName) {
    this.reserveSfcName = reserveSfcName;
  }

  public String getReserveDeviceBo() {
    return reserveDeviceBo;
  }

  public void setReserveDeviceBo(String reserveDeviceBo) {
    this.reserveDeviceBo = reserveDeviceBo;
  }

  public String getReserveDeviceName() {
    return reserveDeviceName;
  }

  public void setReserveDeviceName(String reserveDeviceName) {
    this.reserveDeviceName = reserveDeviceName;
  }

  public String getReserveOperationBo() {
    return reserveOperationBo;
  }

  public void setReserveOperationBo(String reserveOperationBo) {
    this.reserveOperationBo = reserveOperationBo;
  }

  public String getReserveOperationName() {
    return reserveOperationName;
  }

  public void setReserveOperationName(String reserveOperationName) {
    this.reserveOperationName = reserveOperationName;
  }

  public String getBuyoffSfcBo() {
    return buyoffSfcBo;
  }

  public void setBuyoffSfcBo(String buyoffSfcBo) {
    this.buyoffSfcBo = buyoffSfcBo;
  }

  public String getBuyoffSfcName() {
    return buyoffSfcName;
  }

  public void setBuyoffSfcName(String buyoffSfcName) {
    this.buyoffSfcName = buyoffSfcName;
  }

  public String getBuyoffResourceBo() {
    return buyoffResourceBo;
  }

  public void setBuyoffResourceBo(String buyoffResourceBo) {
    this.buyoffResourceBo = buyoffResourceBo;
  }

  public String getBuyoffResourceName() {
    return buyoffResourceName;
  }

  public void setBuyoffResourceName(String buyoffResourceName) {
    this.buyoffResourceName = buyoffResourceName;
  }

  public String getBuyoffOperationBo() {
    return buyoffOperationBo;
  }

  public void setBuyoffOperationBo(String buyoffOperationBo) {
    this.buyoffOperationBo = buyoffOperationBo;
  }

  public String getBuyoffOperationName() {
    return buyoffOperationName;
  }

  public void setBuyoffOperationName(String buyoffOperationName) {
    this.buyoffOperationName = buyoffOperationName;
  }

  public String getBuyoffResult() {
    return buyoffResult;
  }

  public void setBuyoffResult(String buyoffResult) {
    this.buyoffResult = buyoffResult;
  }

  public String getBeforeSfcBo() {
    return beforeSfcBo;
  }

  public void setBeforeSfcBo(String beforeSfcBo) {
    this.beforeSfcBo = beforeSfcBo;
  }

  public String getBeforeSfcName() {
    return beforeSfcName;
  }

  public void setBeforeSfcName(String beforeSfcName) {
    this.beforeSfcName = beforeSfcName;
  }

  public String getBeforeDeviceBo() {
    return beforeDeviceBo;
  }

  public void setBeforeDeviceBo(String beforeDeviceBo) {
    this.beforeDeviceBo = beforeDeviceBo;
  }

  public String getBeforeDeviceName() {
    return beforeDeviceName;
  }

  public void setBeforeDeviceName(String beforeDeviceName) {
    this.beforeDeviceName = beforeDeviceName;
  }

  public String getBeforeOperationBo() {
    return beforeOperationBo;
  }

  public void setBeforeOperationBo(String beforeOperationBo) {
    this.beforeOperationBo = beforeOperationBo;
  }

  public String getBeforeOperationName() {
    return beforeOperationName;
  }

  public void setBeforeOperationName(String beforeOperationName) {
    this.beforeOperationName = beforeOperationName;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public ZdResourceSwitch clone() {
    return new ZdResourceSwitch(this);
  }

  @Override
  public String toString() {
    return this.resourceBo;
  }
}
