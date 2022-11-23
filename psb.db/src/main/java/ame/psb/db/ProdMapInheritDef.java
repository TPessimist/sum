package ame.psb.db;

import java.util.UUID;

public class ProdMapInheritDef {

  private String id;

  private String deviceName;

  private String operation;

  private String inheritOperation;

  private String inheritDevice;


  public ProdMapInheritDef() {
    this.id = UUID.randomUUID().toString();
  }

  public ProdMapInheritDef(ProdMapInheritDef data) {
    this.id = data.id;
    this.deviceName = data.deviceName;
    this.operation = data.operation;
    this.inheritOperation = data.inheritOperation;
    this.inheritDevice = data.inheritDevice;
  }

  @Override
  public ProdMapInheritDef clone() {
    return new ProdMapInheritDef(this);
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

  public String getInheritOperation() {
    return inheritOperation;
  }

  public void setInheritOperation(String inheritOperation) {
    this.inheritOperation = inheritOperation;
  }

  public String getInheritDevice() {
    return inheritDevice;
  }

  public void setInheritDevice(String inheritDevice) {
    this.inheritDevice = inheritDevice;
  }
}
