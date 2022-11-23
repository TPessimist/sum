package ame.psb.db;

import java.math.BigDecimal;

public class RmsRecipeEquipment {

  private BigDecimal objectRrn;

  private BigDecimal orgRrn;

  private String isActive;

  private String created;

  private String createdBy;

  private String updated;

  private String updatedBy;

  private BigDecimal lockVersion;

  private String recipeName;

  private String equipmentId;

  private String programeId;

  private String checkSum;

  private String holdState;

  private BigDecimal stdProcessTime;

  private BigDecimal version;

  private String status;

  private String activeTime;

  private String activeUser;

  private BigDecimal recipeType;

  private String compareFlag;

  private String body;

  private String timestamp;

  private BigDecimal levelNumber;


  public RmsRecipeEquipment() {
  }

  public RmsRecipeEquipment(RmsRecipeEquipment data) {
    this.objectRrn = data.objectRrn;
    this.orgRrn = data.orgRrn;
    this.isActive = data.isActive;
    this.created = data.created;
    this.createdBy = data.createdBy;
    this.updated = data.updated;
    this.updatedBy = data.updatedBy;
    this.lockVersion = data.lockVersion;
    this.recipeName = data.recipeName;
    this.equipmentId = data.equipmentId;
    this.programeId = data.programeId;
    this.checkSum = data.checkSum;
    this.holdState = data.holdState;
    this.stdProcessTime = data.stdProcessTime;
    this.version = data.version;
    this.status = data.status;
    this.activeTime = data.activeTime;
    this.activeUser = data.activeUser;
    this.recipeType = data.recipeType;
    this.compareFlag = data.compareFlag;
    this.body = data.body;
    this.timestamp = data.timestamp;
    this.levelNumber = data.levelNumber;
  }

  @Override
  public RmsRecipeEquipment clone() {
    return new RmsRecipeEquipment(this);
  }

  @Override
  public String toString() {
    return this.objectRrn.toString() + "::" + this.equipmentId + "::" + this.recipeName + "::"
        + this.status;
  }

  public BigDecimal getObjectRrn() {
    return this.objectRrn;
  }

  public void setObjectRrn(BigDecimal objectRrn) {
    this.objectRrn = objectRrn;
  }

  public BigDecimal getOrgRrn() {
    return this.orgRrn;
  }

  public void setOrgRrn(BigDecimal orgRrn) {
    this.orgRrn = orgRrn;
  }

  public String getIsActive() {
    return this.isActive;
  }

  public void setIsActive(String isActive) {
    this.isActive = isActive;
  }

  public String getCreated() {
    return this.created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getUpdated() {
    return this.updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public String getUpdatedBy() {
    return this.updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public BigDecimal getLockVersion() {
    return this.lockVersion;
  }

  public void setLockVersion(BigDecimal lockVersion) {
    this.lockVersion = lockVersion;
  }

  public String getRecipeName() {
    return this.recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public String getEquipmentId() {
    return this.equipmentId;
  }

  public void setEquipmentId(String equipmentId) {
    this.equipmentId = equipmentId;
  }

  public String getProgrameId() {
    return this.programeId;
  }

  public void setProgrameId(String programeId) {
    this.programeId = programeId;
  }

  public String getCheckSum() {
    return this.checkSum;
  }

  public void setCheckSum(String checkSum) {
    this.checkSum = checkSum;
  }

  public String getHoldState() {
    return this.holdState;
  }

  public void setHoldState(String holdState) {
    this.holdState = holdState;
  }

  public BigDecimal getStdProcessTime() {
    return this.stdProcessTime;
  }

  public void setStdProcessTime(BigDecimal stdProcessTime) {
    this.stdProcessTime = stdProcessTime;
  }

  public BigDecimal getVersion() {
    return this.version;
  }

  public void setVersion(BigDecimal version) {
    this.version = version;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getActiveTime() {
    return this.activeTime;
  }

  public void setActiveTime(String activeTime) {
    this.activeTime = activeTime;
  }

  public String getActiveUser() {
    return this.activeUser;
  }

  public void setActiveUser(String activeUser) {
    this.activeUser = activeUser;
  }

  public BigDecimal getRecipeType() {
    return this.recipeType;
  }

  public void setRecipeType(BigDecimal recipeType) {
    this.recipeType = recipeType;
  }

  public String getCompareFlag() {
    return this.compareFlag;
  }

  public void setCompareFlag(String compareFlag) {
    this.compareFlag = compareFlag;
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public BigDecimal getLevelNumber() {
    return this.levelNumber;
  }

  public void setLevelNumber(BigDecimal levelNumber) {
    this.levelNumber = levelNumber;
  }
}
