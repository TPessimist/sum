package ame.psb.db;

import java.util.Date;
import lombok.Data;

@Data
public class FtInspectionResult {

  private String sfc;

  private String reelId;

  private String uniqueId;

  private String shopOrder;

  private Integer totalQty;

  private Integer successQty;

  private Integer failQty;

  private String device;

  private Integer deviceQty;

  private String resourceRelease;

  private String manualRelease;

  private String content;

  private String updateUser;

  private Date updateTime;

  private String reserve1;

  private String reserve2;


  public FtInspectionResult() {
  }

  public FtInspectionResult(FtInspectionResult data) {
    this.sfc = data.sfc;
    this.reelId = data.reelId;
    this.uniqueId = data.uniqueId;
    this.shopOrder = data.shopOrder;
    this.totalQty = data.totalQty;
    this.successQty = data.successQty;
    this.failQty = data.failQty;
    this.device = data.device;
    this.deviceQty = data.deviceQty;
    this.resourceRelease = data.resourceRelease;
    this.manualRelease = data.manualRelease;
    this.content = data.content;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.reserve1 = data.reserve1;
    this.reserve2 = data.reserve2;
  }

  @Override
  public FtInspectionResult clone() {
    return new FtInspectionResult(this);
  }

  @Override
  public String toString() {
    return this.sfc + ", " + this.reelId;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getReelId() {
    return reelId;
  }

  public void setReelId(String reelId) {
    this.reelId = reelId;
  }

  public String getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(String uniqueId) {
    this.uniqueId = uniqueId;
  }

  public String getShopOrder() {
    return shopOrder;
  }

  public void setShopOrder(String shopOrder) {
    this.shopOrder = shopOrder;
  }

  public Integer getTotalQty() {
    return totalQty;
  }

  public void setTotalQty(Integer totalQty) {
    this.totalQty = totalQty;
  }

  public Integer getSuccessQty() {
    return successQty;
  }

  public void setSuccessQty(Integer successQty) {
    this.successQty = successQty;
  }

  public Integer getFailQty() {
    return failQty;
  }

  public void setFailQty(Integer failQty) {
    this.failQty = failQty;
  }

  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public Integer getDeviceQty() {
    return deviceQty;
  }

  public void setDeviceQty(Integer deviceQty) {
    this.deviceQty = deviceQty;
  }

  public String getResourceRelease() {
    return resourceRelease;
  }

  public void setResourceRelease(String resourceRelease) {
    this.resourceRelease = resourceRelease;
  }

  public String getManualRelease() {
    return manualRelease;
  }

  public void setManualRelease(String manualRelease) {
    this.manualRelease = manualRelease;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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

  public String getReserve1() {
    return reserve1;
  }

  public void setReserve1(String reserve1) {
    this.reserve1 = reserve1;
  }

  public String getReserve2() {
    return reserve2;
  }

  public void setReserve2(String reserve2) {
    this.reserve2 = reserve2;
  }
}
