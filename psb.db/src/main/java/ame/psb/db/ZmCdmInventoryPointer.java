package ame.psb.db;

import java.util.Date;

public class ZmCdmInventoryPointer {

  private String mandt;

  private String zseq;

  private String werks;

  private String charg;

  private String matnr;

  private String zwaferLot;

  private String zwaferId;

  private String zoutBox;

  private String zbinNo;

  private String zbin;

  private String zdieQtyRm;

  private String zdieQtyGi;

  private String moId;

  private String moWaferId;

  private String moWaferSn;

  private String moFlag;

  private String id;

  private Date createDate;


  public ZmCdmInventoryPointer() {
  }

  public ZmCdmInventoryPointer(ZmCdmInventoryPointer data) {
    this.mandt = data.mandt;
    this.zseq = data.zseq;
    this.werks = data.werks;
    this.charg = data.charg;
    this.matnr = data.matnr;
    this.zwaferLot = data.zwaferLot;
    this.zwaferId = data.zwaferId;
    this.zoutBox = data.zoutBox;
    this.zbinNo = data.zbinNo;
    this.zbin = data.zbin;
    this.zdieQtyRm = data.zdieQtyRm;
    this.zdieQtyGi = data.zdieQtyGi;
    this.moId = data.moId;
    this.moWaferId = data.moWaferId;
    this.moWaferSn = data.moWaferSn;
    this.moFlag = data.moFlag;
    this.id = data.id;
    this.createDate = data.createDate;
  }

  @Override
  public ZmCdmInventoryPointer clone() {
    return new ZmCdmInventoryPointer(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getMandt() {
    return mandt;
  }

  public void setMandt(String mandt) {
    this.mandt = mandt;
  }

  public String getZseq() {
    return zseq;
  }

  public void setZseq(String zseq) {
    this.zseq = zseq;
  }

  public String getWerks() {
    return werks;
  }

  public void setWerks(String werks) {
    this.werks = werks;
  }

  public String getCharg() {
    return charg;
  }

  public void setCharg(String charg) {
    this.charg = charg;
  }

  public String getMatnr() {
    return matnr;
  }

  public void setMatnr(String matnr) {
    this.matnr = matnr;
  }

  public String getZwaferLot() {
    return zwaferLot;
  }

  public void setZwaferLot(String zwaferLot) {
    this.zwaferLot = zwaferLot;
  }

  public String getZwaferId() {
    return zwaferId;
  }

  public void setZwaferId(String zwaferId) {
    this.zwaferId = zwaferId;
  }

  public String getZoutBox() {
    return zoutBox;
  }

  public void setZoutBox(String zoutBox) {
    this.zoutBox = zoutBox;
  }

  public String getZbinNo() {
    return zbinNo;
  }

  public void setZbinNo(String zbinNo) {
    this.zbinNo = zbinNo;
  }

  public String getZbin() {
    return zbin;
  }

  public void setZbin(String zbin) {
    this.zbin = zbin;
  }

  public String getZdieQtyRm() {
    return zdieQtyRm;
  }

  public void setZdieQtyRm(String zdieQtyRm) {
    this.zdieQtyRm = zdieQtyRm;
  }

  public String getZdieQtyGi() {
    return zdieQtyGi;
  }

  public void setZdieQtyGi(String zdieQtyGi) {
    this.zdieQtyGi = zdieQtyGi;
  }

  public String getMoId() {
    return moId;
  }

  public void setMoId(String moId) {
    this.moId = moId;
  }

  public String getMoWaferId() {
    return moWaferId;
  }

  public void setMoWaferId(String moWaferId) {
    this.moWaferId = moWaferId;
  }

  public String getMoWaferSn() {
    return moWaferSn;
  }

  public void setMoWaferSn(String moWaferSn) {
    this.moWaferSn = moWaferSn;
  }

  public String getMoFlag() {
    return moFlag;
  }

  public void setMoFlag(String moFlag) {
    this.moFlag = moFlag;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
}
