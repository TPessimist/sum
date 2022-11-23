package ame.psb.db;

public class ViewRunMtSfc extends RunMtSfc {

  private String resourceName;

  private String sfcName;

  private String productBo;

  private String inventoryId;

  private String itemBo;

  private String itemName;

  private String description;

  public ViewRunMtSfc() {
  }

  public ViewRunMtSfc(ViewRunMtSfc data) {
    super(data);
    this.resourceName = data.resourceName;
    this.sfcName = data.sfcName;
    this.productBo = data.productBo;
    this.inventoryId = data.inventoryId;
    this.itemBo = data.itemBo;
    this.itemName = data.itemName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getResourceName() {
    return this.resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public String getSfcName() {
    return this.sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

  public String getProductBo() {
    return this.productBo;
  }

  public void setProductBo(String productBo) {
    this.productBo = productBo;
  }

  public String getInventoryId() {
    return this.inventoryId;
  }

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public String getItemBo() {
    return this.itemBo;
  }

  public void setItemBo(String itemBo) {
    this.itemBo = itemBo;
  }

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  @Override
  public ViewRunMtSfc clone() {
    return new ViewRunMtSfc(this);
  }
}
