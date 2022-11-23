package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class PkgReel {

  private String uuid;

  private String id;

  private String type;

  private String customerItemName;

  private BigDecimal reelSeq;

  private String gradeId;

  private String goodBad;

  private BigDecimal dieQty;

  private String labelInfo;

  private String memo;

  private String updatedUser;

  private Date updatedTime;

  private BigDecimal seq;

  private String shopOrderBo;

  private String remarks;

  private String customerResult;

  private String resourceRelease;

  private String manualRelease;

  public PkgReel() {
    this.uuid = UUID.randomUUID().toString();
    this.updatedTime = new Date();
  }

  public PkgReel(PkgReel data) {
    this.uuid = data.uuid;
    this.id = data.id;
    this.type = data.type;
    this.customerItemName = data.customerItemName;
    this.reelSeq = data.reelSeq;
    this.gradeId = data.gradeId;
    this.goodBad = data.goodBad;
    this.dieQty = data.dieQty;
    this.labelInfo = data.labelInfo;
    this.memo = data.memo;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
    this.shopOrderBo = data.shopOrderBo;
    this.remarks = data.remarks;
    this.resourceRelease = data.resourceRelease;
    this.manualRelease = data.manualRelease;
  }

  public String getCustomerResult() {
    return customerResult;
  }

  public void setCustomerResult(String customerResult) {
    this.customerResult = customerResult;
  }

  public String getShopOrderBo() {
    return shopOrderBo;
  }

  public void setShopOrderBo(String shopOrderBo) {
    this.shopOrderBo = shopOrderBo;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getCustomerItemName() {
    return customerItemName;
  }

  public void setCustomerItemName(String customerItemName) {
    this.customerItemName = customerItemName;
  }

  public BigDecimal getReelSeq() {
    return reelSeq;
  }

  public void setReelSeq(BigDecimal reelSeq) {
    this.reelSeq = reelSeq;
  }

  public int getIntReelSeq() {
    return reelSeq.intValue();
  }

  public String getGradeId() {
    return gradeId;
  }

  public void setGradeId(String gradeId) {
    this.gradeId = gradeId;
  }

  public String getGoodBad() {
    return goodBad;
  }

  public void setGoodBad(String goodBad) {
    this.goodBad = goodBad;
  }

  public int getDieQty() {
    return dieQty.intValue();
  }

  public void setDieQty(BigDecimal dieQty) {
    this.dieQty = dieQty;
  }

  public String getLabelInfo() {
    return labelInfo;
  }

  public void setLabelInfo(String labelInfo) {
    this.labelInfo = labelInfo;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String getUpdatedUser() {
    return updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public BigDecimal getSeq() {
    return seq;
  }

  public void setSeq(BigDecimal seq) {
    this.seq = seq;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getResourceRelease() {
    return resourceRelease;
  }

  public void setResourceRelease(String resourceRelease) {
    this.resourceRelease = resourceRelease;
  }

  public String getManualRelease() {
    return manualRelease;
  }

  public void setManualRelease(String manualRelease) {
    this.manualRelease = manualRelease;
  }

  @Override
  public PkgReel clone() {
    return new PkgReel(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }
}
