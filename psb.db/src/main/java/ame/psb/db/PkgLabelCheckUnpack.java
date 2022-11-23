package ame.psb.db;

import java.util.Date;

public class PkgLabelCheckUnpack {

  private String labelTempInfo;
  private String sfcName;
  private String itemGroupBo;
  private String labelReelInfo;
  private String labelBoxInfo;
  private String containerBo;
  private String labelInInfo;
  private String labelOutInfo;
  private String pkgContainerBo;
  private String updatedUser;
  private Date updatedTime;
  private String flag;
  private Date checkTime;
  private String checkUser;

  public PkgLabelCheckUnpack() {
  }

  public PkgLabelCheckUnpack(PkgLabelCheckUnpack data) {
    this.labelTempInfo = data.labelTempInfo;
    this.sfcName = data.sfcName;
    this.itemGroupBo = data.itemGroupBo;
    this.labelReelInfo = data.labelReelInfo;
    this.labelBoxInfo = data.labelBoxInfo;
    this.containerBo = data.containerBo;
    this.labelInInfo = data.labelInInfo;
    this.labelOutInfo = data.labelOutInfo;
    this.pkgContainerBo = data.pkgContainerBo;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.flag = data.flag;
    this.checkTime = data.checkTime;
    this.checkUser = data.checkUser;
  }

  public String getLabelTempInfo() {
    return labelTempInfo;
  }

  public void setLabelTempInfo(String labelTempInfo) {
    this.labelTempInfo = labelTempInfo;
  }

  public String getSfcName() {
    return sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getLabelReelInfo() {
    return labelReelInfo;
  }

  public void setLabelReelInfo(String labelReelInfo) {
    this.labelReelInfo = labelReelInfo;
  }

  public String getLabelBoxInfo() {
    return labelBoxInfo;
  }

  public void setLabelBoxInfo(String labelBoxInfo) {
    this.labelBoxInfo = labelBoxInfo;
  }

  public String getContainerBo() {
    return containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }

  public String getLabelInInfo() {
    return labelInInfo;
  }

  public void setLabelInInfo(String labelInInfo) {
    this.labelInInfo = labelInInfo;
  }

  public String getLabelOutInfo() {
    return labelOutInfo;
  }

  public void setLabelOutInfo(String labelOutInfo) {
    this.labelOutInfo = labelOutInfo;
  }

  public String getPkgContainerBo() {
    return pkgContainerBo;
  }

  public void setPkgContainerBo(String pkgContainerBo) {
    this.pkgContainerBo = pkgContainerBo;
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

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public Date getCheckTime() {
    return checkTime;
  }

  public void setCheckTime(Date checkTime) {
    this.checkTime = checkTime;
  }

  public String getCheckUser() {
    return checkUser;
  }

  public void setCheckUser(String checkUser) {
    this.checkUser = checkUser;
  }

  @Override
  public PkgLabelCheckUnpack clone() {
    return new PkgLabelCheckUnpack(this);
  }

  @Override
  public String toString() {
    return this.labelTempInfo;
  }
}
