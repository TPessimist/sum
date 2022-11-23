package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class InstrumentManufacturerLog extends InstrumentManufacturer {

  private String uuid;

  private Date updateTime;

  private String updateUser;


  public InstrumentManufacturerLog() {
  }

  public InstrumentManufacturerLog(InstrumentManufacturer data, String user) {
    super(data);
    this.uuid = System.currentTimeMillis() + "::" + UUID.randomUUID().toString();
    this.updateTime = new Date();
    this.updateUser = user;
  }

  public InstrumentManufacturerLog(InstrumentManufacturerLog data) {
    this.uuid = data.uuid;
    this.updateTime = data.updateTime;
    this.updateUser = data.updateUser;
  }

  @Override
  public InstrumentManufacturerLog clone() {
    return new InstrumentManufacturerLog(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }
}
