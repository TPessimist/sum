package ame.psb.db;

import java.util.Date;

public class McsResourceGroupPort {

  private String handle;

  private String resourceTypeBo;

  private String resourceBo;

  private String resourceId;

  private String mcsStateName;

  private String nextResourceBo;

  private String bayBo;

  private Date updatedTime;


  public McsResourceGroupPort() {
  }

  public McsResourceGroupPort(McsResourceGroupPort data) {
    this.handle = data.handle;
    this.resourceTypeBo = data.resourceTypeBo;
    this.resourceBo = data.resourceBo;
    this.resourceId = data.resourceId;
    this.mcsStateName = data.mcsStateName;
    this.nextResourceBo = data.nextResourceBo;
    this.bayBo = data.bayBo;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public McsResourceGroupPort clone() {
    return new McsResourceGroupPort(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getResourceTypeBo() {
    return this.resourceTypeBo;
  }

  public void setResourceTypeBo(String resourceTypeBo) {
    this.resourceTypeBo = resourceTypeBo;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getResourceId() {
    return this.resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public String getMcsStateName() {
    return this.mcsStateName;
  }

  public void setMcsStateName(String mcsStateName) {
    this.mcsStateName = mcsStateName;
  }

  public String getNextResourceBo() {
    return this.nextResourceBo;
  }

  public void setNextResourceBo(String nextResourceBo) {
    this.nextResourceBo = nextResourceBo;
  }

  public String getBayBo() {
    return this.bayBo;
  }

  public void setBayBo(String bayBo) {
    this.bayBo = bayBo;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
