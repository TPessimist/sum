package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class GoldenWaferCheckRule {

  private String deviceName;

  private String fileType;

  private BigDecimal lineQty;

  private BigDecimal xCol;

  private BigDecimal yCol;

  private BigDecimal binCol;

  private BigDecimal numFromCol;

  private BigDecimal numToCol;

  private String valueOne;

  private String valueTwo;

  private String valueThree;

  private String updateUser;

  private Date updateTime;

  public GoldenWaferCheckRule() {
  }

  public GoldenWaferCheckRule(GoldenWaferCheckRule data) {
    this.deviceName = data.deviceName;
    this.fileType = data.fileType;
    this.lineQty = data.lineQty;
    this.xCol = data.xCol;
    this.yCol = data.yCol;
    this.binCol = data.binCol;
    this.numFromCol = data.numFromCol;
    this.numToCol = data.numToCol;
    this.valueOne = data.valueOne;
    this.valueTwo = data.valueTwo;
    this.valueThree = data.valueThree;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public BigDecimal getLineQty() {
    return lineQty;
  }

  public void setLineQty(BigDecimal lineQty) {
    this.lineQty = lineQty;
  }

  public BigDecimal getXCol() {
    return xCol;
  }

  public void setXCol(BigDecimal xCol) {
    this.xCol = xCol;
  }

  public BigDecimal getYCol() {
    return yCol;
  }

  public void setYCol(BigDecimal yCol) {
    this.yCol = yCol;
  }

  public BigDecimal getBinCol() {
    return binCol;
  }

  public void setBinCol(BigDecimal binCol) {
    this.binCol = binCol;
  }

  public BigDecimal getNumFromCol() {
    return numFromCol;
  }

  public void setNumFromCol(BigDecimal numFromCol) {
    this.numFromCol = numFromCol;
  }

  public BigDecimal getNumToCol() {
    return numToCol;
  }

  public void setNumToCol(BigDecimal numToCol) {
    this.numToCol = numToCol;
  }

  public String getValueOne() {
    return valueOne;
  }

  public void setValueOne(String valueOne) {
    this.valueOne = valueOne;
  }

  public String getValueTwo() {
    return valueTwo;
  }

  public void setValueTwo(String valueTwo) {
    this.valueTwo = valueTwo;
  }

  public String getValueThree() {
    return valueThree;
  }

  public void setValueThree(String valueThree) {
    this.valueThree = valueThree;
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
  public GoldenWaferCheckRule clone() {
    return new GoldenWaferCheckRule(this);
  }

  @Override
  public String toString() {
    return this.deviceName;
  }
}
