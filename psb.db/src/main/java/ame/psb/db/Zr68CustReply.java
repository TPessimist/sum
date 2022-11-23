package ame.psb.db;

import java.util.Date;

public class Zr68CustReply {

  private String testHouse;

  private String productName;

  private String mpsLotId;

  private String lotId;

  private String revision;

  private String currentStage;

  private String category;

  private String disposition;

  private String stageToRetest;

  private String stageToReholdPte;

  private String stageToReholdPye;

  private String creater;

  private Date createTime;


  public Zr68CustReply() {
  }

  public Zr68CustReply(Zr68CustReply data) {
    this.testHouse = data.testHouse;
    this.productName = data.productName;
    this.mpsLotId = data.mpsLotId;
    this.lotId = data.lotId;
    this.revision = data.revision;
    this.currentStage = data.currentStage;
    this.category = data.category;
    this.disposition = data.disposition;
    this.stageToRetest = data.stageToRetest;
    this.stageToReholdPte = data.stageToReholdPte;
    this.stageToReholdPye = data.stageToReholdPye;
    this.creater = data.creater;
    this.createTime = data.createTime;
  }

  @Override
  public Zr68CustReply clone() {
    return new Zr68CustReply(this);
  }

  @Override
  public String toString() {
    return this.testHouse;
  }

  public String getTestHouse() {
    return testHouse;
  }

  public void setTestHouse(String testHouse) {
    this.testHouse = testHouse;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getMpsLotId() {
    return mpsLotId;
  }

  public void setMpsLotId(String mpsLotId) {
    this.mpsLotId = mpsLotId;
  }

  public String getLotId() {
    return lotId;
  }

  public void setLotId(String lotId) {
    this.lotId = lotId;
  }

  public String getRevision() {
    return revision;
  }

  public void setRevision(String revision) {
    this.revision = revision;
  }

  public String getCurrentStage() {
    return currentStage;
  }

  public void setCurrentStage(String currentStage) {
    this.currentStage = currentStage;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDisposition() {
    return disposition;
  }

  public void setDisposition(String disposition) {
    this.disposition = disposition;
  }

  public String getStageToRetest() {
    return stageToRetest;
  }

  public void setStageToRetest(String stageToRetest) {
    this.stageToRetest = stageToRetest;
  }

  public String getStageToReholdPte() {
    return stageToReholdPte;
  }

  public void setStageToReholdPte(String stageToReholdPte) {
    this.stageToReholdPte = stageToReholdPte;
  }

  public String getStageToReholdPye() {
    return stageToReholdPye;
  }

  public void setStageToReholdPye(String stageToReholdPye) {
    this.stageToReholdPye = stageToReholdPye;
  }

  public String getCreater() {
    return creater;
  }

  public void setCreater(String creater) {
    this.creater = creater;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
