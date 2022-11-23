package ame.psb.db;

import java.util.Date;

public class TsvLabelCheck {

  private String labelOut;

  private String containerIdOut;

  private String labelIn;

  private String containerIdIn;

  private String checkUser;

  private Date checkTime;


  public TsvLabelCheck() {
  }

  public TsvLabelCheck(TsvLabelCheck data) {
    this.labelOut = data.labelOut;
    this.containerIdOut = data.containerIdOut;
    this.labelIn = data.labelIn;
    this.containerIdIn = data.containerIdIn;
    this.checkUser = data.checkUser;
    this.checkTime = data.checkTime;
  }

  public String getLabelOut() {
    return labelOut;
  }

  public void setLabelOut(String labelOut) {
    this.labelOut = labelOut;
  }

  public String getContainerIdOut() {
    return containerIdOut;
  }

  public void setContainerIdOut(String containerIdOut) {
    this.containerIdOut = containerIdOut;
  }

  public String getLabelIn() {
    return labelIn;
  }

  public void setLabelIn(String labelIn) {
    this.labelIn = labelIn;
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
  public TsvLabelCheck clone() {
    return new TsvLabelCheck(this);
  }

  @Override
  public String toString() {
    return this.labelOut;
  }
}
