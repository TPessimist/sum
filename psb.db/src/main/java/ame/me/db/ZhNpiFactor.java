package ame.me.db;

import java.util.Date;

public class ZhNpiFactor {

  private String factor;

  private String description;

  private String factorType;

  private String defaultValue;

  private String range;

  private String attachedToGbo;

  private String seq;

  private String updatedUser;

  private Date updatedTime;

  private String validator;


  public ZhNpiFactor() {
  }

  public ZhNpiFactor(ZhNpiFactor data) {
    this.factor = data.factor;
    this.description = data.description;
    this.factorType = data.factorType;
    this.defaultValue = data.defaultValue;
    this.range = data.range;
    this.attachedToGbo = data.attachedToGbo;
    this.seq = data.seq;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.validator = data.validator;
  }

  public String getFactor() {
    return factor;
  }

  public void setFactor(String factor) {
    this.factor = factor;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getFactorType() {
    return factorType;
  }

  public void setFactorType(String factorType) {
    this.factorType = factorType;
  }

  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  public String getRange() {
    return range;
  }

  public void setRange(String range) {
    this.range = range;
  }

  public String getAttachedToGbo() {
    return attachedToGbo;
  }

  public void setAttachedToGbo(String attachedToGbo) {
    this.attachedToGbo = attachedToGbo;
  }

  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
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

  public String getValidator() {
    return validator;
  }

  public void setValidator(String validator) {
    this.validator = validator;
  }

  @Override
  public ZhNpiFactor clone() {
    return new ZhNpiFactor(this);
  }

  @Override
  public String toString() {
    return this.factor;
  }
}
