package ame.psb.db;

import java.math.BigDecimal;

public class ReportMoveDw {

  private String matnr;

  private String zzcnlh;

  private String stage;

  private String alpgr;

  private String matnr1;

  private String zzcnlh1;

  private BigDecimal clabs;

  public ReportMoveDw() {
  }

  public ReportMoveDw(ReportMoveDw data) {
    this.matnr = data.matnr;
    this.zzcnlh = data.zzcnlh;
    this.stage = data.stage;
    this.alpgr = data.alpgr;
    this.matnr1 = data.matnr1;
    this.zzcnlh1 = data.zzcnlh1;
    this.clabs = data.clabs;
  }

  public String getMatnr() {
    return matnr;
  }

  public void setMatnr(String matnr) {
    this.matnr = matnr;
  }

  public String getZzcnlh() {
    return zzcnlh;
  }

  public void setZzcnlh(String zzcnlh) {
    this.zzcnlh = zzcnlh;
  }

  public String getStage() {
    return stage;
  }

  public void setStage(String stage) {
    this.stage = stage;
  }

  public String getAlpgr() {
    return alpgr;
  }

  public void setAlpgr(String alpgr) {
    this.alpgr = alpgr;
  }

  public String getMatnr1() {
    return matnr1;
  }

  public void setMatnr1(String matnr1) {
    this.matnr1 = matnr1;
  }

  public String getZzcnlh1() {
    return zzcnlh1;
  }

  public void setZzcnlh1(String zzcnlh1) {
    this.zzcnlh1 = zzcnlh1;
  }

  public BigDecimal getClabs() {
    return clabs;
  }

  public void setClabs(BigDecimal clabs) {
    this.clabs = clabs;
  }

  @Override
  public ReportMoveDw clone() {
    return new ReportMoveDw(this);
  }


}
