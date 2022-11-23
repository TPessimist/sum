package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class RunResourceHold {

  private String id;

  private String resourceBo;

  private String stateName;

  private Date beginTime;

  private Date endTime;

  private String currentSfclist;

  private String memo;


  public RunResourceHold() {
    this.id = UUID.randomUUID().toString();
  }

  public RunResourceHold(String resourceBo) {
    this();
    this.beginTime = new Date();
    this.resourceBo = resourceBo;
    this.stateName = "Y";
  }

  public RunResourceHold(RunResourceHold data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.stateName = data.stateName;
    this.beginTime = data.beginTime;
    this.endTime = data.endTime;
    this.currentSfclist = data.currentSfclist;
    this.memo = data.memo;
  }

  @Override
  public RunResourceHold clone() {
    return new RunResourceHold(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public Date getBeginTime() {
    return this.beginTime;
  }

  public void setBeginTime(Date beginTime) {
    this.beginTime = beginTime;
  }

  public Date getEndTime() {
    return this.endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getCurrentSfclist() {
    return this.currentSfclist;
  }

  public void setCurrentSfclist(String currentSfclist) {
    this.currentSfclist = currentSfclist;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }
}
