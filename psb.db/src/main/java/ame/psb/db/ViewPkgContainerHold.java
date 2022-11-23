package ame.psb.db;

import java.math.BigDecimal;
import java.util.Date;

public class ViewPkgContainerHold {

  private String id;

  private String containerName;

  private String packingPlanBo;

  private String itemGroupBo;

  private String operationBo;

  private String itemLevel;

  private String containerType;

  private String pkgContainerBo;

  private String currStep;

  private String stateName;

  private String customerItemsetBo;

  private String customerItemBo;

  private String itemBo;

  private String goodBad;

  private Date packingTime;

  private String itemName;

  private String operationName;

  private String packingUser;

  private BigDecimal goodDie;

  private BigDecimal badDie1;

  private BigDecimal badDie2;

  private String dnNo;

  private String containerSeqId;

  private String customerItemsetNames;

  private String customerItemNames;

  private String flagCustomerSpecialPackage;

  private String flagSplitByCustomerItemset;

  private String holdDetailBo;

  private String holdContextGBo;

  private String holdLogBo;

  private String holdStatus;

  private String originalStatus;

  private String reasonCodeBo;

  private String released;

  private String releasedByBo;

  private String releasedDateTime;

  private String releaseComments;

  private String sfcBo;

  private BigDecimal holdId;

  private String userBo;

  private String comments;

  private Date dateTime;


  public ViewPkgContainerHold() {
  }

  public ViewPkgContainerHold(ViewPkgContainerHold data) {
    this.id = data.id;
    this.containerName = data.containerName;
    this.packingPlanBo = data.packingPlanBo;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.itemLevel = data.itemLevel;
    this.containerType = data.containerType;
    this.pkgContainerBo = data.pkgContainerBo;
    this.currStep = data.currStep;
    this.stateName = data.stateName;
    this.customerItemsetBo = data.customerItemsetBo;
    this.customerItemBo = data.customerItemBo;
    this.itemBo = data.itemBo;
    this.goodBad = data.goodBad;
    this.packingTime = data.packingTime;
    this.itemName = data.itemName;
    this.operationName = data.operationName;
    this.packingUser = data.packingUser;
    this.goodDie = data.goodDie;
    this.badDie1 = data.badDie1;
    this.badDie2 = data.badDie2;
    this.dnNo = data.dnNo;
    this.containerSeqId = data.containerSeqId;
    this.customerItemsetNames = data.customerItemsetNames;
    this.customerItemNames = data.customerItemNames;
    this.flagCustomerSpecialPackage = data.flagCustomerSpecialPackage;
    this.flagSplitByCustomerItemset = data.flagSplitByCustomerItemset;
    this.holdDetailBo = data.holdDetailBo;
    this.holdContextGBo = data.holdContextGBo;
    this.holdLogBo = data.holdLogBo;
    this.holdStatus = data.holdStatus;
    this.originalStatus = data.originalStatus;
    this.reasonCodeBo = data.reasonCodeBo;
    this.released = data.released;
    this.releasedByBo = data.releasedByBo;
    this.releasedDateTime = data.releasedDateTime;
    this.releaseComments = data.releaseComments;
    this.sfcBo = data.sfcBo;
    this.holdId = data.holdId;
    this.userBo = data.userBo;
    this.comments = data.comments;
    this.dateTime = data.dateTime;
  }

