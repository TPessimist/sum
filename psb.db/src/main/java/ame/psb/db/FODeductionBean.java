package ame.psb.db;

import java.math.BigDecimal;

public class FODeductionBean { //FO扣账时报错查询DW数据完善报错内容

  private String matnr; //物料

  private String charg; //批次

  private String zwafer_lot; //lot

  private String zwafer_id; //wafer

  private String lgort; //仓位

  private String zbin_no; //bin级

  private BigDecimal zgross_die_qty; //总数量

  private BigDecimal zdie_qty; //总良品数量

  private BigDecimal zdie_qty_gi; //已扣数量

  private BigDecimal qty; //剩余可扣数量

  private String lifnr; //LIFNR

  private String insmk; //INSMK

  public FODeductionBean() {
  }

  public FODeductionBean(FODeductionBean data) {
    this.matnr = data.matnr;
    this.charg = data.charg;
    this.zwafer_lot = data.zwafer_lot;
    this.zwafer_id = data.zwafer_id;
    this.lgort = data.lgort;
    this.zbin_no = data.zbin_no;
    this.zgross_die_qty = data.zgross_die_qty;
    this.zdie_qty = data.zdie_qty;
    this.zdie_qty_gi = data.zdie_qty_gi;
    this.qty = data.qty;
    this.lifnr = data.lifnr;
    this.insmk = data.insmk;
  }

  public String getMatnr() {
    return matnr;
  }

  public void setMatnr(String matnr) {
    this.matnr = matnr;
  }

  public String getCharg() {
    return charg;
  }

  public void setCharg(String charg) {
    this.charg = charg;
  }

  public String getZwafer_lot() {
    return zwafer_lot;
  }

  public void setZwafer_lot(String zwafer_lot) {
    this.zwafer_lot = zwafer_lot;
  }

  public String getZwafer_id() {
    return zwafer_id;
  }

  public void setZwafer_id(String zwafer_id) {
    this.zwafer_id = zwafer_id;
  }

  public String getLgort() {
    return lgort;
  }

  public void setLgort(String lgort) {
    this.lgort = lgort;
  }

  public String getZbin_no() {
    return zbin_no;
  }

  public void setZbin_no(String zbin_no) {
    this.zbin_no = zbin_no;
  }

  public BigDecimal getZgross_die_qty() {
    return zgross_die_qty;
  }

  public void setZgross_die_qty(BigDecimal zgross_die_qty) {
    this.zgross_die_qty = zgross_die_qty;
  }

  public BigDecimal getZdie_qty() {
    return zdie_qty;
  }

  public void setZdie_qty(BigDecimal zdie_qty) {
    this.zdie_qty = zdie_qty;
  }

  public BigDecimal getZdie_qty_gi() {
    return zdie_qty_gi;
  }

  public void setZdie_qty_gi(BigDecimal zdie_qty_gi) {
    this.zdie_qty_gi = zdie_qty_gi;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public String getLifnr() {
    return lifnr;
  }

  public void setLifnr(String lifnr) {
    this.lifnr = lifnr;
  }

  public String getInsmk() {
    return insmk;
  }

  public void setInsmk(String insmk) {
    this.insmk = insmk;
  }

  @Override
  public FODeductionBean clone() {
    return new FODeductionBean(this);
  }


}
