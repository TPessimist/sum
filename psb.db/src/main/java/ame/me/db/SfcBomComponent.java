package ame.me.db;

public class SfcBomComponent {

  private String sfcBo;

  private String bomBo;

  private String operationBo;

  private String itemBo;

  private String itemName;

  public SfcBomComponent() {
  }

  public SfcBomComponent(SfcBomComponent data) {
    this.sfcBo = data.sfcBo;
    this.bomBo = data.bomBo;
    this.operationBo = data.operationBo;
    this.itemBo = data.itemBo;
    this.itemName = data.itemName;
  }

  public String getSfcBo() {
    return this.sfcBo;
  }

  public void setSfcBo(String sfcBo) {
    this.sfcBo = sfcBo;
  }

  public String getBomBo() {
    return this.bomBo;
  }

  public void setBomBo(String bomBo) {
    this.bomBo = bomBo;
  }

  public String getOperationBo() {
    return this.operationBo;
  }

  public void setOperationBo(String operationBo) {
    this.operationBo = operationBo;
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
  public SfcBomComponent clone() {
    return new SfcBomComponent(this);
  }

  @Override
  public String toString() {
    return this.sfcBo;
  }
}
