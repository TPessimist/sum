package ame.psb.db;

public class SpcAlarmDataMaster {

  private String id;

  private String sfc;

  private String processFlag;

  private String requestId;

  private String function;


  public SpcAlarmDataMaster() {
  }

  public SpcAlarmDataMaster(String id, String sfc, String processFlag, String requestId,
      String function) {
    this.id = id;
    this.sfc = sfc;
    this.processFlag = processFlag;
    this.requestId = requestId;
    this.function = function;
  }

  public SpcAlarmDataMaster(SpcAlarmDataMaster data) {
    this.id = data.id;
    this.sfc = data.sfc;
    this.processFlag = data.processFlag;
    this.requestId = data.requestId;
    this.function = data.function;
  }

  @Override
  public SpcAlarmDataMaster clone() {
    return new SpcAlarmDataMaster(this);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSfc() {
    return sfc;
  }

  public void setSfc(String sfc) {
    this.sfc = sfc;
  }

  public String getProcessFlag() {
    return processFlag;
  }

  public void setProcessFlag(String processFlag) {
    this.processFlag = processFlag;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getFunction() {
    return function;
  }

  public void setFunction(String function) {
    this.function = function;
  }


}