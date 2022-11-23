package ame.psb.db;

public class ZdIncomingMapConfig {

  private String deviceName;

  private String operation;

  private String ftpSubId;

  private String ftpValue;

  private int sequence;

  public ZdIncomingMapConfig() {
  }

  public ZdIncomingMapConfig(ZdIncomingMapConfig data) {
    this.deviceName = data.deviceName;
    this.operation = data.operation;
    this.ftpSubId = data.ftpSubId;
    this.ftpValue = data.ftpValue;
    this.sequence = data.sequence;
  }

  public String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public String getFtpSubId() {
    return ftpSubId;
  }

  public void setFtpSubId(String ftpSubId) {
    this.ftpSubId = ftpSubId;
  }

  public String getFtpValue() {
    return ftpValue;
  }

  public void setFtpValue(String ftpValue) {
    this.ftpValue = ftpValue;
  }

  public int getSequence() {
    return sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }

  @Override
  public ZdIncomingMapConfig clone() {
    return new ZdIncomingMapConfig(this);
  }

  @Override
  public String toString() {
    return this.deviceName + ", " + this.operation + ", " + this.ftpSubId + ", " + sequence;
  }
}
