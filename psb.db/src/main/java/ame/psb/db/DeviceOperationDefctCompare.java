package ame.psb.db;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DeviceOperationDefctCompare {

  private String id;

  private String device;

  private String operation;

  private String ncCodes;

  private String perviousOperation;

  private String perviousNcCodes;

  private int differMax;

  private int differMin;

  private String holdComment;

  private String updatedUser;

  private Date updatedTime;


  public DeviceOperationDefctCompare() {
  }

  public DeviceOperationDefctCompare(DeviceOperationDefctCompare data) {
    this.id = data.id;
    this.device = data.device;
    this.operation = data.operation;
    this.ncCodes = data.ncCodes;
    this.perviousOperation = data.perviousOperation;
    this.perviousNcCodes = data.perviousNcCodes;
    this.differMax = data.differMax;
    this.differMin = data.differMin;
    this.holdComment = data.holdComment;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  @Override
  public DeviceOperationDefctCompare clone() {
    return new DeviceOperationDefctCompare(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getNcCodes() {
    return ncCodes;
  }

  public void setNcCodes(String ncCodes) {
    this.ncCodes = ncCodes;
  }

  public String getPerviousOperation() {
    return perviousOperation;
  }

  public void setPerviousOperation(String perviousOperation) {
    this.perviousOperation = perviousOperation;
  }

  public String getPerviousNcCodes() {
    return perviousNcCodes;
  }

  public void setPerviousNcCodes(String perviousNcCodes) {
    this.perviousNcCodes = perviousNcCodes;
  }

  public int getDifferMax() {
    return differMax;
  }

  public void setDifferMax(int differMax) {
    this.differMax = differMax;
  }

  public int getDifferMin() {
    return differMin;
  }

  public void setDifferMin(int differMin) {
    this.differMin = differMin;
  }

  public String getHoldComment() {
    return holdComment;
  }

  public void setHoldComment(String holdComment) {
    this.holdComment = holdComment;
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

  public List<String> getNcList() {
    return Arrays.asList(this.ncCodes.split(","));
  }

  public List<String> getPerviousNcList() {
    return Arrays.asList(this.perviousNcCodes.split(","));
  }

  public boolean isOut(int differ) {
    return differ > this.differMax || differ < this.differMin;
  }

}
