package ame.psb.db;

import java.math.BigDecimal;

public class SendingPrint {

  private String rsnum;

  private BigDecimal bdmng;

  private String charg;

  private String licha;

  private String vfdat;

  private String hsdat;

  private String zzcnlh;

  public SendingPrint() {
  }

  public SendingPrint(SendingPrint data) {
    this.rsnum = data.rsnum;
    this.bdmng = data.bdmng;
    this.charg = data.charg;
    this.licha = data.licha;
    this.vfdat = data.vfdat;
    this.hsdat = data.hsdat;
    this.zzcnlh = data.zzcnlh;
  }

  public String getRsnum() {
    return rsnum;
  }

  public void setRsnum(String rsnum) {
    this.rsnum = rsnum;
  }

  public BigDecimal getBdmng() {
    return bdmng;
  }

  public void setBdmng(BigDecimal bdmng) {
    this.bdmng = bdmng;
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

  public String getVfdat() {
    return vfdat;
  }

  public void setVfdat(String vfdat) {
    this.vfdat = vfdat;
  }

  public String getHsdat() {
    return hsdat;
  }

  public void setHsdat(String hsdat) {
    this.hsdat = hsdat;
  }

  public String getZzcnlh() {
    return zzcnlh;
  }

  public void setZzcnlh(String zzcnlh) {
    this.zzcnlh = zzcnlh;
  }

  @Override
  public SendingPrint clone() {
    return new SendingPrint(this);
  }

  @Override
  public String toString() {
    return this.charg;
  }
}
