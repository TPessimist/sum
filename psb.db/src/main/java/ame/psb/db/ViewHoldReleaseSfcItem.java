package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class ViewHoldReleaseSfcItem extends HoldReleaseSfcItem {

  public String slotNo;
  public String itemStateName;
  public String memo;
  private String id;
  private String planName;
  private Date planTime;
  private String stateName;
  private String oa;
  private String oaFormNo;
  private String releaseType;
  private String updatedUser;
  private Date updatedTime;
  private String carrierBo;
  private String sfcName;
  private String customerItemName;
  private String resultRouterName;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPlanName() {
    return this.planName;
  }

  public void setPlanName(String planName) {
    this.planName = planName;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getOa() {
    return this.oa;
  }

  public void setOa(String oa) {
    this.oa = oa;
  }

  public String getReleaseType() {
    return this.releaseType;
  }

  public void setReleaseType(String releaseType) {
    this.releaseType = releaseType;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public String getCarrierBo() {
    return this.carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getOaFormNo() {
    return this.oaFormNo;
  }

  public void setOaFormNo(String oaFormNo) {
    this.oaFormNo = oaFormNo;
  }

  public Date getPlanTime() {
    return this.planTime;
  }

  public void setPlanTime(Date planTime) {
    this.planTime = planTime;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getSfcName() {
    return this.sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getCustomerItemName() {
    return this.customerItemName;
  }

  public void setCustomerItemName(String customerItemName) {
    this.customerItemName = customerItemName;
  }

  public String getResultRouterName() {
    return this.resultRouterName;
  }

  public void setResultRouterName(String resultRouterName) {
    this.resultRouterName = resultRouterName;
  }

  public String getSlotNo() {
    return this.slotNo;
  }

  public void setSlotNo(String slotNo) {
    this.slotNo = slotNo;
  }

  public String getItemStateName() {
    return itemStateName;
  }

  public void setItemStateName(String itemStateName) {
    this.itemStateName = itemStateName;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }
}