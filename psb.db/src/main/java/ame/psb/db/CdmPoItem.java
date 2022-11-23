package ame.psb.db;

import java.util.Date;

public class CdmPoItem {

  private String custCode;

  private String sapCustCode;

  private String tradCustCode;

  private String poId;

  private String poType;

  private String poDate;

  private String bonded;

  private String customerDevice;

  private String fabDevice;

  private String custFabDevice1;

  private String custFabDevice2;

  private String htPn;

  private String productPn;

  private String sapProductPn;

  private String lotId;

  private String waferId;

  private String lotWaferId;

  private String passbinCount;

  private String failbinCount;

  private String markCode;

  private String add0;

  private String add1;

  private String add2;

  private String add3;

  private String add4;

  private String add5;

  private String add6;

  private String add7;

  private String add8;

  private String add9;

  private String add10;

  private String cdmId;

  private String cdmItem;

  private String soId;

  private String soItem;

  private String moId;

  private String moItem;

  private String flag;

  private String flag2;

  private String flag3;

  private Date createDate;

  private String createBy;

  private Date updateDate;

  private String updateBy;

  private String waferTimes;

  private String uploadId;

  private String waferSn;

  private String id;

  private String waferPcsPrice;

  private String waferDiePrice;

  private String waferHold;

  private String add11;

  private String add12;

  private String add13;

  private String add14;

  private String add15;

  private String add16;

  private String add17;

  private String add18;

  private String add19;

  private String add20;

  private String add21;

  private String add22;

  private String add23;

  private String add24;

  private String add25;

  private String add26;

  private String add27;

  private String add28;

  private String add29;

  private String add30;

  private String addressCode;

  private String baseSo;

  private String status;

  private String remark1;

  private String remark2;

  private String remark3;

  private String poH;

  private String flag4;

  private String flag5;

  private String remakr4;

  private String remakr5;


  public CdmPoItem() {
  }

  public CdmPoItem(CdmPoItem data) {
    this.custCode = data.custCode;
    this.sapCustCode = data.sapCustCode;
    this.tradCustCode = data.tradCustCode;
    this.poId = data.poId;
    this.poType = data.poType;
    this.poDate = data.poDate;
    this.bonded = data.bonded;
    this.customerDevice = data.customerDevice;
    this.fabDevice = data.fabDevice;
    this.custFabDevice1 = data.custFabDevice1;
    this.custFabDevice2 = data.custFabDevice2;
    this.htPn = data.htPn;
    this.productPn = data.productPn;
    this.sapProductPn = data.sapProductPn;
    this.lotId = data.lotId;
    this.waferId = data.waferId;
    this.lotWaferId = data.lotWaferId;
    this.passbinCount = data.passbinCount;
    this.failbinCount = data.failbinCount;
    this.markCode = data.markCode;
    this.add0 = data.add0;
    this.add1 = data.add1;
    this.add2 = data.add2;
    this.add3 = data.add3;
    this.add4 = data.add4;
    this.add5 = data.add5;
    this.add6 = data.add6;
    this.add7 = data.add7;
    this.add8 = data.add8;
    this.add9 = data.add9;
    this.add10 = data.add10;
    this.cdmId = data.cdmId;
    this.cdmItem = data.cdmItem;
    this.soId = data.soId;
    this.soItem = data.soItem;
    this.moId = data.moId;
    this.moItem = data.moItem;
    this.flag = data.flag;
    this.flag2 = data.flag2;
    this.flag3 = data.flag3;
    this.createDate = data.createDate;
    this.createBy = data.createBy;
    this.updateDate = data.updateDate;
    this.updateBy = data.updateBy;
    this.waferTimes = data.waferTimes;
    this.uploadId = data.uploadId;
    this.waferSn = data.waferSn;
    this.id = data.id;
    this.waferPcsPrice = data.waferPcsPrice;
    this.waferDiePrice = data.waferDiePrice;
    this.waferHold = data.waferHold;
    this.add11 = data.add11;
    this.add12 = data.add12;
    this.add13 = data.add13;
    this.add14 = data.add14;
    this.add15 = data.add15;
    this.add16 = data.add16;
    this.add17 = data.add17;
    this.add18 = data.add18;
    this.add19 = data.add19;
    this.add20 = data.add20;
    this.add21 = data.add21;
    this.add22 = data.add22;
    this.add23 = data.add23;
    this.add24 = data.add24;
    this.add25 = data.add25;
    this.add26 = data.add26;
    this.add27 = data.add27;
    this.add28 = data.add28;
    this.add29 = data.add29;
    this.add30 = data.add30;
    this.addressCode = data.addressCode;
    this.baseSo = data.baseSo;
    this.status = data.status;
    this.remark1 = data.remark1;
    this.remark2 = data.remark2;
    this.remark3 = data.remark3;
    this.poH = data.poH;
    this.flag4 = data.flag4;
    this.flag5 = data.flag5;
    this.remakr4 = data.remakr4;
    this.remakr5 = data.remakr5;
  }

