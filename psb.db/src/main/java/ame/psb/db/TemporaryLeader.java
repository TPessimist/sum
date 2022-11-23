package ame.psb.db;

import java.util.Date;

public class TemporaryLeader {

  private String uuid;

  private String leaderId;

  private String temporaryLeaderId;

  private String stateName;

  private String flag;

  private String content;

  private String value;

  private Date startTime;

  private Date endTime;


  public TemporaryLeader() {
  }

  public TemporaryLeader(TemporaryLeader data) {
    this.uuid = data.uuid;
    this.leaderId = data.leaderId;
    this.temporaryLeaderId = data.temporaryLeaderId;
    this.stateName = data.stateName;
    this.flag = data.flag;
    this.content = data.content;
    this.value = data.value;
    this.startTime = data.startTime;
    this.endTime = data.endTime;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getLeaderId() {
    return leaderId;
  }

  public void setLeaderId(String leaderId) {
    this.leaderId = leaderId;
  }

  public String getTemporaryLeaderId() {
    return temporaryLeaderId;
  }

  public void setTemporaryLeaderId(String temporaryLeaderId) {
    this.temporaryLeaderId = temporaryLeaderId;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  @Override
  public TemporaryLeader clone() {
    return new TemporaryLeader(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }
}
