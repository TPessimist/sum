package ame.psb.db;

import java.util.Date;

public class VeiwPkgVolume {

  private String customer;

  private String operationBo;

  private String outerBox;

  private String volumeSize;

  private String erserve1;

  private String erserve2;

  private String updateUser;

  private Date updateTime;

  public VeiwPkgVolume() {
  }

  public VeiwPkgVolume(VeiwPkgVolume data) {
    this.customer = data.customer;
    this.operationBo = data.operationBo;
    this.outerBox = data.outerBox;
    this.volumeSize = data.volumeSize;
    this.erserve1 = data.erserve1;
    this.erserve2 = data.erserve2;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getCustomer() {
    return customer;
  }

  public void setCustomer(String customer) {
    this.customer = customer;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getOuterBox() {
    return outerBox;
  }

  public void setOuterBox(String outerBox) {
    this.outerBox = outerBox;
  }

  public String getVolumeSize() {
    return volumeSize;
  }

  public void setVolumeSize(String volumeSize) {
    this.volumeSize = volumeSize;
  }

  public String getErserve1() {
    return erserve1;
  }

  public void setErserve1(String erserve1) {
    this.erserve1 = erserve1;
  }

  public String getErserve2() {
    return erserve2;
  }

  public void setErserve2(String erserve2) {
    this.erserve2 = erserve2;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public VeiwPkgVolume clone() {
    return new VeiwPkgVolume(this);
  }

  @Override
  public String toString() {
    return this.customer + ", " + this.operationBo + ", " + this.volumeSize;
  }
}
