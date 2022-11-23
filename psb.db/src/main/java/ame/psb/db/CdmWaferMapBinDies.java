package ame.psb.db;

import java.util.Date;

/**
 * ykq
 */
public class CdmWaferMapBinDies {

  private String sourceType;

  private String waferId;

  private String waferGrossDies;

  private String waferGoodDies;

  private String waferNgDies;

  private String flag;

  private Date createDate;

  private String createBy;

  private String costCode;

  private String lotId;

  private String id;

  private String waferNo;

  private String mapPath;

  private String mesGrossDies;

  private String mesNGDies;

  private String mesGoodDies;

  public String getMesGrossDies() {
    return mesGrossDies;
  }

  public void setMesGrossDies(String mesGrossDies) {
    this.mesGrossDies = mesGrossDies;
  }

  public String getMesNGDies() {
    return mesNGDies;
  }

  public void setMesNGDies(String mesNGDies) {
    this.mesNGDies = mesNGDies;
  }

  public String getMesGoodDies() {
    return mesGoodDies;
  }

  public void setMesGoodDies(String mesGoodDies) {
    this.mesGoodDies = mesGoodDies;
  }

  public CdmWaferMapBinDies() {
  }

  public CdmWaferMapBinDies(CdmWaferMapBinDies data) {
    this.sourceType = data.sourceType;
    this.waferId = data.waferId;
    this.waferGrossDies = data.waferGrossDies;
    this.waferGoodDies = data.waferGoodDies;
    this.waferNgDies = data.waferNgDies;
    this.flag = data.flag;
    this.createDate = data.createDate;
    this.createBy = data.createBy;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getWaferNo() {
    return waferNo;
  }

  public void setWaferNo(String waferNo) {
    this.waferNo = waferNo;
  }

  public String getMapPath() {
    return mapPath;
  }

  public void setMapPath(String mapPath) {
    this.mapPath = mapPath;
  }

  public String getCostCode() {
    return costCode;
  }

  public void setCostCode(String costCode) {
    this.costCode = costCode;
  }

  public String getLotId() {
    return lotId;
  }

  public void setLotId(String lotId) {
    this.lotId = lotId;
  }

  public String getSourceType() {
    return sourceType;
  }

  public void setSourceType(String sourceType) {
    this.sourceType = sourceType;
  }

  public String getWaferId() {
    return waferId;
  }

  public void setWaferId(String waferId) {
    this.waferId = waferId;
  }

  public String getWaferGrossDies() {
    return waferGrossDies;
  }

  public void setWaferGrossDies(String waferGrossDies) {
    this.waferGrossDies = waferGrossDies;
  }

  public String getWaferGoodDies() {
    return waferGoodDies;
  }

  public void setWaferGoodDies(String waferGoodDies) {
    this.waferGoodDies = waferGoodDies;
  }

  public String getWaferNgDies() {
    return waferNgDies;
  }

  public void setWaferNgDies(String waferNgDies) {
    this.waferNgDies = waferNgDies;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
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

  @Override
  public CdmWaferMapBinDies clone() {
    return new CdmWaferMapBinDies(this);
  }

  @Override
  public String toString() {
    return this.waferId;
  }
}
