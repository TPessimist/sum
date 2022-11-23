package ame.psb.db;

import java.util.Date;

public class ManualHoldOcap {

  private String holdDetailBo;

  private String sfcBo;

  private String value;

  private String requestId;

  private String processFlag;
  private String holdUser;
  private Date holdTime;

  public ManualHoldOcap() {
  }

  public ManualHoldOcap(ManualHoldOcap data) {
    this.holdDetailBo = data.holdDetailBo;
    this.sfcBo = data.sfcBo;
    this.value = data.value;
    this.requestId = data.requestId;
    this.processFlag = data.processFlag;
    this.holdUser = data.holdUser;
    this.holdTime = data.holdTime;
  }

  public String getHoldDetailBo() {
    return holdDetailBo;
  }

  public void setHoldDetailBo(String holdDetailBo) {
    this.holdDetailBo = holdDetailBo;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getProcessFlag() {
    return processFlag;
  }

  public void setProcessFlag(String processFlag) {
    this.processFlag = processFlag;
  }

  public String getHoldUser() {
    return holdUser;
  }

  public void setHoldUser(String holdUser) {
    this.holdUser = holdUser;
  }

  public Date getHoldTime() {
    return holdTime;
  }

  public void setHoldTime(Date holdTime) {
    this.holdTime = holdTime;
  }

  @Override
  public ManualHoldOcap clone() {
    return new ManualHoldOcap(this);
  }

  @Override
  public String toString() {
    return this.holdDetailBo;
  }
}
