package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ItemGroup {

  private String handle;

  private BigDecimal changeStamp;

  private String site;

  private String itemGroup;

  private String description;

  private String routerBo;

  private String bomBo;

  private String maskGroupBo;

  private Date createdDateTime;

  private Date modifiedDateTime;

  public ItemGroup() {
  }

  public ItemGroup(ItemGroup data) {
    this.handle = data.handle;
    this.changeStamp = data.changeStamp;
    this.site = data.site;
    this.itemGroup = data.itemGroup;
    this.description = data.description;
    this.routerBo = data.routerBo;
    this.bomBo = data.bomBo;
    this.maskGroupBo = data.maskGroupBo;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
  }

  public String getHandle() {
    return handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public BigDecimal getChangeStamp() {
    return changeStamp;
  }

  public void setChangeStamp(BigDecimal changeStamp) {
    this.changeStamp = changeStamp;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getItemGroup() {
    return itemGroup;
  }

  public void setItemGroup(String itemGroup) {
    this.itemGroup = itemGroup;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRouterBo() {
    return routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getBomBo() {
    return bomBo;
  }

  public void setBomBo(String bomBo) {
    this.bomBo = bomBo;
  }

  public String getMaskGroupBo() {
    return maskGroupBo;
  }

  public void setMaskGroupBo(String maskGroupBo) {
    this.maskGroupBo = maskGroupBo;
  }

  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Date getModifiedDateTime() {
    return modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  @Override
  public ItemGroup clone() {
    return new ItemGroup(this);
  }

  @Override
  public String toString() {
    return this.handle;
  }
}
