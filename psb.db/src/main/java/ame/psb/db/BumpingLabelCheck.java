package ame.psb.db;

import java.util.Date;

public class BumpingLabelCheck {

  private String lotOut;

  private String containerNameOut;

  private String lotIn;

  private String containerNameIn;

  private String containerIdOut;

  private String containerIdIn;

  private String checkUser;

  private Date checkTime;


  public BumpingLabelCheck() {
  }

  public BumpingLabelCheck(BumpingLabelCheck data) {
    this.lotOut = data.lotOut;
    this.containerNameOut = data.containerNameOut;
    this.lotIn = data.lotIn;
    this.containerNameIn = data.containerNameIn;
    this.containerIdOut = data.containerIdOut;
    this.containerIdIn = data.containerIdIn;
    this.checkUser = data.checkUser;
    this.checkTime = data.checkTime;
  }

  public String getLotOut() {
    return lotOut;
  }

  public void setLotOut(String lotOut) {
    this.lotOut = lotOut;
  }

  public String getContainerNameOut() {
    return containerNameOut;
  }

  public void setContainerNameOut(String containerNameOut) {
    this.containerNameOut = containerNameOut;
  }

  public String getLotIn() {
    return lotIn;
  }

  public void setLotIn(String lotIn) {
    this.lotIn = lotIn;
  }

  public String getContainerNameIn() {
    return containerNameIn;
  }

  public void setContainerNameIn(String containerNameIn) {
    this.containerNameIn = containerNameIn;
  }

  public String getContainerIdOut() {
    return containerIdOut;
  }

  public void setContainerIdOut(String containerIdOut) {
    this.containerIdOut = containerIdOut;
  }

  public String getContainerIdIn() {
    return containerIdIn;
  }

  public void setContainerIdIn(String containerIdIn) {
    this.containerIdIn = containerIdIn;
  }

  public String getCheckUser() {
    return checkUser;
  }

  public void setCheckUser(String checkUser) {
    this.checkUser = checkUser;
  }

  public Date getCheckTime() {
    return checkTime;
  }

  public void setCheckTime(Date checkTime) {
    this.checkTime = checkTime;
  }

  @Override
  public BumpingLabelCheck clone() {
    return new BumpingLabelCheck(this);
  }

  @Override
  public String toString() {
    return this.lotOut;
  }
}
