package ame.psb.db;

import java.util.Date;

public class InstrumentMaintain { //ZD_INSTRUMENT_MAINTAIN表的实体类

  private String uuid; //主键

  private String instrumentid; //计量器具编号

  private String code; //类别代码

  private String name; //计量器具名称

  private String alias; //仪器别名

  private String resourcceid; //设备编号

  private String onlinemonitor; //在线计量监控判定

  private String calibrationcycle; //校准周期

  private String state; //状态

  private Date calibrationdate; //校准日期

  private Date effectivedate; //截止有效日期

  private String value; //备用列1

  private String comment; //备用列2

  private String description; //备用列3

  private String remarks; //备用列4

  private String note; //备用列5


  public InstrumentMaintain() {
  }

  public InstrumentMaintain(InstrumentMaintain data) {
    this.uuid = data.uuid;
    this.instrumentid = data.instrumentid;
    this.code = data.code;
    this.name = data.name;
    this.alias = data.alias;
    this.resourcceid = data.resourcceid;
    this.onlinemonitor = data.onlinemonitor;
    this.calibrationcycle = data.calibrationcycle;
    this.state = data.state;
    this.calibrationdate = data.calibrationdate;
    this.effectivedate = data.effectivedate;
    this.value = data.value;
    this.comment = data.comment;
    this.description = data.description;
    this.remarks = data.remarks;
    this.note = data.note;
  }

  @Override
  public InstrumentMaintain clone() {
    return new InstrumentMaintain(this);
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

  public String getInstrumentid() {
    return instrumentid;
  }

  public void setInstrumentid(String instrumentid) {
    this.instrumentid = instrumentid;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public String getResourcceid() {
    return resourcceid;
  }

  public void setResourcceid(String resourcceid) {
    this.resourcceid = resourcceid;
  }

  public String getOnlinemonitor() {
    return onlinemonitor;
  }

  public void setOnlinemonitor(String onlinemonitor) {
    this.onlinemonitor = onlinemonitor;
  }

  public String getCalibrationcycle() {
    return calibrationcycle;
  }

  public void setCalibrationcycle(String calibrationcycle) {
    this.calibrationcycle = calibrationcycle;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Date getCalibrationdate() {
    return calibrationdate;
  }

  public void setCalibrationdate(Date calibrationdate) {
    this.calibrationdate = calibrationdate;
  }

  public Date getEffectivedate() {
    return effectivedate;
  }

  public void setEffectivedate(Date effectivedate) {
    this.effectivedate = effectivedate;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
