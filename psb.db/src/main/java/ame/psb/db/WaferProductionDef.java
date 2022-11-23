package ame.psb.db;

public class WaferProductionDef { //晶圆扣账接口查询的实体类

  private String sfc; //生产批号

  private String waferid; //晶圆id

  private String deviceName; //机种

  private String lot; //客户批号

  private String operation; //站点

  private String flag; //扣账类型

  private String qty; //数量

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getWaferid() {
    return waferid;
  }

  public void setWaferid(String waferid) {
    this.waferid = waferid;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getLot() {
    return lot;
  }

  public void setLot(String lot) {
    this.lot = lot;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getQty() {
    return qty;
  }

  public void setQty(String qty) {
    this.qty = qty;
  }
}
