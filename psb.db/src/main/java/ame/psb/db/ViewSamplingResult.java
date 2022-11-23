package ame.psb.db;

public class ViewSamplingResult extends SamplingResult {

  private String measurementOperation;

  private String dcGroup;

  private String dcGroupRevision;

  private String carrierName;

  private String sfcName;

  public String getMeasurementOperation() {
    return this.measurementOperation;
  }

  public void setMeasurementOperation(String measurementOperation) {
    this.measurementOperation = measurementOperation;
  }

  public String getDcGroup() {
    return this.dcGroup;
  }

  public void setDcGroup(String dcGroup) {
    this.dcGroup = dcGroup;
  }

  public String getDcGroupRevision() {
    return this.dcGroupRevision;
  }

  public void setDcGroupRevision(String dcGroupRevision) {
    this.dcGroupRevision = dcGroupRevision;
  }

  public String getCarrierName() {
    return this.carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  public String getSfcName() {
    return this.sfcName;
  }

  public void setSfcName(String sfcName) {
    this.sfcName = sfcName;
  }

}
