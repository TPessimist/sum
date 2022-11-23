package ame.psb.db;

import javax.persistence.Entity;

@Entity
public class ViewSamplingPlan extends SamplingPlan {

  private String customerName;

  private String deviceName;

  private String itemName;

  private String itemRevision;

  private String measurementOperation;

  private String dcGroup;

  private String dcGroupRevision;

  private int level;

  public String getCustomerName() {
    return this.customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getDeviceName() {
    return this.deviceName;
  }

  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemRevision() {
    return this.itemRevision;
  }

  public void setItemRevision(String itemRevision) {
    this.itemRevision = itemRevision;
  }

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

  public int getLevel() {
    return this.level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

}
