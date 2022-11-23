package ame.psb.db;

import java.util.Date;

public class LabelInfoMaterialBindingDetail {

  private String materialCustomerItemset;

  private String statename;

  private String processcardrecipe;

  private String resource;

  private String reelid;

  private String updatedUser;

  private Date updatedTime;


  public LabelInfoMaterialBindingDetail() {
  }

  public LabelInfoMaterialBindingDetail(LabelInfoMaterialBindingDetail data) {
    this.materialCustomerItemset = data.materialCustomerItemset;
    this.statename = data.statename;
    this.processcardrecipe = data.processcardrecipe;
    this.resource = data.resource;
    this.reelid = data.reelid;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }


  public String getMaterialCustomerItemset() {
    return materialCustomerItemset;
  }

  public void setMaterialCustomerItemset(String materialCustomerItemset) {
    this.materialCustomerItemset = materialCustomerItemset;
  }

  public String getStatename() {
    return statename;
  }

  public void setStatename(String statename) {
    this.statename = statename;
  }

  public String getProcesscardrecipe() {
    return processcardrecipe;
  }

  public void setProcesscardrecipe(String processcardrecipe) {
    this.processcardrecipe = processcardrecipe;
  }

  public String getResource() {
    return resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public String getReelid() {
    return reelid;
  }

  public void setReelid(String reelid) {
    this.reelid = reelid;
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
  public LabelInfoMaterialBindingDetail clone() {
    return new LabelInfoMaterialBindingDetail(this);
  }

  @Override
  public String toString() {
    return this.materialCustomerItemset + ", " + this.statename + ", " + this.reelid;
  }
}
