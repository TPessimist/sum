package ame.psb.db;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;

@Entity
public class SfcMemo {

  private String id;

  private String sfcBo;

  private String sfc;

  private Date createdTime;

  private String owner;

  private String memo;

  private Date expiredTime;

  public SfcMemo() {
    this.id = System.currentTimeMillis() + "::" + UUID.randomUUID().toString();
    this.createdTime = new Date();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getSfc() {
    return this.sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public Date getCreatedTime() {
    return this.createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public String getOwner() {
    return this.owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public Date getExpiredTime() {
    return this.expiredTime;
  }

  public void setExpiredTime(Date expiredTime) {
    this.expiredTime = expiredTime;
  }

}
