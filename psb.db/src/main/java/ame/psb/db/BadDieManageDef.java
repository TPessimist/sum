package ame.psb.db;

import java.util.Date;
import java.util.UUID;

public class BadDieManageDef {

  private String id;

  private String binmapRuleBo;

  private String deffectCode;

  private String nonRecyclable;

  private String updatedUser;

  private Date updatedTime;


  public BadDieManageDef() {
    this.id = UUID.randomUUID().toString();
  }

  public BadDieManageDef(BadDieManageDef data) {
    this.id = data.id;
    this.binmapRuleBo = data.binmapRuleBo;
    this.deffectCode = data.deffectCode;
    this.nonRecyclable = data.nonRecyclable;
    this.updatedUser = data.updatedUser;
    this.updatedTime = data.updatedTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getBinmapRuleBo() {
    return binmapRuleBo;
  }

  public void setBinmapRuleBo(String binmapRuleBo) {
    this.binmapRuleBo = binmapRuleBo;
  }

  public String getDeffectCode() {
    return deffectCode;
  }

  public void setDeffectCode(String deffectCode) {
    this.deffectCode = deffectCode;
  }

  public String getNonRecyclable() {
    return nonRecyclable;
  }

  public void setNonRecyclable(String nonRecyclable) {
    this.nonRecyclable = nonRecyclable;
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

  @Override
  public BadDieManageDef clone() {
    return new BadDieManageDef(this);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
