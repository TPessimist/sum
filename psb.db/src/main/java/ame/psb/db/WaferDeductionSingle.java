package ame.psb.db;

public class WaferDeductionSingle {

  private String uuid; //主键

  private String sfc; //批次号

  private String wafer; //晶圆编号

  private String devicename; //机种

  private String lot; //客户批号

  private String operation; //站点

  private String waferid; //片号

  private String qty; //数量

  private String comment; //箱号

  private String description; //厂内料号

  private String value; //sap料号


  public WaferDeductionSingle() {
  }

  public WaferDeductionSingle(WaferDeductionSingle data) {
    this.uuid = data.uuid;
    this.sfc = data.sfc;
    this.wafer = data.wafer;
    this.devicename = data.devicename;
    this.lot = data.lot;
    this.operation = data.operation;
    this.waferid = data.waferid;
    this.qty = data.qty;
    this.comment = data.comment;
    this.description = data.description;
    this.value = data.value;
  }

  @Override
  public WaferDeductionSingle clone() {
    return new WaferDeductionSingle(this);
  }

  @Override
  public String toString() {
    return this.uuid;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getWafer() {
    return wafer;
  }

  public void setWafer(String wafer) {
    this.wafer = wafer;
  }

  public String getDevicename() {
    return devicename;
  }

  public void setDevicename(String devicename) {
    this.devicename = devicename;
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

  public String getWaferid() {
    return waferid;
  }

  public void setWaferid(String waferid) {
    this.waferid = waferid;
  }

  public String getQty() {
    return qty;
  }

  public void setQty(String qty) {
    this.qty = qty;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
