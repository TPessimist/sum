package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class PkgReelEap {

  private String handle;

  private String equipmentId;

  private String reelId;

  private String waferId;

  private Integer reelSeq;

  private String pickBin;

  private String lot;

  private BigDecimal goodDie;

  private BigDecimal badDie;

  private String xml;

  private Date createdTime;

  private Integer waferSeq;

  private String containerBo;

  public PkgReelEap() {
    this.handle = UUID.randomUUID().toString();
    this.createdTime = new Date();
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public String getReelId() {
    return reelId;
  }

  public void setReelId(String reelId) {
    this.reelId = reelId;
  }

  public Integer getReelSeq() {
    return reelSeq;
  }

  public void setReelSeq(Integer reelSeq) {
    this.reelSeq = reelSeq;
  }

  public String getWaferId() {
    return waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
  }

  public String getPickBin() {
    return pickBin;
  }

  public void setPickBin(String pickBin) {
    this.pickBin = pickBin;
  }

  public String getLot() {
    return lot;
  }

  public void setLot(String lot) {
    this.lot = lot;
  }

  public BigDecimal getGoodDie() {
    return goodDie;
  }

  public void setGoodDie(BigDecimal goodDie) {
    this.goodDie = goodDie;
  }

  public BigDecimal getBadDie() {
    return badDie;
  }

  public void setBadDie(BigDecimal badDie) {
    this.badDie = badDie;
  }

  public String getXml() {
    return xml;
  }

  public void setXml(String xml) {
    this.xml = xml;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public String getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(String equipmentId) {
    this.equipmentId = equipmentId;
  }

  public Integer getWaferSeq() {
    return waferSeq;
  }

  public void setWaferSeq(Integer waferSeq) {
    this.waferSeq = waferSeq;
  }

  public String getContainerBo() {
    return containerBo;
  }

  public void setContainerBo(String containerBo) {
    this.containerBo = containerBo;
  }
}