  @Override
  public CdmPoItem clone() {
    return new CdmPoItem(this);
  }

  @Override
  public String toString() {
    return this.waferSn;
  }

  public String getCustCode() {
    return custCode;
  }

  public void setCustCode(String custCode) {
    this.custCode = custCode;
  }

  public String getSapCustCode() {
    return sapCustCode;
  }

  public void setSapCustCode(String sapCustCode) {
    this.sapCustCode = sapCustCode;
  }

  public String getTradCustCode() {
    return tradCustCode;
  }

  public void setTradCustCode(String tradCustCode) {
    this.tradCustCode = tradCustCode;
  }

  public String getPoId() {
    return poId;
  }

  public void setPoId(String poId) {
    this.poId = poId;
  }

  public String getPoType() {
    return poType;
  }

  public void setPoType(String poType) {
    this.poType = poType;
  }

  public String getPoDate() {
    return poDate;
  }

  public void setPoDate(String poDate) {
    this.poDate = poDate;
  }

  public String getBonded() {
    return bonded;
  }

  public void setBonded(String bonded) {
    this.bonded = bonded;
  }

  public String getCustomerDevice() {
    return customerDevice;
  }

  public void setCustomerDevice(String customerDevice) {
    this.customerDevice = customerDevice;
  }

  public String getFabDevice() {
    return fabDevice;
  }

  public void setFabDevice(String fabDevice) {
    this.fabDevice = fabDevice;
  }

  public String getCustFabDevice1() {
    return custFabDevice1;
  }

  public void setCustFabDevice1(String custFabDevice1) {
    this.custFabDevice1 = custFabDevice1;
  }

  public String getCustFabDevice2() {
    return custFabDevice2;
  }

  public void setCustFabDevice2(String custFabDevice2) {
    this.custFabDevice2 = custFabDevice2;
  }

  public String getHtPn() {
    return htPn;
  }

  public void setHtPn(String htPn) {
    this.htPn = htPn;
  }

  public String getProductPn() {
    return productPn;
  }

  public void setProductPn(String productPn) {
    this.productPn = productPn;
  }

  public String getSapProductPn() {
    return sapProductPn;
  }