  @Override
  public ViewPkgContainerHold clone() {
    return new ViewPkgContainerHold(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getContainerName() {
    return containerName;
  }

  public void setContainerName(String containerName) {
    this.containerName = containerName;
  }

  public String getPackingPlanBo() {
    return packingPlanBo;
  }

  public void setPackingPlanBo(String packingPlanBo) {
    this.packingPlanBo = packingPlanBo;
  }

  public String getItemGroupBo() {
    return itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getOperationBo() {
    return operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getItemLevel() {
    return itemLevel;
  }

  public void setItemLevel(String itemLevel) {
    this.itemLevel = itemLevel;
  }

  public String getContainerType() {
    return containerType;
  }

  public void setContainerType(String containerType) {
    this.containerType = containerType;
  }

  public String getPkgContainerBo() {
    return pkgContainerBo;
  }

  public void setPkgContainerBo(String pkgContainerBo) {
    this.pkgContainerBo = pkgContainerBo;
  }

  public String getCurrStep() {
    return currStep;
  }

  public void setCurrStep(String currStep) {
    this.currStep = currStep;
  }

  public String getStateName() {
    return stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCustomerItemsetBo() {
    return customerItemsetBo;
  }

  public void setCustomerItemsetBo(String customerItemsetBo) {
    this.customerItemsetBo = customerItemsetBo;
  }

  public String getCustomerItemBo() {
    return customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getItemBo() {
    return itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getGoodBad() {
    return goodBad;
  }

  public void setGoodBad(String goodBad) {
    this.goodBad = goodBad;
  }

  public Date getPackingTime() {
    return packingTime;
  }

  public void setPackingTime(Date packingTime) {
    this.packingTime = packingTime;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getOperationName() {
    return operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  public String getPackingUser() {
    return packingUser;
  }

  public void setPackingUser(String packingUser) {
    this.packingUser = packingUser;
  }

  public BigDecimal getGoodDie() {
    return goodDie;
  }

  public void setGoodDie(BigDecimal goodDie) {
    this.goodDie = goodDie;
  }

  public BigDecimal getBadDie1() {
    return badDie1;
  }

  public void setBadDie1(BigDecimal badDie1) {
    this.badDie1 = badDie1;
  }

  public BigDecimal getBadDie2() {
    return badDie2;
  }

  public void setBadDie2(BigDecimal badDie2) {
    this.badDie2 = badDie2;
  }

  public String getDnNo() {
    return dnNo;
  }

  public void setDnNo(String dnNo) {
    this.dnNo = dnNo;
  }

  public String getContainerSeqId() {
    return containerSeqId;
  }

  public void setContainerSeqId(String containerSeqId) {
    this.containerSeqId = containerSeqId;
  }

  public String getCustomerItemsetNames() {
    return customerItemsetNames;
  }

  public void setCustomerItemsetNames(String customerItemsetNames) {
    this.customerItemsetNames = customerItemsetNames;
  }

  public String getCustomerItemNames() {
    return customerItemNames;
  }

  public void setCustomerItemNames(String customerItemNames) {
    this.customerItemNames = customerItemNames;
  }

  public String getFlagCustomerSpecialPackage() {
    return flagCustomerSpecialPackage;
  }

  public void setFlagCustomerSpecialPackage(String flagCustomerSpecialPackage) {
    this.flagCustomerSpecialPackage = flagCustomerSpecialPackage;
  }

  public String getFlagSplitByCustomerItemset() {
    return flagSplitByCustomerItemset;
  }

  public void setFlagSplitByCustomerItemset(String flagSplitByCustomerItemset) {
    this.flagSplitByCustomerItemset = flagSplitByCustomerItemset;
  }

  public String getHoldDetailBo() {
    return holdDetailBo;
  }

  public void setHoldDetailBo(String holdDetailBo) {
    this.holdDetailBo = holdDetailBo;
  }

  public String getHoldContextGBo() {
    return holdContextGBo;
  }

  public void setHoldContextGBo(String holdContextGBo) {
    this.holdContextGBo = holdContextGBo;
  }

  public String getHoldLogBo() {
    return holdLogBo;
  }

  public void setHoldLogBo(String holdLogBo) {
    this.holdLogBo = holdLogBo;
  }

  public String getHoldStatus() {
    return holdStatus;
  }

  public void setHoldStatus(String holdStatus) {
    this.holdStatus = holdStatus;
  }

  public String getOriginalStatus() {
    return originalStatus;
  }

  public void setOriginalStatus(String originalStatus) {
    this.originalStatus = originalStatus;
  }

  public String getReasonCodeBo() {
    return reasonCodeBo;
  }

  public void setReasonCodeBo(String reasonCodeBo) {
    this.reasonCodeBo = reasonCodeBo;
  }

  public String getReleased() {
    return released;
  }

  public void setReleased(String released) {
    this.released = released;
  }

  public String getReleasedByBo() {
    return releasedByBo;
  }

  public void setReleasedByBo(String releasedByBo) {
    this.releasedByBo = releasedByBo;
  }

  public String getReleasedDateTime() {
    return releasedDateTime;
  }

  public void setReleasedDateTime(String releasedDateTime) {
    this.releasedDateTime = releasedDateTime;
  }

  public String getReleaseComments() {
    return releaseComments;
  }

  public void setReleaseComments(String releaseComments) {
    this.releaseComments = releaseComments;
  }

  public String getSfcBo() {
    return sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public BigDecimal getHoldId() {
    return holdId;
  }

  public void setHoldId(BigDecimal holdId) {
    this.holdId = holdId;
  }

  public String getUserBo() {
    return userBo;
  }

  public void setUserBo(String userBo) {
    this.userBo = userBo;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Date getDateTime() {
    return dateTime;
  }

  public void setDateTime(Date dateTime) {
    this.dateTime = dateTime;
  }
}
