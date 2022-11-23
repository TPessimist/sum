package ame.psb.db;

import java.util.Date;

public class DeviceOperationBuyoff {

  private String itemGroupBo;

  private String operationBo;

  private String holdType;

  private boolean buyoffFlag;

  private boolean npiApproved;

  private String npiComment;

  private String npiPicturePath;

  private boolean peApproved;

  private String peComment;

  private String pePicturePath;

  private boolean qeApproved;

  private String qeComment;

  private String qePicturePath;

  private Date updatedTime;

  private String updatedUser;


  public DeviceOperationBuyoff() {
  }

  public DeviceOperationBuyoff(DeviceOperationBuyoff data) {
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.holdType = data.holdType;
    this.buyoffFlag = data.buyoffFlag;
    this.npiApproved = data.npiApproved;
    this.npiComment = data.npiComment;
    this.npiPicturePath = data.npiPicturePath;
    this.peApproved = data.peApproved;
    this.peComment = data.peComment;
    this.pePicturePath = data.pePicturePath;
    this.qeApproved = data.qeApproved;
    this.qeComment = data.qeComment;
    this.qePicturePath = data.qePicturePath;
    this.updatedTime = data.updatedTime;
    this.updatedUser = data.updatedUser;
  }

  @Override
  public DeviceOperationBuyoff clone() {
    return new DeviceOperationBuyoff(this);
  }

  @Override
  public String toString() {
    return this.itemGroupBo + ", " + this.operationBo + ", " + this.holdType;
  }

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getHoldType() {
    return holdType;
  }

  public void setHoldType(String holdType) {
    this.holdType = holdType;
  }

  public boolean getBuyoffFlag() {
    return buyoffFlag;
  }

  public void setBuyoffFlag(boolean buyoffFlag) {
    this.buyoffFlag = buyoffFlag;
  }

  public boolean getNpiApproved() {
    return npiApproved;
  }

  public void setNpiApproved(boolean npiApproved) {
    this.npiApproved = npiApproved;
  }

  public String getNpiComment() {
    return npiComment;
  }

  public void setNpiComment(String npiComment) {
    this.npiComment = npiComment;
  }

  public String getNpiPicturePath() {
    return npiPicturePath;
  }

  public void setNpiPicturePath(String npiPicturePath) {
    this.npiPicturePath = npiPicturePath;
  }

  public boolean getPeApproved() {
    return peApproved;
  }

  public void setPeApproved(boolean peApproved) {
    this.peApproved = peApproved;
  }

  public String getPeComment() {
    return peComment;
  }

  public void setPeComment(String peComment) {
    this.peComment = peComment;
  }

  public String getPePicturePath() {
    return pePicturePath;
  }

  public void setPePicturePath(String pePicturePath) {
    this.pePicturePath = pePicturePath;
  }

  public boolean getQeApproved() {
    return qeApproved;
  }

  public void setQeApproved(boolean qeApproved) {
    this.qeApproved = qeApproved;
  }

  public String getQeComment() {
    return qeComment;
  }

  public void setQeComment(String qeComment) {
    this.qeComment = qeComment;
  }

  public String getQePicturePath() {
    return qePicturePath;
  }

  public void setQePicturePath(String qePicturePath) {
    this.qePicturePath = qePicturePath;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

}
