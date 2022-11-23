package ame.psb.db;

import java.util.Date;

public class LabelQrcode {

  private String labelBo;

  private String qrcode;

  private String intervalChar;

  private String startChar;

  private String endChar;

  private String reserveField1;

  private String reserveField2;

  private String updatedUser;

  private Date updatedTime;


  public LabelQrcode() {
  }

  public LabelQrcode(LabelQrcode data) {
    this.labelBo = data.labelBo;
    this.qrcode = data.qrcode;
    this.intervalChar = data.intervalChar;
    this.startChar = data.startChar;
    this.endChar = data.endChar;
    this.reserveField1 = data.reserveField1;
    this.reserveField2 = data.reserveField2;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public LabelQrcode clone() {
    return new LabelQrcode(this);
  }

  @Override
  public String toString() {
    return this.labelBo + ", " + this.qrcode;
  }

  public String getLabelBo() {
    return labelBo;
  }

  public void setLabelBo(String labelBo) {
    this.labelBo = labelBo;
  }

  public String getQrcode() {
    return qrcode;
  }

  public void setQrcode(String qrcode) {
    this.qrcode = qrcode;
  }

  public String getIntervalChar() {
    return intervalChar;
  }

  public void setIntervalChar(String intervalChar) {
    this.intervalChar = intervalChar;
  }

  public String getStartChar() {
    return startChar;
  }

  public void setStartChar(String startChar) {
    this.startChar = startChar;
  }

  public String getEndChar() {
    return endChar;
  }

  public void setEndChar(String endChar) {
    this.endChar = endChar;
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
}
