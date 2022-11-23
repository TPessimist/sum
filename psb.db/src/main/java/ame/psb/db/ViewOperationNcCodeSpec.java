package ame.psb.db;

public class ViewOperationNcCodeSpec extends NcOperationCodeSpec {

  private String ncCodeName;

  private String ncCodeDesc;

  private String operationName;

  private String deviceName;

  private String deviceDesc;

  public ViewOperationNcCodeSpec() {
  }

  public ViewOperationNcCodeSpec(ViewOperationNcCodeSpec data) {
    super(data);
    this.ncCodeName = data.ncCodeName;
    this.ncCodeDesc = data.ncCodeDesc;
    this.operationName = data.operationName;
    this.deviceName = data.deviceName;
    this.deviceDesc = data.deviceDesc;
  }

  public String getNcCodeName() {
    return this.ncCodeName;
  }

  public void setNcCodeName(String ncCodeName) {
    this.ncCodeName = ncCodeName;
  }

  public String getNcCodeDesc() {
    return this.ncCodeDesc;
  }

  public void setNcCodeDesc(String ncCodeDesc) {
    this.ncCodeDesc = ncCodeDesc;
  }

  public String getOperationName() {
    return this.operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  public String getDeviceName() {
    return this.deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getDeviceDesc() {
    return this.deviceDesc;
  }

  public void setDeviceDesc(String deviceDesc) {
    this.deviceDesc = deviceDesc;
  }

  @Override
  public ViewOperationNcCodeSpec clone() {
    return new ViewOperationNcCodeSpec(this);
  }
}
