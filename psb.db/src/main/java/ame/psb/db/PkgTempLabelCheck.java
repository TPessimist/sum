package ame.psb.db;

import java.util.Date;

public class PkgTempLabelCheck {

  private String labelTempInfo;

  private String flag;

  private Date checkTime;

  private String checkUser;


  public PkgTempLabelCheck() {
  }

  public PkgTempLabelCheck(PkgTempLabelCheck data) {
    this.labelTempInfo = data.labelTempInfo;
    this.flag = data.flag;
    this.checkTime = data.checkTime;
    this.checkUser = data.checkUser;
  }


  public String getLabelTempInfo() {
    return labelTempInfo;
  }

  public void setLabelTempInfo(String labelTempInfo) {
    this.labelTempInfo = labelTempInfo;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public Date getCheckTime() {
    return checkTime;
  }

  public void setCheckTime(Date checkTime) {
    this.checkTime = checkTime;
  }

  public String getCheckUser() {
    return checkUser;
  }

  public void setCheckUser(String checkUser) {
    this.checkUser = checkUser;
  }

  @Override
  public PkgTempLabelCheck clone() {
    return new PkgTempLabelCheck(this);
  }

  @Override
  public String toString() {
    return this.labelTempInfo;
  }
}
