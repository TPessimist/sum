package ame.psb.db;

import java.util.Date;

public class SpcAlarm {

  private String id;

  private String sfcBo;

  private Date createdDateTime;


  public SpcAlarm() {
  }

  public SpcAlarm(SpcAlarm data) {
    this.id = data.id;
    this.sfcBo = data.sfcBo;
    this.createdDateTime = data.createdDateTime;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  @Override
  public SpcAlarm clone() {
    return new SpcAlarm(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
