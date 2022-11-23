package ame.psb.db;

import java.util.Date;
import java.util.Objects;

public class WaferIdCharacterLocation {

  private String deviceName;

  private int seq;

  private String customerLotCharacterLocation;

  private String fabLotCharacterLocation;

  private String physicalWaferidCharacterLocation;

  private String customerSlotnoLocation;

  private String physicalSlotnoLocation;

  private String customerSlotnoLocationRight;

  private String updatedUser;

  private Date updatedTime;

  private boolean checkSumValidate = true;


  public WaferIdCharacterLocation() {
  }

  public WaferIdCharacterLocation(WaferIdCharacterLocation data) {
    this.deviceName = data.deviceName;
    this.customerLotCharacterLocation = data.customerLotCharacterLocation;
    this.physicalWaferidCharacterLocation = data.physicalWaferidCharacterLocation;
    this.customerSlotnoLocation = data.customerSlotnoLocation;
    this.physicalSlotnoLocation = data.physicalSlotnoLocation;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.checkSumValidate = data.checkSumValidate;
  }

  @Override
  public WaferIdCharacterLocation clone() {
    return new WaferIdCharacterLocation(this);
  }

  @Override
  public String toString() {
    return this.deviceName;
  }

  public String getDeviceName() {
    return this.deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getCustomerLotCharacterLocation() {
    return this.customerLotCharacterLocation;
  }

  public void setCustomerLotCharacterLocation(String customerLotCharacterLocation) {
    this.customerLotCharacterLocation = customerLotCharacterLocation;
  }

  public String getFabLotCharacterLocation() {
    return fabLotCharacterLocation;
  }

  public void setFabLotCharacterLocation(String fabLotCharacterLocation) {
    this.fabLotCharacterLocation = fabLotCharacterLocation;
  }

  public String getPhysicalWaferidCharacterLocation() {
    return this.physicalWaferidCharacterLocation;
  }

  public void setPhysicalWaferidCharacterLocation(String physicalWaferidCharacterLocation) {
    this.physicalWaferidCharacterLocation = physicalWaferidCharacterLocation;
  }

  public String getCustomerSlotnoLocation() {
    return this.customerSlotnoLocation;
  }

  public void setCustomerSlotnoLocation(String customerSlotnoLocation) {
    this.customerSlotnoLocation = customerSlotnoLocation;
  }

  public String getPhysicalSlotnoLocation() {
    return this.physicalSlotnoLocation;
  }

  public void setPhysicalSlotnoLocation(String physicalSlotnoLocation) {
    this.physicalSlotnoLocation = physicalSlotnoLocation;
  }

  public String getCustomerSlotnoLocationRight() {
    return this.customerSlotnoLocationRight;
  }

  public void setCustomerSlotnoLocationRight(String customerSlotnoLocationRight) {
    this.customerSlotnoLocationRight = customerSlotnoLocationRight;
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

  public boolean isCheckSumValidate() {
    return this.checkSumValidate;
  }

  public void setCheckSumValidate(boolean checkSumValidate) {
    this.checkSumValidate = checkSumValidate;
  }

  public int getSeq() {
    return seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WaferIdCharacterLocation that = (WaferIdCharacterLocation) o;
    return seq == that.seq && deviceName.equals(that.deviceName) && Objects
        .equals(updatedTime, that.updatedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceName, seq, updatedTime);
  }
}
