package ame.psb.db;

import java.util.Date;

public class ResourceComponentEvent {

  private String id;

  private String resourceBo;

  private String componentId;

  private String eventName;

  private String eventMessage;

  private Date eventTime;

  private String eventUser;

  private String waferId;

  private String sfc;


  public ResourceComponentEvent() {
  }

  public ResourceComponentEvent(ResourceComponentEvent data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.componentId = data.componentId;
    this.eventName = data.eventName;
    this.eventMessage = data.eventMessage;
    this.eventTime = data.eventTime;
    this.eventUser = data.eventUser;
    this.waferId = data.waferId;
    this.sfc = data.sfc;
  }

  public void generateId() {
    if (this.resourceBo == null || this.componentId == null || this.eventName == null) {
      throw new NullPointerException("resourceBo||componentId||eventName is null");
    }
    this.id = this.resourceBo + "::" + this.componentId + "::" + this.eventName + "::" + System
        .currentTimeMillis();
  }


  @Override
  public ResourceComponentEvent clone() {
    return new ResourceComponentEvent(this);
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

  public String getComponentId() {
    return this.componentId;
  }

  public void setComponentId(String componentId) {
    this.componentId = componentId;
  }

  public String getEventName() {
    return this.eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public String getEventMessage() {
    return this.eventMessage;
  }

  public void setEventMessage(String eventMessage) {
    this.eventMessage = eventMessage;
  }

  public Date getEventTime() {
    return this.eventTime;
  }

  public void setEventTime(Date eventTime) {
    this.eventTime = eventTime;
  }

  public String getEventUser() {
    return this.eventUser;
  }

  public void setEventUser(String eventUser) {
    this.eventUser = eventUser;
  }

  public String getWaferId() {
    return this.waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
  }

  public String getSfc() {
    return this.sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }
}
