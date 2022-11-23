package ame.psb.db;

import java.util.Date;

public class PkgPackingPlan {

  private String id;

  private String itemGroupBo;

  private String operationBo;

  private String packingType;

  private String goodBad;

  private String goodTypes;

  private String badTypes;

  private int maxQty;
  private int minQty;


  private String goodBadTypeRef;

  private String prevOperationBo;

  private String updatedUser;

  private Date updatedTime;

  private String state;

  public PkgPackingPlan() {
    this.state = "Y";
  }

  public PkgPackingPlan(PkgPackingPlan data) {
    this.id = data.id;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.packingType = data.packingType;
    this.goodBad = data.goodBad;
    this.goodTypes = data.goodTypes;
    this.badTypes = data.badTypes;
    this.maxQty = data.maxQty;
    this.minQty = data.minQty;

    this.goodBadTypeRef = data.goodBadTypeRef;
    this.prevOperationBo = data.prevOperationBo;
    this.state = data.state;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public int getMinQty() {
    return minQty;
  }

  public void setMinQty(int minQty) {
    this.minQty = minQty;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getPackingType() {
    return this.packingType;
  }

  public void setPackingType(String packingType) {
    this.packingType = packingType;
  }

  public String getGoodBad() {
    return this.goodBad;
  }

  public void setGoodBad(String goodBad) {
    this.goodBad = goodBad;
  }

  public String getGoodTypes() {
    return this.goodTypes;
  }

  public void setGoodTypes(String goodTypes) {
    this.goodTypes = goodTypes;
  }

  public String getBadTypes() {
    return this.badTypes;
  }

  public void setBadTypes(String badTypes) {
    this.badTypes = badTypes;
  }

  public int getMaxQty() {
    return this.maxQty;
  }

  public void setMaxQty(int maxQty) {
    this.maxQty = maxQty;
  }

  public String getGoodBadTypeRef() {
    return this.goodBadTypeRef;
  }

  public void setGoodBadTypeRef(String goodBadTypeRef) {
    this.goodBadTypeRef = goodBadTypeRef;
  }

  public String getPrevOperationBo() {
    return this.prevOperationBo;
  }

  public void setPrevOperationBo(String prevOperationBo) {
    this.prevOperationBo = prevOperationBo;
  }

  public String getUpdatedUser() {
    return this.updatedUser;
  }

  public void setUpdatedUser(String updatedUser) {
    this.updatedUser = updatedUser;
  }

  public Date getUpdatedTime() {
    return this.updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public PkgPackingPlan clone() {
    return new PkgPackingPlan(this);
  }

  @Override
  public String toString() {
    return this.id + "[" + this.goodTypes + "," + this.badTypes + "] qty:" + this.maxQty + ", G/B:"
        + this.goodBad + ", packing:" + this.goodBadTypeRef;
  }

  public String value() {
    return "[" + ","  + "] qty:" + this.maxQty + ", G/B:"
        + this.goodBad + ", packing:" + this.goodBadTypeRef;
  }


}
