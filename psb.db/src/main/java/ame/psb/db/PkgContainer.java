package ame.psb.db;

import java.util.Date;

public class PkgContainer extends AbstractLoggable {

  private String id;

  private String containerName;

  private String packingPlanBo;

  private String itemGroupBo;

  private String operationBo;

  private String itemLevel;

  private String containerType;

  private String pkgContainerBo;

  private String boxStep;

  private String stateName;

  private String customerItemLotBo;

  private String customerItemBo;

  private String itemBo;

  private String goodBad;

  private Date packingTime;

  private int goodDie;

  private int badDie1;

  private int badDie2;

  private String packingUser;

  private String dnNo;

  private String containerSeqId;

  private String customerItemLotNames;

  private String customerItemNames;

  private String flagCustomerSpecialPackage;

  private String flagSplitByCustomerItemset;

  private String containerWeight;

  private String containerVolume;

  private String passUser;

  public PkgContainer() {
  }

  public PkgContainer(PkgContainer data) {
    this.id = data.id;
    this.containerName = data.containerName;
    this.packingPlanBo = data.packingPlanBo;
    this.itemGroupBo = data.itemGroupBo;
    this.operationBo = data.operationBo;
    this.itemLevel = data.itemLevel;
    this.containerType = data.containerType;
    this.pkgContainerBo = data.pkgContainerBo;
    this.boxStep = data.boxStep;
    this.stateName = data.stateName;
    this.customerItemLotBo = data.customerItemLotBo;
    this.customerItemBo = data.customerItemBo;
    this.itemBo = data.itemBo;
    this.goodBad = data.goodBad;
    this.packingTime = data.packingTime;
    this.packingUser = data.packingUser;
    this.goodDie = data.goodDie;
    this.badDie1 = data.badDie1;
    this.badDie2 = data.badDie2;
    this.dnNo = data.dnNo;
    this.flagCustomerSpecialPackage = data.flagCustomerSpecialPackage;
    this.flagSplitByCustomerItemset = data.flagSplitByCustomerItemset;
    this.passUser = data.passUser;
  }

  public String getContainerVolume() {
    return containerVolume;
  }

  public void setContainerVolume(String containerVolume) {
    this.containerVolume = containerVolume;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getContainerName() {
    return this.containerName;
  }

  public void setContainerName(String containerName) {
    this.containerName = containerName;
  }

  public String getPackingPlanBo() {
    return this.packingPlanBo;
  }

  public void setPackingPlanBo(String packingPlanBo) {
    this.packingPlanBo = packingPlanBo;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
  }

  public String getItemLevel() {
    return this.itemLevel;
  }

  public void setItemLevel(String itemLevel) {
    this.itemLevel = itemLevel;
  }

  public String getContainerType() {
    return this.containerType;
  }

  public void setContainerType(String containerType) {
    this.containerType = containerType;
  }

  public String getPkgContainerBo() {
    return this.pkgContainerBo;
  }

  public void setPkgContainerBo(String pkgContainerBo) {
    this.pkgContainerBo = pkgContainerBo;
  }

  public String getBoxStep() {
    return this.boxStep;
  }

  public void setBoxStep(String boxStep) {
    this.boxStep = boxStep;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getCustomerItemLotBo() {
    return this.customerItemLotBo;
  }

  public void setCustomerItemLotBo(String customreItemLotBo) {
    this.customerItemLotBo = customreItemLotBo;
  }

  public String getCustomerItemBo() {
    return this.customerItemBo;
  }

  public void setCustomerItemBo(String customerItemBo) {
    this.customerItemBo = customerItemBo;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getGoodBad() {
    return this.goodBad;
  }

  public void setGoodBad(String goodBad) {
    this.goodBad = goodBad;
  }

  public Date getPackingTime() {
    return this.packingTime;
  }

  public void setPackingTime(Date packingTime) {
    this.packingTime = packingTime;
  }

  public int getGoodDie() {
    return this.goodDie;
  }

  public void setGoodDie(int goodDie) {
    this.goodDie = goodDie;
  }

  public int getBadDie1() {
    return this.badDie1;
  }

  public void setBadDie1(int badDie1) {
    this.badDie1 = badDie1;
  }

  public int getBadDie2() {
    return this.badDie2;
  }

  public void setBadDie2(int badDie2) {
    this.badDie2 = badDie2;
  }

  public String getPackingUser() {
    return this.packingUser;
  }

  public void setPackingUser(String packingUser) {
    this.packingUser = packingUser;
  }

  public String getDnNo() {
    return this.dnNo;
  }

  public void setDnNo(String dnNo) {
    this.dnNo = dnNo;
  }

  public String getContainerSeqId() {
    return this.containerSeqId;
  }

  public void setContainerSeqId(String containerSeqId) {
    this.containerSeqId = containerSeqId;
  }

  public String getCustomerItemLotNames() {
    return this.customerItemLotNames;
  }

  public void setCustomerItemLotNames(String customerItemLotNames) {
    this.customerItemLotNames = customerItemLotNames;
  }

  public String getCustomerItemNames() {
    return this.customerItemNames;
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

  public String getContainerWeight() {
    return containerWeight;
  }

  public void setContainerWeight(String containerWeight) {
    this.containerWeight = containerWeight;
  }

  public String getPassUser() {
    return passUser;
  }

  public void setPassUser(String passUser) {
    this.passUser = passUser;
  }

  @Override
  public PkgContainer clone() {
    return new PkgContainer(this);
  }

  @Override
  public String getTableName() {
    return "ZD_DC_PLAN";
  }

  @Override
  public String getLogUser() {
    return this.packingUser;
  }

  @Override
  public Date getLogDateTime() {
    return this.packingTime;
  }

  @Override
  public String toString() {
    return String.format("%s %s plan:%s, %s, dies(%s,%s,%s)",
        this.id,
        this.containerName,
        this.packingPlanBo,
        this.itemBo,
        this.goodDie,
        this.badDie1,
        this.badDie2);
  }
}