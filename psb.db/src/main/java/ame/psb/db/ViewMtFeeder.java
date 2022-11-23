package ame.psb.db;

public class ViewMtFeeder extends MtFeeder {

  private String slotType;

  private String slotStateName;

  private String site;

  private String inventoryId;

  private String itemBo;

  private String itemName;

  private String itemRevision;

  private String itemGroupBo;

  private String itemDescription;

  public ViewMtFeeder() {
  }

  public ViewMtFeeder(ViewMtFeeder data) {
    super(data);
    this.slotType = data.slotType;
    this.slotStateName = data.slotStateName;
    this.site = data.site;
    this.itemBo = data.itemBo;
  }

  public String getSlotType() {
    return this.slotType;
  }

  public void setSlotType(String slotType) {
    this.slotType = slotType;
  }

  public String getSlotStateName() {
    return this.slotStateName;
  }

  public void setSlotStateName(String slotStateName) {
    this.slotStateName = slotStateName;
  }

  public String getSite() {
    return this.site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getInventoryId() {
    return this.inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemRevision() {
    return this.itemRevision;
  }

  public void setItemRevision(String itemRevision) {
    this.itemRevision = itemRevision;
  }

  public String getItemGroupBo() {
    return this.itemGroupBo;
  }

  public void setItemGroupBo(String itemGroupBo) {
    this.itemGroupBo = itemGroupBo;
  }

  public String getItemDescription() {
    return this.itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  @Override
  public ViewMtFeeder clone() {
    return new ViewMtFeeder(this);
  }
}
