package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class GoldenWaferCheck {

  private String id;

  private String resourceBo;

  private String deviceName;

  private BigDecimal minValue;

  private BigDecimal maxValue;
  private String content;
  private String value;
  private String updatedUser;
  private Date updatedTime;

  public GoldenWaferCheck() {
  }

  public GoldenWaferCheck(GoldenWaferCheck data) {
    this.id = data.id;
    this.resourceBo = data.resourceBo;
    this.deviceName = data.deviceName;
    this.minValue = data.minValue;
    this.maxValue = data.maxValue;
    this.content = data.content;
    this.value = data.value;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public BigDecimal getMinValue() {
    return minValue;
  }

  public void setMinValue(BigDecimal minValue) {
    this.minValue = minValue;
  }

  public BigDecimal getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(BigDecimal maxValue) {
    this.maxValue = maxValue;
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

  @Override
  public GoldenWaferCheck clone() {
    return new GoldenWaferCheck(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
