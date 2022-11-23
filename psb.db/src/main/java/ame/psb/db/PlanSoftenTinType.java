package ame.psb.db;

public class PlanSoftenTinType {

  private String inventoryId;

  private String type;

  private String itemName;

  private String standards;

  private String suppiler;

  private String reversed1;

  private String reversed2;


  public PlanSoftenTinType() {
  }

  public PlanSoftenTinType(PlanSoftenTinType data) {
    this.inventoryId = data.inventoryId;
    this.type = data.type;
    this.itemName = data.itemName;
    this.standards = data.standards;
    this.suppiler = data.suppiler;
    this.reversed1 = data.reversed1;
    this.reversed2 = data.reversed2;
  }

  public String getInventoryId() {
    return inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getStandards() {
    return standards;
  }

  public void setStandards(String standards) {
    this.standards = standards;
  }

  public String getSuppiler() {
    return suppiler;
  }

  public void setSuppiler(String suppiler) {
    this.suppiler = suppiler;
  }

  public String getReversed1() {
    return reversed1;
  }

  public void setReversed1(String reversed1) {
    this.reversed1 = reversed1;
  }

  public String getReversed2() {
    return reversed2;
  }

  public void setReversed2(String reversed2) {
    this.reversed2 = reversed2;
  }

  @Override
  public PlanSoftenTinType clone() {
    return new PlanSoftenTinType(this);
  }

  @Override
  public String toString() {
    return this.inventoryId;
  }
}