  public void setSapProductPn(String sapProductPn) {
    this.sapProductPn = sapProductPn;
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

  public String getPassbinCount() {
    return passbinCount;
  }

  public void setPassbinCount(String passbinCount) {
    this.passbinCount = passbinCount;
  }

  public String getFailbinCount() {
    return failbinCount;
  }

  public void setFailbinCount(String failbinCount) {
    this.failbinCount = failbinCount;
  }

  public String getMarkCode() {
    return markCode;
  }

  public void setMarkCode(String markCode) {
    this.markCode = markCode;
  }

  public String getAdd0() {
    return add0;
  }

  public void setAdd0(String add0) {
    this.add0 = add0;
  }

  public String getAdd1() {
    return add1;
  }

  public void setAdd1(String add1) {
    this.add1 = add1;
  }

  public String getAdd2() {
    return add2;
  }

  public void setAdd2(String add2) {
    this.add2 = add2;
  }

  public String getAdd3() {
    return add3;
  }

  public void setAdd3(String add3) {
    this.add3 = add3;
  }

  public String getAdd4() {
    return add4;
  }

  public void setAdd4(String add4) {
    this.add4 = add4;
  }

  public String getAdd5() {
    return add5;
  }

  public void setAdd5(String add5) {
    this.add5 = add5;
  }

  public String getAdd6() {
    return add6;
  }

  public void setAdd6(String add6) {
    this.add6 = add6;
  }

  public String getAdd7() {
    return add7;
  }

  public void setAdd7(String add7) {
    this.add7 = add7;
  }

  public String getAdd8() {
    return add8;
  }

  public void setAdd8(String add8) {
    this.add8 = add8;
  }

  public String getAdd9() {
    return add9;
  }

  public void setAdd9(String add9) {
    this.add9 = add9;
  }

  public String getAdd10() {
    return add10;
  }

  public void setAdd10(String add10) {
    this.add10 = add10;
  }

  public String getCdmId() {
    return cdmId;
  }

  public void setCdmId(String cdmId) {
    this.cdmId = cdmId;
  }

  public String getCdmItem() {
    return cdmItem;
  }

  public void setCdmItem(String cdmItem) {
    this.cdmItem = cdmItem;
  }

  public String getSoId() {
    return soId;
  }

  public void setSoId(String soId) {
    this.soId = soId;
  }

  public String getSoItem() {
    return soItem;
  }

  public void setSoItem(String soItem) {
    this.soItem = soItem;
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

  public String getFlag3() {
    return flag3;
  }

  public void setFlag3(String flag3) {
    this.flag3 = flag3;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public String getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(String updateBy) {
    this.updateBy = updateBy;
  }

  public String getWaferTimes() {
    return waferTimes;
  }

  public void setWaferTimes(String waferTimes) {
    this.waferTimes = waferTimes;
  }

  public String getUploadId() {
    return uploadId;
  }

  public void setUploadId(String uploadId) {
    this.uploadId = uploadId;
  }

  public String getWaferSn() {
    return waferSn;
  }

  public void setWaferSn(String waferSn) {
    this.waferSn = waferSn;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getWaferPcsPrice() {
    return waferPcsPrice;
  }

  public void setWaferPcsPrice(String waferPcsPrice) {
    this.waferPcsPrice = waferPcsPrice;
  }

  public String getWaferDiePrice() {
    return waferDiePrice;
  }

  public void setWaferDiePrice(String waferDiePrice) {
    this.waferDiePrice = waferDiePrice;
  }

  public String getWaferHold() {
    return waferHold;
  }

  public void setWaferHold(String waferHold) {
    this.waferHold = waferHold;
  }

  public String getAdd11() {
    return add11;
  }

  public void setAdd11(String add11) {
    this.add11 = add11;
  }

  public String getAdd12() {
    return add12;
  }

  public void setAdd12(String add12) {
    this.add12 = add12;
  }

  public String getAdd13() {
    return add13;
  }

  public void setAdd13(String add13) {
    this.add13 = add13;
  }

  public String getAdd14() {
    return add14;
  }

  public void setAdd14(String add14) {
    this.add14 = add14;
  }

  public String getAdd15() {
    return add15;
  }

  public void setAdd15(String add15) {
    this.add15 = add15;
  }

  public String getAdd16() {
    return add16;
  }

  public void setAdd16(String add16) {
    this.add16 = add16;
  }

  public String getAdd17() {
    return add17;
  }

  public void setAdd17(String add17) {
    this.add17 = add17;
  }

  public String getAdd18() {
    return add18;
  }

  public void setAdd18(String add18) {
    this.add18 = add18;
  }

  public String getAdd19() {
    return add19;
  }

  public void setAdd19(String add19) {
    this.add19 = add19;
  }

  public String getAdd20() {
    return add20;
  }

  public void setAdd20(String add20) {
    this.add20 = add20;
  }

  public String getAdd21() {
    return add21;
  }

  public void setAdd21(String add21) {
    this.add21 = add21;
  }

  public String getAdd22() {
    return add22;
  }

  public void setAdd22(String add22) {
    this.add22 = add22;
  }

  public String getAdd23() {
    return add23;
  }

  public void setAdd23(String add23) {
    this.add23 = add23;
  }

  public String getAdd24() {
    return add24;
  }

  public void setAdd24(String add24) {
    this.add24 = add24;
  }

  public String getAdd25() {
    return add25;
  }

  public void setAdd25(String add25) {
    this.add25 = add25;
  }

  public String getAdd26() {
    return add26;
  }

  public void setAdd26(String add26) {
    this.add26 = add26;
  }

  public String getAdd27() {
    return add27;
  }

  public void setAdd27(String add27) {
    this.add27 = add27;
  }

  public String getAdd28() {
    return add28;
  }

  public void setAdd28(String add28) {
    this.add28 = add28;
  }

  public String getAdd29() {
    return add29;
  }

  public void setAdd29(String add29) {
    this.add29 = add29;
  }

  public String getAdd30() {
    return add30;
  }

  public void setAdd30(String add30) {
    this.add30 = add30;
  }

  public String getAddressCode() {
    return addressCode;
  }

  public void setAddressCode(String addressCode) {
    this.addressCode = addressCode;
  }

  public String getBaseSo() {
    return baseSo;
  }

  public void setBaseSo(String baseSo) {
    this.baseSo = baseSo;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getRemark1() {
    return remark1;
  }

  public void setRemark1(String remark1) {
    this.remark1 = remark1;
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

  public String getPoH() {
    return poH;
  }

  public void setPoH(String poH) {
    this.poH = poH;
  }

  public String getFlag4() {
    return flag4;
  }

  public void setFlag4(String flag4) {
    this.flag4 = flag4;
  }

  public String getFlag5() {
    return flag5;
  }

  public void setFlag5(String flag5) {
    this.flag5 = flag5;
  }

  public String getRemakr4() {
    return remakr4;
  }

  public void setRemakr4(String remakr4) {
    this.remakr4 = remakr4;
  }

  public String getRemakr5() {
    return remakr5;
  }

  public void setRemakr5(String remakr5) {
    this.remakr5 = remakr5;
  }
}
