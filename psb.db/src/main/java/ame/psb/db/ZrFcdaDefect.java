package ame.psb.db;

import java.util.Date;

public class ZrFcdaDefect {

  private String sfc;

  private String waferId;
  private int upLook;
  private int frameDeformation;
  private int other;
  private int missingDie;
  private String remarks;
  private String updateUser;
  private Date updateTime;
  private String content1;
  private String content2;
  private String content3;

  public ZrFcdaDefect() {
  }

  public ZrFcdaDefect(ZrFcdaDefect data) {
    this.sfc = data.sfc;
    this.waferId = data.waferId;
    this.missingDie = data.missingDie;
    this.upLook = data.upLook;
    this.frameDeformation = data.frameDeformation;
    this.other = data.other;
    this.remarks = data.remarks;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
    this.content1 = data.content1;
    this.content2 = data.content2;
    this.content3 = data.content3;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getWaferId() {
    return waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
  }

  public int getMissingDie() {
    return missingDie;
  }

  public void setMissingDie(int missingDie) {
    this.missingDie = missingDie;
  }

  public int getUpLook() {
    return upLook;
  }

  public void setUpLook(int upLook) {
    this.upLook = upLook;
  }

  public int getFrameDeformation() {
    return frameDeformation;
  }

  public void setFrameDeformation(int frameDeformation) {
    this.frameDeformation = frameDeformation;
  }

  public int getOther() {
    return other;
  }

  public void setOther(int other) {
    this.other = other;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
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

  public String getContent1() {
    return content1;
  }

  public void setContent1(String content1) {
    this.content1 = content1;
  }

  public String getContent2() {
    return content2;
  }

  public void setContent2(String content2) {
    this.content2 = content2;
  }

  public String getContent3() {
    return content3;
  }

  public void setContent3(String content3) {
    this.content3 = content3;
  }

  @Override
  public ZrFcdaDefect clone() {
    return new ZrFcdaDefect(this);
  }

  @Override
  public String toString() {
    return this.waferId;
  }
}
