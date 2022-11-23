package ame.psb.db;

public class ZrSendingPrint {

  private String rsnum;

  private String zzcnlh;

  private String charg;

  private String licha;

  private String bdmng;

  private String vfdat;

  private String hsdat;

  private String labelQty;

  private String inventoryQty;

  private String content;

  private String value;

  public ZrSendingPrint() {
  }

  public ZrSendingPrint(ZrSendingPrint data) {
    this.rsnum = data.rsnum;
    this.zzcnlh = data.zzcnlh;
    this.charg = data.charg;
    this.licha = data.licha;
    this.bdmng = data.bdmng;
    this.vfdat = data.vfdat;
    this.hsdat = data.hsdat;
    this.labelQty = data.labelQty;
    this.inventoryQty = data.inventoryQty;
    this.content = data.content;
    this.value = data.value;
  }

  public String getRsnum() {
    return rsnum;
  }

  public void setRsnum(String rsnum) {
    this.rsnum = rsnum;
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

  public String getBdmng() {
    return bdmng;
  }

  public void setBdmng(String bdmng) {
    this.bdmng = bdmng;
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

  public String getLabelQty() {
    return labelQty;
  }

  public void setLabelQty(String labelQty) {
    this.labelQty = labelQty;
  }

  public String getInventoryQty() {
    return inventoryQty;
  }

  public void setInventoryQty(String inventoryQty) {
    this.inventoryQty = inventoryQty;
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
  public ZrSendingPrint clone() {
    return new ZrSendingPrint(this);
  }

  @Override
  public String toString() {
    return this.rsnum;
  }
}
