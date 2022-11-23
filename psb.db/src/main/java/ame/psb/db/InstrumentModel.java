package ame.psb.db;

import java.util.Date;

public class InstrumentModel {

  private String uuid; //主键

  private String instrumentCode; //类别代码

  private String instrumentName; //仪器名称

  private String instrumentMaker; //制造商

  private String instrumentModel; //

  private String description; //备用列1

  private String value; //备用列2

  private Date updateTime; //

  private String updateUser; //


  public InstrumentModel() {
  }

  public InstrumentModel(InstrumentModel data) {
    this.uuid = data.uuid;
    this.instrumentCode = data.instrumentCode;
    this.instrumentName = data.instrumentName;
    this.instrumentMaker = data.instrumentMaker;
    this.instrumentModel = data.instrumentModel;
    this.description = data.description;
    this.value = data.value;
    this.updateTime = data.updateTime;
    this.updateUser = data.updateUser;
  }

  @Override
  public InstrumentModel clone() {
    return new InstrumentModel(this);
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

  public String getInstrumentCode() {
    return instrumentCode;
  }

  public void setInstrumentCode(String instrumentCode) {
    this.instrumentCode = instrumentCode;
  }

  public String getInstrumentName() {
    return instrumentName;
  }

  public void setInstrumentName(String instrumentName) {
    this.instrumentName = instrumentName;
  }

  public String getInstrumentMaker() {
    return instrumentMaker;
  }

  public void setInstrumentMaker(String instrumentMaker) {
    this.instrumentMaker = instrumentMaker;
  }

  public String getInstrumentModel() {
    return instrumentModel;
  }

  public void setInstrumentModel(String instrumentModel) {
    this.instrumentModel = instrumentModel;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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
