package ame.psb.db;

import java.util.Date;

public class LabelCheckRule {

  private String device;

  private String rcodesplit;

  private String rbseq;

  private String iseq;
  private String cseq;

  private String rbcheck;

  private String ichecka;

  private String icheckb;

  private String ccheck;

  private String rcontain;

  private String bcontain;

  private String icontain;

  private String ccontain;

  private String rbqty;

  private String iqty;

  private String cqty;

  private String rbseqnum;

  private String iseqnum;

  private String cseqnum;

  private String rbseqnumno;

  private String iseqnumno;

  private String cseqnumno;

  private String updateUser;

  private Date updateTime;


  public LabelCheckRule() {
  }

  public LabelCheckRule(LabelCheckRule data) {
    this.device = data.device;
    this.rcodesplit = data.rcodesplit;
    this.rbseq = data.rbseq;
    this.iseq = data.iseq;
    this.cseq = data.cseq;
    this.rbcheck = data.rbcheck;
    this.ichecka = data.ichecka;
    this.icheckb = data.icheckb;
    this.ccheck = data.ccheck;
    this.rcontain = data.rcontain;
    this.bcontain = data.bcontain;
    this.icontain = data.icontain;
    this.ccontain = data.ccontain;
    this.rbqty = data.rbqty;
    this.iqty = data.iqty;
    this.cqty = data.cqty;
    this.rbseqnum = data.rbseqnum;
    this.iseqnum = data.iseqnum;
    this.cseqnum = data.cseqnum;
    this.rbseqnumno = data.rbseqnumno;
    this.iseqnumno = data.iseqnumno;
    this.cseqnumno = data.cseqnumno;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getDevice() {
    return device;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public String getRcodesplit() {
    return rcodesplit;
  }

  public void setRcodesplit(String rcodesplit) {
    this.rcodesplit = rcodesplit;
  }

  public String getRbseq() {
    return rbseq;
  }

  public void setRbseq(String rbseq) {
    this.rbseq = rbseq;
  }

  public String getCseq() {
    return cseq;
  }

  public void setCseq(String cseq) {
    this.cseq = cseq;
  }

  public String getIseq() {
    return iseq;
  }

  public void setIseq(String iseq) {
    this.iseq = iseq;
  }

  public String getRbcheck() {
    return rbcheck;
  }

  public void setRbcheck(String rbcheck) {
    this.rbcheck = rbcheck;
  }

  public String getIchecka() {
    return ichecka;
  }

  public void setIchecka(String ichecka) {
    this.ichecka = ichecka;
  }

  public String getIcheckb() {
    return icheckb;
  }

  public void setIcheckb(String icheckb) {
    this.icheckb = icheckb;
  }

  public String getCcheck() {
    return ccheck;
  }

  public void setCcheck(String ccheck) {
    this.ccheck = ccheck;
  }

  public String getRcontain() {
    return rcontain;
  }

  public void setRcontain(String rcontain) {
    this.rcontain = rcontain;
  }

  public String getBcontain() {
    return bcontain;
  }

  public void setBcontain(String bcontain) {
    this.bcontain = bcontain;
  }

  public String getIcontain() {
    return icontain;
  }

  public void setIcontain(String icontain) {
    this.icontain = icontain;
  }

  public String getCcontain() {
    return ccontain;
  }

  public void setCcontain(String ccontain) {
    this.ccontain = ccontain;
  }

  public String getRbqty() {
    return rbqty;
  }

  public void setRbqty(String rbqty) {
    this.rbqty = rbqty;
  }

  public String getIqty() {
    return iqty;
  }

  public void setIqty(String iqty) {
    this.iqty = iqty;
  }

  public String getCqty() {
    return cqty;
  }

  public void setCqty(String cqty) {
    this.cqty = cqty;
  }

  public String getRbseqnum() {
    return rbseqnum;
  }

  public void setRbseqnum(String rbseqnum) {
    this.rbseqnum = rbseqnum;
  }

  public String getIseqnum() {
    return iseqnum;
  }

  public void setIseqnum(String iseqnum) {
    this.iseqnum = iseqnum;
  }

  public String getCseqnum() {
    return cseqnum;
  }

  public void setCseqnum(String cseqnum) {
    this.cseqnum = cseqnum;
  }

  public String getRbseqnumno() {
    return rbseqnumno;
  }

  public void setRbseqnumno(String rbseqnumno) {
    this.rbseqnumno = rbseqnumno;
  }

  public String getIseqnumno() {
    return iseqnumno;
  }

  public void setIseqnumno(String iseqnumno) {
    this.iseqnumno = iseqnumno;
  }

  public String getCseqnumno() {
    return cseqnumno;
  }

  public void setCseqnumno(String cseqnumno) {
    this.cseqnumno = cseqnumno;
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
  public LabelCheckRule clone() {
    return new LabelCheckRule(this);
  }

  @Override
  public String toString() {
    return this.device;
  }


}
