package ame.psb.db;

import java.util.Date;

public class GzcRecive {

  private String inventoryId;

  private String type;

  private String flag;

  private String charg;

  private String rsnum;

  private String content;

  private String value;

  private String updateUser;

  private Date updateTime;


  public GzcRecive() {
  }

  public GzcRecive(GzcRecive data) {
    this.inventoryId = data.inventoryId;
    this.type = data.type;
    this.flag = data.flag;
    this.charg = data.charg;
    this.rsnum = data.rsnum;
    this.content = data.content;
    this.value = data.value;
    this.updateUser = data.updateUser;
    this.updateTime = data.updateTime;
  }

  public String getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getCharg() {
    return charg;
  }

  public void setCharg(String charg) {
    this.charg = charg;
  }

  public String getRsnum() {
    return rsnum;
  }

  public void setRsnum(String rsnum) {
    this.rsnum = rsnum;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public GzcRecive clone() {
    return new GzcRecive(this);
  }

  @Override
  public String toString() {
    return this.inventoryId + ", " + this.type;
  }
}
