package ame.psb.db;

import java.util.Date;

public class BomCustomData {

  private String itemBo;

  private String attribute;

  private String bomBo;

  private String value;

  private String createdUser;

  private Date createdDateTime;

  private Date modifiedDateTime;


  public BomCustomData() {
  }

  public BomCustomData(BomCustomData data) {
    this.itemBo = data.itemBo;
    this.attribute = data.attribute;
    this.bomBo = data.bomBo;
    this.value = data.value;
    this.createdUser = data.createdUser;
    this.createdDateTime = data.createdDateTime;
    this.modifiedDateTime = data.modifiedDateTime;
  }


  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  public String getBomBo() {
    return bomBo;
  }

  public void setBomBo(String bomBo) {
    this.bomBo = bomBo;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getCreatedUser() {
    return createdUser;
  }

  public void setCreatedUser(String createdUser) {
    this.createdUser = createdUser;
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
  public BomCustomData clone() {
    return new BomCustomData(this);
  }

  @Override
  public String toString() {
    return this.itemBo + ", " + this.attribute + ", " + this.bomBo;
  }
}
