package ame.psb.db;

public class WaferDeductionProduct { //晶圆扣账时报错查询DW数据完善报错内容

  private String matnr;

  private String ersda;

  private String mtart;

  private String matkl;

  private String zzkhdm;

  private String zzhtxh;

  private String zzfhfs;

  private String zzbasesomo;

  public WaferDeductionProduct() {
  }

  public WaferDeductionProduct(WaferDeductionProduct data) {
    this.matnr = data.matnr;
    this.ersda = data.ersda;
    this.mtart = data.mtart;
    this.matkl = data.matkl;
    this.zzkhdm = data.zzkhdm;
    this.zzhtxh = data.zzhtxh;
    this.zzfhfs = data.zzfhfs;
    this.zzbasesomo = data.zzbasesomo;
  }

  public String getMatnr() {
    return matnr;
  }

  public void setMatnr(String matnr) {
    this.matnr = matnr;
  }

  public String getErsda() {
    return ersda;
  }

  public void setErsda(String ersda) {
    this.ersda = ersda;
  }

  public String getMtart() {
    return mtart;
  }

  public void setMtart(String mtart) {
    this.mtart = mtart;
  }

  public String getMatkl() {
    return matkl;
  }

  public void setMatkl(String matkl) {
    this.matkl = matkl;
  }

  public String getZzkhdm() {
    return zzkhdm;
  }

  public void setZzkhdm(String zzkhdm) {
    this.zzkhdm = zzkhdm;
  }

  public String getZzhtxh() {
    return zzhtxh;
  }

  public void setZzhtxh(String zzhtxh) {
    this.zzhtxh = zzhtxh;
  }

  public String getZzfhfs() {
    return zzfhfs;
  }

  public void setZzfhfs(String zzfhfs) {
    this.zzfhfs = zzfhfs;
  }

  public String getZzbasesomo() {
    return zzbasesomo;
  }

  public void setZzbasesomo(String zzbasesomo) {
    this.zzbasesomo = zzbasesomo;
  }

  @Override
  public WaferDeductionProduct clone() {
    return new WaferDeductionProduct(this);
  }


}
