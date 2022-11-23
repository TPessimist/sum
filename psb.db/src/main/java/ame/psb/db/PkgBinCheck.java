package ame.psb.db;

import java.util.Date;

public class PkgBinCheck { //数据表ZR_PKG_BINCHECK的实体类

  private String uuid; //随机主键

  private String lotid; //批次号

  private String reelid; //卷盘号

  private String gradeid; //bin级

  private String dieQty; //数量

  private String goodDie; //良品die数

  private String badDie; //不良die数

  private String recipe; //recipe号

  private String result; //校验结果

  private String personid; //校验人员编号

  private Date actionTime; //校验时间

  private String comment; //备用列一

  private String description; //备用列二

  private String value; //备用列三

  public PkgBinCheck() {
  }

  public PkgBinCheck(PkgBinCheck data) {
    this.uuid = data.uuid;
    this.lotid = data.lotid;
    this.reelid = data.reelid;
    this.gradeid = data.gradeid;
    this.dieQty = data.dieQty;
    this.goodDie = data.goodDie;
    this.badDie = data.badDie;
    this.recipe = data.recipe;
    this.result = data.result;
    this.personid = data.personid;
    this.actionTime = data.actionTime;
    this.comment = data.comment;
    this.description = data.description;
    this.value = data.value;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getLotid() {
    return lotid;
  }

  public void setLotid(String lotid) {
    this.lotid = lotid;
  }

  public String getReelid() {
    return reelid;
  }

  public void setReelid(String reelid) {
    this.reelid = reelid;
  }

  public String getGradeid() {
    return gradeid;
  }

  public void setGradeid(String gradeid) {
    this.gradeid = gradeid;
  }

  public String getDieQty() {
    return dieQty;
  }

  public void setDieQty(String dieQty) {
    this.dieQty = dieQty;
  }

  public String getGoodDie() {
    return goodDie;
  }

  public void setGoodDie(String goodDie) {
    this.goodDie = goodDie;
  }

  public String getBadDie() {
    return badDie;
  }

  public void setBadDie(String badDie) {
    this.badDie = badDie;
  }

  public String getRecipe() {
    return recipe;
  }

  public void setRecipe(String recipe) {
    this.recipe = recipe;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getPersonid() {
    return personid;
  }

  public void setPersonid(String personid) {
    this.personid = personid;
  }

  public Date getActionTime() {
    return actionTime;
  }

  public void setActionTime(Date actionTime) {
    this.actionTime = actionTime;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public PkgBinCheck clone() {
    return new PkgBinCheck(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }
}
