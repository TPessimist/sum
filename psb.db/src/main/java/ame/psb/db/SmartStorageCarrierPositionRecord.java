package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class SmartStorageCarrierPositionRecord {

  private String carrierBo;

  private String positionBo;

  private BigDecimal slotMaxNo;

  private String updatedUser;

  private Date updatedTime;


  public SmartStorageCarrierPositionRecord() {
  }

  public SmartStorageCarrierPositionRecord(SmartStorageCarrierPositionRecord data) {
    this.carrierBo = data.carrierBo;
    this.positionBo = data.positionBo;
    this.slotMaxNo = data.slotMaxNo;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public SmartStorageCarrierPositionRecord clone() {
    return new SmartStorageCarrierPositionRecord(this);
  }

  @Override
  public String toString() {
    return this.carrierBo;
  }

  public String getCarrierBo() {
    return carrierBo;
  }

  public void setCarrierBo(String carrierBo) {
    this.carrierBo = carrierBo;
  }

  public String getPositionBo() {
    return positionBo;
  }

  public void setPositionBo(String positionBo) {
    this.positionBo = positionBo;
  }

  public BigDecimal getSlotMaxNo() {
    return slotMaxNo;
  }

  public void setSlotMaxNo(BigDecimal slotMaxNo) {
    this.slotMaxNo = slotMaxNo;
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
}
