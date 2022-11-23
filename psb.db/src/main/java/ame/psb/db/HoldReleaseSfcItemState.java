package ame.psb.db;

import java.util.Date;

public class HoldReleaseSfcItemState {

  private String sfcBo;

  private String customerItemBo;

  private String itemStateName;

  private String memo;

  private Date updatedTime;

  private String updatedUser;

  private String holdReleaseBo;

  private String status;

  public HoldReleaseSfcItemState() {
    this.status = "EDIT";
  }

  public HoldReleaseSfcItemState(HoldReleaseSfcItemState data) {
    this.sfcBo = data.sfcBo;
    this.customerItemBo = data.customerItemBo;
    this.itemStateName = data.itemStateName;
    this.memo = data.memo;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getItemStateName() {
    return this.itemStateName;
  }

  public void setItemStateName(String itemStateName) {
    this.itemStateName = itemStateName;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public String getHoldReleaseBo() {
    return this.holdReleaseBo;
  }

  public void setHoldReleaseBo(String holdReleaseBo) {
    this.holdReleaseBo = holdReleaseBo;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public HoldReleaseSfcItemState clone() {
    return new HoldReleaseSfcItemState(this);
  }

  @Override
  public String toString() {
    return this.sfcBo;
  }
}
