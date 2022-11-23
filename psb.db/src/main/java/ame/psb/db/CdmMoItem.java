package ame.psb.db;

public class CdmMoItem {

  private String moId;

  private String moItem;

  private String lotId;

  private String waferId;

  private String lotWaferId;

  private String waferSn;

  private String grossDieQty;

  private String goodDieQty;

  private String ngDieQty;

  private String markCode;

  private String flag;

  private String flag2;

  private String remark;

  private String remark2;

  private String remark3;

  private String remark4;

  private String remark5;

  private String id;


  public CdmMoItem() {
  }

  public CdmMoItem(CdmMoItem data) {
    this.moId = data.moId;
    this.moItem = data.moItem;
    this.lotId = data.lotId;
    this.waferId = data.waferId;
    this.lotWaferId = data.lotWaferId;
    this.waferSn = data.waferSn;
    this.grossDieQty = data.grossDieQty;
    this.goodDieQty = data.goodDieQty;
    this.ngDieQty = data.ngDieQty;
    this.markCode = data.markCode;
    this.flag = data.flag;
    this.flag2 = data.flag2;
    this.remark = data.remark;
    this.remark2 = data.remark2;
    this.remark3 = data.remark3;
    this.remark4 = data.remark4;
    this.remark5 = data.remark5;
    this.id = data.id;
  }

  @Override
  public CdmMoItem clone() {
    return new CdmMoItem(this);
  }

  @Override
  public String toString() {
    return this.moId;
  }

  public String getMoId() {
    return moId;
  }

  public void setMoId(String moId) {
    this.moId = moId;
  }

  public String getMoItem() {
    return moItem;
  }

  public void setMoItem(String moItem) {
    this.moItem = moItem;
  }

  public String getLotId() {
    return lotId;
  }

  public void setLotId(String lotId) {
    this.lotId = lotId;
  }

  public String getWaferId() {
    return waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
  }

  public String getLotWaferId() {
    return lotWaferId;
  }

  public void setLotWaferId(String lotWaferId) {
    this.lotWaferId = lotWaferId;
  }

  public String getWaferSn() {
    return waferSn;
  }

  public void setWaferSn(String waferSn) {
    this.waferSn = waferSn;
  }

  public String getGrossDieQty() {
    return grossDieQty;
  }

  public void setGrossDieQty(String grossDieQty) {
    this.grossDieQty = grossDieQty;
  }

  public String getGoodDieQty() {
    return goodDieQty;
  }

  public void setGoodDieQty(String goodDieQty) {
    this.goodDieQty = goodDieQty;
  }

  public String getNgDieQty() {
    return ngDieQty;
  }

  public void setNgDieQty(String ngDieQty) {
    this.ngDieQty = ngDieQty;
  }

  public String getMarkCode() {
    return markCode;
  }

  public void setMarkCode(String markCode) {
    this.markCode = markCode;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getFlag2() {
    return flag2;
  }

  public void setFlag2(String flag2) {
    this.flag2 = flag2;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getRemark2() {
    return remark2;
  }

  public void setRemark2(String remark2) {
    this.remark2 = remark2;
  }

  public String getRemark3() {
    return remark3;
  }

  public void setRemark3(String remark3) {
    this.remark3 = remark3;
  }

  public String getRemark4() {
    return remark4;
  }

  public void setRemark4(String remark4) {
    this.remark4 = remark4;
  }

  public String getRemark5() {
    return remark5;
  }

  public void setRemark5(String remark5) {
    this.remark5 = remark5;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
