package ame.psb.db;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class ViewPackage {

  private String handle;

  private Integer changeStamp;

  private String site;

  private String itemGroup;

  private String description;

  private String routerBo;

  private String bomBo;

  private String maskGroupBo;

  private Date createdDateTime;

  private Date modifiedDateTime;

  public String getHandle() {
    return this.handle;
  }

  public void setHandle(String handle) {
    this.handle = handle;
  }

  public Integer getChangeStamp() {
    return this.changeStamp;
  }

  public void setChangeStamp(Integer changeStamp) {
    this.changeStamp = changeStamp;
  }

  public String getSite() {
    return this.site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getItemGroup() {
    return this.itemGroup;
  }

  public void setItemGroup(String itemGroup) {
    this.itemGroup = itemGroup;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getRouterBo() {
    return this.routerBo;
  }

  public void setRouterBo(String routerBo) {
    this.routerBo = routerBo;
  }

  public String getBomBo() {
    return this.bomBo;
  }

  public void setBomBo(String bomBo) {
    this.bomBo = bomBo;
  }

  public String getMaskGroupBo() {
    return this.maskGroupBo;
  }

  public void setMaskGroupBo(String maskGroupBo) {
    this.maskGroupBo = maskGroupBo;
  }

  public Date getCreatedDateTime() {
    return this.createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  public Date getModifiedDateTime() {
    return this.modifiedDateTime;
  }

  public void setModifiedDateTime(Date modifiedDateTime) {
    this.modifiedDateTime = modifiedDateTime;
  }

  @Override
  public String toString() {
    return this.handle;
  }

}
