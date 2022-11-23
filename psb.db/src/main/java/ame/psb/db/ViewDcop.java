package ame.psb.db;

public class ViewDcop extends Dcop {

  private String dcGroupName;

  private String dcGroupDescription;

  private String itemGroupName;

  private String operationName;

  private String holdOperationName;

  private String dcGroupStatusBo;

  private String currentRevision;

  public ViewDcop() {
    this.currentRevision = "true";
  }

  public String getDcGroupName() {
    return this.dcGroupName;
  }

  public void setDcGroupName(String dcGroupName) {
    this.dcGroupName = dcGroupName;
  }

  public String getDcGroupDescription() {
    return this.dcGroupDescription;
  }

  public void setDcGroupDescription(String dcGroupDescription) {
    this.dcGroupDescription = dcGroupDescription;
  }

  public String getItemGroupName() {
    return this.itemGroupName;
  }

  public void setItemGroupName(String itemGroupName) {
    this.itemGroupName = itemGroupName;
  }

  public String getOperationName() {
    return this.operationName;
  }

  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  public String getHoldOperationName() {
    return this.holdOperationName;
  }

  public void setHoldOperationName(String holdOperationName) {
    this.holdOperationName = holdOperationName;
  }

  public String getCurrentRevision() {
    return this.currentRevision;
  }

  public void setCurrentRevision(String currentRevision) {
    this.currentRevision = currentRevision;
  }

  public String getDcGroupStatusBo() {
    return this.dcGroupStatusBo;
  }

  public void setDcGroupStatusBo(String dcGroupStatusBo) {
    this.dcGroupStatusBo = dcGroupStatusBo;
  }

}
