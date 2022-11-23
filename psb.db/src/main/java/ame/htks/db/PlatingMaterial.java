package ame.htks.db;

import java.math.BigDecimal;
import java.util.Date;

public class PlatingMaterial {

  private String resourceBo;

  private String itemBo;

  private String desc;

  private BigDecimal qty;

  private String seq;

  private String demo;

  private Date updateTime;

  private String updateUser;


  public PlatingMaterial() {
  }

  public PlatingMaterial(PlatingMaterial data) {
    this.resourceBo = data.resourceBo;
    this.itemBo = data.itemBo;
    this.desc = data.desc;
    this.qty = data.qty;
    this.seq = data.seq;
    this.demo = data.demo;
    this.updateTime = data.updateTime;
    this.updateUser = data.updateUser;
  }

  @Override
  public PlatingMaterial clone() {
    return new PlatingMaterial(this);
  }

  @Override
  public String toString() {
    return this.resourceBo + ", " + this.itemBo;
  }

  public String getResourceBo() {
    return resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }

  public String getSeq() {
    return seq;
  }

  public void setSeq(String seq) {
    this.seq = seq;
  }

  public String getDemo() {
    return demo;
  }

  public void setDemo(String demo) {
    this.demo = demo;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(String updateUser) {
    this.updateUser = updateUser;
  }


}