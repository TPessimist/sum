package ame.psb.db;

import java.util.Date;

public class ProcessCT {

  private String shopOrderBo;

  private Date bumpingSod;

  private Date cpSod;

  private Date wlpSod;

  private Date fcSod;

  private Date createdTime;

  private Date updatedTime;

  private String updatedUser;


  public ProcessCT() {
  }

  public ProcessCT(ProcessCT data) {
    this.shopOrderBo = data.shopOrderBo;
    this.bumpingSod = data.bumpingSod;
    this.cpSod = data.cpSod;
    this.wlpSod = data.wlpSod;
    this.fcSod = data.fcSod;
    this.createdTime = data.createdTime;
    this.updatedTime = data.updatedTime;
    this.updatedUser = data.updatedUser;
  }

  @Override
  public ProcessCT clone() {
    return new ProcessCT(this);
  }

  @Override
  public String toString() {
    return this.shopOrderBo;
  }

  public String getShopOrderBo() {
    return this.shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public Date getBumpingSod() {
    return this.bumpingSod;
  }

  public void setBumpingSod(Date bumpingSod) {
    this.bumpingSod = bumpingSod;
  }

  public Date getCpSod() {
    return this.cpSod;
  }

  public void setCpSod(Date cpSod) {
    this.cpSod = cpSod;
  }

  public Date getWlpSod() {
    return this.wlpSod;
  }

  public void setWlpSod(Date wlpSod) {
    this.wlpSod = wlpSod;
  }

  public Date getFcSod() {
    return this.fcSod;
  }

  public void setFcSod(Date fcSod) {
    this.fcSod = fcSod;
  }

  public Date getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }
}
