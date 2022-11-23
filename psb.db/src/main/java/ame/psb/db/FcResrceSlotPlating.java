package ame.psb.db;

import java.util.Date;

public class FcResrceSlotPlating {

  private String resourceNo;

  private String slotNo;

  private String slotName;

  private String platingName;

  private String updatedUser;

  private Date updatedTime;

  private boolean bathAcidFlag = false;

  private boolean bathTinFlag = false;

  public FcResrceSlotPlating() {
  }

  public FcResrceSlotPlating(FcResrceSlotPlating data) {
    this.resourceNo = data.resourceNo;
    this.slotNo = data.slotNo;
    this.slotName = data.slotName;
    this.platingName = data.platingName;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.bathAcidFlag = data.bathAcidFlag;
    this.bathTinFlag = data.bathTinFlag;
  }

  public String getResourceNo() {
    return resourceNo;
  }

  public void setResourceNo(String resourceNo) {
    this.resourceNo = resourceNo;
  }

  public String getSlotNo() {
    return slotNo;
  }

  public void setSlotNo(String slotNo) {
    this.slotNo = slotNo;
  }

  public String getSlotName() {
    return slotName;
  }

  public void setSlotName(String slotName) {
    this.slotName = slotName;
  }

  public String getPlatingName() {
    return platingName;
  }

  public void setPlatingName(String platingName) {
    this.platingName = platingName;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public boolean isBathAcidFlag() {
    return bathAcidFlag;
  }

  public void setBathAcidFlag(boolean bathAcidFlag) {
    this.bathAcidFlag = bathAcidFlag;
  }

  public boolean isBathTinFlag() {
    return bathTinFlag;
  }

  public void setBathTinFlag(boolean bathTinFlag) {
    this.bathTinFlag = bathTinFlag;
  }

  @Override
  public FcResrceSlotPlating clone() {
    return new FcResrceSlotPlating(this);
  }

  @Override
  public String toString() {
    return this.resourceNo + ", " + this.slotNo + ", " + this.platingName;
  }
}
