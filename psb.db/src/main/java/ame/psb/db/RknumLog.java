package ame.psb.db;

import java.math.BigDecimal;

public class RknumLog {

  private String rknum;

  private String zzcnlh;

  private String charg;

  private String licha;

  private BigDecimal bdmng;

  private String hsdat;

  private String vfdat;

  private String content;

  private String value;


  public RknumLog() {
  }

  public RknumLog(RknumLog data) {
    this.rknum = data.rknum;
    this.zzcnlh = data.zzcnlh;
    this.charg = data.charg;
    this.licha = data.licha;
    this.bdmng = data.bdmng;
    this.hsdat = data.hsdat;
    this.vfdat = data.vfdat;
    this.content = data.content;
    this.value = data.value;
  }

  public String getRknum() {
    return rknum;
  }

  public void setRknum(String rknum) {
    this.rknum = rknum;
  }

  public String getZzcnlh() {
    return zzcnlh;
  }

  public void setZzcnlh(String zzcnlh) {
    this.zzcnlh = zzcnlh;
  }

  public String getCharg() {
    return charg;
  }

  public void setCharg(String charg) {
    this.charg = charg;
  }

  public String getLicha() {
    return licha;
  }

  public void setLicha(String licha) {
    this.licha = licha;
  }

  public BigDecimal getBdmng() {
    return bdmng;
  }

  public void setBdmng(BigDecimal bdmng) {
    this.bdmng = bdmng;
  }

  public String getHsdat() {
    return hsdat;
  }

  public void setHsdat(String hsdat) {
    this.hsdat = hsdat;
  }

  public String getVfdat() {
    return vfdat;
  }

  public void setVfdat(String vfdat) {
    this.vfdat = vfdat;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public RknumLog clone() {
    return new RknumLog(this);
  }

  @Override
  public String toString() {
    return this.rknum;
  }
}
