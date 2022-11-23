package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class RunResource {

  private String id;

  private String resourceBo;

  private String eventName;

  private String eventUser;

  private Date eventBeginTime;

  private Date eventEndTime;

  private String prevStateName;

  private String nextStateName;

  private String faultMatter;

  private String faultCause;

  private String faultResolve;

  private String holdReason; //配套机台报警使用

  public RunResource() {
    this.id = UUID.randomUUID().toString();
    this.eventBeginTime = new Date();
  }

  public RunResource(RunResource data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.eventName = data.eventName;
    this.eventUser = data.eventUser;
    this.eventBeginTime = data.eventBeginTime;
    this.eventEndTime = data.eventEndTime;
    this.prevStateName = data.prevStateName;
    this.nextStateName = data.nextStateName;
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

  public String getEventName() {
    return this.eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public String getEventUser() {
    return this.eventUser;
  }

  public void setEventUser(String eventUser) {
    this.eventUser = eventUser;
  }

  public Date getEventBeginTime() {
    return this.eventBeginTime;
  }

  public void setEventBeginTime(Date eventBeginTime) {
    this.eventBeginTime = eventBeginTime;
  }

  public Date getEventEndTime() {
    return this.eventEndTime;
  }

  public void setEventEndTime(Date eventEndTime) {
    this.eventEndTime = eventEndTime;
  }

  public String getPrevStateName() {
    return this.prevStateName;
  }

  public void setPrevStateName(String prevStateName) {
    this.prevStateName = prevStateName;
  }

  public String getNextStateName() {
    return this.nextStateName;
  }

  public void setNextStateName(String nextStateName) {
    this.nextStateName = nextStateName;
  }

  public String getFaultMatter() {
    return faultMatter;
  }

  public void setFaultMatter(String faultMatter) {
    this.faultMatter = faultMatter;
  }

  public String getFaultCause() {
    return faultCause;
  }

  public void setFaultCause(String faultCause) {
    this.faultCause = faultCause;
  }

  public String getFaultResolve() {
    return faultResolve;
  }

  public void setFaultResolve(String faultResolve) {
    this.faultResolve = faultResolve;
  }

  public String getHoldReason() {
    return holdReason;
  }

  public void setHoldReason(String holdReason) {
    this.holdReason = holdReason;
  }

  @Override
  public RunResource clone() {
    return new RunResource(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
