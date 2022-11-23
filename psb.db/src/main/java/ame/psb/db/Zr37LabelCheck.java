package ame.psb.db;

import java.util.Date;

public class Zr37LabelCheck {

  private String reelId;

  private String reelPkgId;

  private String reelSeq;

  private String dn;

  private String dz;

  private String jobId;

  private String outContainer;

  private String outPkgId;

  private String outValue;

  private String outTerminalValue;

  private String outSeq;

  private String inPkgId;

  private String inValue;

  private String inTerminalValue;

  private String inSeq;

  private String reelValue;

  private String reelTerminalValue;

  private String kid;

  private String printUser;

  private Date printTime;

  private String checkUser;

  private Date checkTime;

  private String checkFlag;


  public Zr37LabelCheck() {
  }

  public Zr37LabelCheck(Zr37LabelCheck data) {
    this.reelId = data.reelId;
    this.reelPkgId = data.reelPkgId;
    this.reelSeq = data.reelSeq;
    this.dn = data.dn;
    this.dz = data.dz;
    this.jobId = data.jobId;
    this.outContainer = data.outContainer;
    this.outPkgId = data.outPkgId;
    this.outValue = data.outValue;
    this.outTerminalValue = data.outTerminalValue;
    this.outSeq = data.outSeq;
    this.inPkgId = data.inPkgId;
    this.inValue = data.inValue;
    this.inTerminalValue = data.inTerminalValue;
    this.inSeq = data.inSeq;
    this.reelValue = data.reelValue;
    this.reelTerminalValue = data.reelTerminalValue;
    this.kid = data.kid;
    this.printUser = data.printUser;
    this.printTime = data.printTime;
    this.checkUser = data.checkUser;
    this.checkTime = data.checkTime;
    this.checkFlag = data.checkFlag;
  }

  public String getReelId() {
    return reelId;
  }

  public void setReelId(String reelId) {
    this.reelId = reelId;
  }

  public String getReelPkgId() {
    return reelPkgId;
  }

  public void setReelPkgId(String reelPkgId) {
    this.reelPkgId = reelPkgId;
  }

  public String getReelSeq() {
    return reelSeq;
  }

  public void setReelSeq(String reelSeq) {
    this.reelSeq = reelSeq;
  }

  public String getDn() {
    return dn;
  }

  public void setDn(String dn) {
    this.dn = dn;
  }

  public String getDz() {
    return dz;
  }

  public void setDz(String dz) {
    this.dz = dz;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public String getOutContainer() {
    return outContainer;
  }

  public void setOutContainer(String outContainer) {
    this.outContainer = outContainer;
  }

  public String getOutPkgId() {
    return outPkgId;
  }

  public void setOutPkgId(String outPkgId) {
    this.outPkgId = outPkgId;
  }

  public String getOutValue() {
    return outValue;
  }

  public void setOutValue(String outValue) {
    this.outValue = outValue;
  }

  public String getOutTerminalValue() {
    return outTerminalValue;
  }

  public void setOutTerminalValue(String outTerminalValue) {
    this.outTerminalValue = outTerminalValue;
  }

  public String getOutSeq() {
    return outSeq;
  }

  public void setOutSeq(String outSeq) {
    this.outSeq = outSeq;
  }

  public String getInPkgId() {
    return inPkgId;
  }

  public void setInPkgId(String inPkgId) {
    this.inPkgId = inPkgId;
  }

  public String getInValue() {
    return inValue;
  }

  public void setInValue(String inValue) {
    this.inValue = inValue;
  }

  public String getInTerminalValue() {
    return inTerminalValue;
  }

  public void setInTerminalValue(String inTerminalValue) {
    this.inTerminalValue = inTerminalValue;
  }

  public String getInSeq() {
    return inSeq;
  }

  public void setInSeq(String inSeq) {
    this.inSeq = inSeq;
  }

  public String getReelValue() {
    return reelValue;
  }

  public void setReelValue(String reelValue) {
    this.reelValue = reelValue;
  }

  public String getReelTerminalValue() {
    return reelTerminalValue;
  }

  public void setReelTerminalValue(String reelTerminalValue) {
    this.reelTerminalValue = reelTerminalValue;
  }

  public String getKid() {
    return kid;
  }

  public void setKid(String kid) {
    this.kid = kid;
  }

  public String getPrintUser() {
    return printUser;
  }

  public void setPrintUser(String printUser) {
    this.printUser = printUser;
  }

  public Date getPrintTime() {
    return printTime;
  }

  public void setPrintTime(Date printTime) {
    this.printTime = printTime;
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

  public String getCheckFlag() {
    return checkFlag;
  }

  public void setCheckFlag(String checkFlag) {
    this.checkFlag = checkFlag;
  }

  @Override
  public Zr37LabelCheck clone() {
    return new Zr37LabelCheck(this);
  }

  @Override
  public String toString() {
    return this.reelId;
  }
}
