package ame.psb.db;

import java.util.Date;

public class SwearClockOnRecord {

  private String uuid;

  private String cardNumber;

  private String jobNumber;

  private Date clockTime;

  private String code;

  private String message;

  private String ip;


  public SwearClockOnRecord() {
  }

  public SwearClockOnRecord(SwearClockOnRecord data) {
    this.uuid = data.uuid;
    this.cardNumber = data.cardNumber;
    this.jobNumber = data.jobNumber;
    this.clockTime = data.clockTime;
    this.code = data.code;
    this.message = data.message;
    this.ip = data.ip;
  }

  @Override
  public SwearClockOnRecord clone() {
    return new SwearClockOnRecord(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getJobNumber() {
    return jobNumber;
  }

  public void setJobNumber(String jobNumber) {
    this.jobNumber = jobNumber;
  }

  public Date getClockTime() {
    return clockTime;
  }

  public void setClockTime(Date clockTime) {
    this.clockTime = clockTime;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }
}
