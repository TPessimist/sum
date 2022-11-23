package ame.psb.db;

public class MtItemSlot {

  private String itemBo;

  private String resourceBo;

  private String slotName;

  private int inventoryMax;

  private String stateName;

  public MtItemSlot() {
  }

  public MtItemSlot(MtItemSlot data) {
    this.itemBo = data.itemBo;
    this.resourceBo = data.resourceBo;
    this.slotName = data.slotName;
    this.inventoryMax = data.inventoryMax;
    this.stateName = data.stateName;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getResourceBo() {
    return this.resourceBo;
  }

  public void setResourceBo(String resourceBo) {
    this.resourceBo = resourceBo;
  }

  public String getSlotName() {
    return this.slotName;
  }

  public void setSlotName(String slotName) {
    this.slotName = slotName;
  }

  public int getInventoryMax() {
    return this.inventoryMax;
  }

  public void setInventoryMax(int inventoryMax) {
    this.inventoryMax = inventoryMax;
  }

  public String getStateName() {
    return this.stateName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  @Override
  public MtItemSlot clone() {
    return new MtItemSlot(this);
  }

  @Override
  public String toString() {
    return this.itemBo + ", " + this.resourceBo + ", " + this.slotName;
  }
}
