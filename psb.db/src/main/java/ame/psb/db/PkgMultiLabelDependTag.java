package ame.psb.db;

import java.util.Date;

public class PkgMultiLabelDependTag {

  private String labelBo;

  private String tagBo;

  private String reserveField1;

  private String reserveField2;

  private String updatedUser;

  private Date updatedTime;


  public PkgMultiLabelDependTag() {
  }

  public PkgMultiLabelDependTag(PkgMultiLabelDependTag data) {
    this.labelBo = data.labelBo;
    this.tagBo = data.tagBo;
    this.reserveField1 = data.reserveField1;
    this.reserveField2 = data.reserveField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getLabelBo() {
    return labelBo;
  }

  public void setLabelBo(String labelBo) {
    this.labelBo = labelBo;
  }

  public String getTagBo() {
    return tagBo;
  }

  public void setTagBo(String tagBo) {
    this.tagBo = tagBo;
  }

  public String getReserveField1() {
    return reserveField1;
  }

  public void setReserveField1(String reserveField1) {
    this.reserveField1 = reserveField1;
  }

  public String getReserveField2() {
    return reserveField2;
  }

  public void setReserveField2(String reserveField2) {
    this.reserveField2 = reserveField2;
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
  public PkgMultiLabelDependTag clone() {
    return new PkgMultiLabelDependTag(this);
  }

  @Override
  public String toString() {
    return this.labelBo + ", " + this.tagBo;
  }
}
